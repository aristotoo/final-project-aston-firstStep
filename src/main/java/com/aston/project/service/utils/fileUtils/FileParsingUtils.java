package com.aston.project.service.utils.fileUtils;

public class FileParsingUtils {
    public static final String ONLY_LETTER_REGEXP = "\\p{L}+";

    private FileParsingUtils(){}

    /**
     * Проверка строки на то что содерджит только буквы.
     *
     * @param s - проверяемая строка
     */
    public static boolean validateString(String s) {
        return s != null && !s.isEmpty() && s.matches(ONLY_LETTER_REGEXP);
    }
}
