package com.aston.project.service;

import com.aston.project.service.file.EntityParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileCollectionFillStrategy<T> implements CollectionFillStrategy<T> {
    private EntityParser<T> entityParser;
    private String nameFile;
    private static final String CLEAR_LINE_BREAKS_REGEXP = "[\\n\\r]";
    private static final String CUT_OBJECT_FROM_LINE_REGEXP = "\\{(.*?)}";
    private static final String SEPARATOR_PARAMETER_VALUE = ":";
    private static final String SEPARATOR_PARAMETERS = ",";

    public FileCollectionFillStrategy(EntityParser<T> entityParser, String nameFile) {
        this.entityParser = entityParser;
        this.nameFile = nameFile;
    }

    @Override
    public List<T> fillCollection(int length) {
        List<T> collection = new ArrayList<>();
        collection = parsingFile().stream().limit(length).collect(Collectors.toList());
        return collection;
    }


    /**
     * Парсинг файла.
     * Считываем файл в строку.
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
     * Разбиваем строку на строки соответсвующие entity.
     * Каждую строку преобразуем в HashMap имя параметра - значение. И формируем объект entity с помощью EntityParser.
     */
    public List<T> parsingFile() {
        String fullFile = readFileToString();
        List<String> separatedStringToObj = separateStringToObjectStrings(fullFile);
        if (separatedStringToObj.isEmpty()) {
            return new ArrayList<>();
        }
        List<T> parsedEntity = new ArrayList<>();
        for (String line : separatedStringToObj) {
            String[] split = line.split(SEPARATOR_PARAMETERS);
            Map<String, String> parameters = Stream.of(split)
                    .collect(Collectors.toMap(s1 -> customSplit(s1)[0], s2 -> customSplit(s2)[1]));
            entityParser.parsing(parameters).ifPresent(parsedEntity::add);
        }
        return parsedEntity;
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

    /**
     * Считывает весь в файл в строку.
     */
    private String readFileToString() {
        byte[] fileContent = null;
        try {
            Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(nameFile)).toURI());
            fileContent = Files.readAllBytes(path);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return new String(fileContent).replaceAll(CLEAR_LINE_BREAKS_REGEXP, "");
    }

    /**
     * Разбивает строку на строки-объекты
     *
     * @param string - строка (контент файла)
     */
    private List<String> separateStringToObjectStrings(String string) {
        Pattern pattern = Pattern.compile(CUT_OBJECT_FROM_LINE_REGEXP);
        Matcher matcher = pattern.matcher(string);
        List<String> lineForObjects = new ArrayList<>();
        while (matcher.find()) {
            lineForObjects.add(matcher.group(1));
        }
        return lineForObjects;
    }

    public EntityParser<T> getTypeFillingStrategy() {
        return entityParser;
    }

    public void setTypeFillingStrategy(EntityParser<T> entityParser) {
        this.entityParser = entityParser;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }
}
