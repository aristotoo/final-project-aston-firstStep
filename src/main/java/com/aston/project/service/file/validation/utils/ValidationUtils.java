package com.aston.project.service.file.validation.utils;

public class ValidationUtils {
    public static final String ONLY_LETTER_REGEXP = "[a-zA-Zа-яА-Я]+";

    public static boolean validateStringOnlyLetter(String string) {
        return string.isEmpty() || !string.matches(ONLY_LETTER_REGEXP);
    }
}
