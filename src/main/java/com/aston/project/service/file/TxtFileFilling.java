package com.aston.project.service.file;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TxtFileFilling {
    private TypeFillingStrategy typeFillingStrategy;
    private String nameFile;
    private static final String CLEAR_LINE_BREAKS_REGEXP = "[\\n\\r]";
    private static final String CUT_OBJECT_FROM_LINE_REGEXP = "\\{(.*?)}";
    private static final String SEPARATOR_PARAMETER_VALUE = ":";
    private static final String SEPARATOR_PARAMETERS = ",";

    public TxtFileFilling(TypeFillingStrategy typeFillingStrategy, String nameFile) {
        this.typeFillingStrategy = typeFillingStrategy;
        this.nameFile = nameFile;
    }

    public TypeFillingStrategy getTypeFillingStrategy() {
        return typeFillingStrategy;
    }

    public void setTypeFillingStrategy(TypeFillingStrategy typeFillingStrategy) {
        this.typeFillingStrategy = typeFillingStrategy;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    /**
     * Парсинг .txt файла.
     * Формат:
     * {
     * парам:значение,
     * парам:значение,
     * .....
     * },
     * {
     * парам:значение,
     * парам:значение,
     * .....
     * },
     * ....
     * Считывается полностью файл в строку. Удаляются символы переноса строки и и возрата каретки. Далее строка разделяется
     * по {} определяю строку с параметрами для кажого объекта. Проходим по строке и собираем HashMap (ключ - параметр),
     * передаем объекту стретегии для создания объекта.
     */
    public void parsingFile() {
        String fullFile = null;
        try {
            fullFile = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(nameFile).toURI())))
                    .replaceAll(CLEAR_LINE_BREAKS_REGEXP, "");
        } catch (IOException | URISyntaxException e) {
            System.out.println("Error reading file: " + nameFile);
            return;
        }
        Pattern pattern = Pattern.compile(CUT_OBJECT_FROM_LINE_REGEXP);
        Matcher matcher = pattern.matcher(fullFile);
        List<String> lineForObjects = new ArrayList<>();
        while (matcher.find()) {
            lineForObjects.add(matcher.group(1));
        }
        if (lineForObjects.isEmpty()) {
            return;
        }
        for (String line : lineForObjects) {
            String[] split = line.split(SEPARATOR_PARAMETERS);
            Map<String, String> parameters = Stream.of(split)
                    .collect(Collectors.toMap(s1 -> customSplit(s1)[0], s2 -> customSplit(s2)[1]));
            typeFillingStrategy.filling(parameters);
        }

    }

    /**
     * Чтобы избежать ошибки если не указано значение параметра, используем кастомный метод split()
     *
     * @param s - строка для разделения
     */
    private String[] customSplit(String s) {
        String[] split = s.split(SEPARATOR_PARAMETER_VALUE);
        if (split.length < 2) {
            return new String[]{split[0], ""};
        } else {
            return split;
        }
    }
}
