package com.aston.project.service.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TxtFileParser<T> implements FileParser<T> {
    private final EntityParser<T> entityParser;
    private final String nameFile;
    private static final String CLEAR_LINE_BREAKS_REGEXP = "[\\n\\r]";
    private static final String CUT_OBJECT_FROM_LINE_REGEXP = "\\{(.*?)}";
    private static final String SEPARATOR_PARAMETER_VALUE = ":";
    private static final String SEPARATOR_PARAMETERS = ",";

    public TxtFileParser(EntityParser<T> entityParser, String nameFile) {
        this.entityParser = entityParser;
        this.nameFile = nameFile;
    }

    /**
     * Парсинг файла.
     * Считываем файл в строку.
     * Формат:
     * {парам:значение,парам:значение,...},
     * {парам:значение,парам:значение,...},
     * .....
     * Разбиваем строку на строки соответсвующие entity.
     * Каждую строку преобразуем в HashMap имя параметра - значение. И формируем объект entity с помощью EntityParser.
     */
    @Override
    public List<T> parseFile(int length) {
        List<String> stringsObject = readFile(length);
        if (stringsObject.isEmpty()) {
            return new ArrayList<>();
        }
        List<T> parsedEntity = new ArrayList<>();
        for (String line : stringsObject) {
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
     * Построчное считывание файла
     *
     * @param length - требуемое количество данных для считывания
     */
    private List<String> readFile(int length) {
        File file = null;
        try {
            file = new File(getClass().getClassLoader().getResource(nameFile).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        List<String> result = new ArrayList<>(length);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                separateStringToObjectStrings(line).ifPresent(result::add);
                if (result.size() == length) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * Вырезает строку между скобок.
     *
     * @param string - строка (контент файла)
     */
    private Optional<String> separateStringToObjectStrings(String string) {
        Pattern pattern = Pattern.compile(CUT_OBJECT_FROM_LINE_REGEXP);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            return Optional.of(matcher.group(1));
        }
        return Optional.empty();
    }

}
