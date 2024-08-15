package com.aston.project.view;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Утилитарный класс для преобразования строковых значений в различные типы данных.
 */
public final class Converter {

    /**
     * Приватный конструктор для предотвращения создания экземпляров класса.
     */
    private Converter() {}

    /**
     * Преобразует строковое значение в тип данных, соответствующий указанному классу поля.
     *
     * @param input     строковое значение, которое нужно преобразовать.
     * @param fieldType класс типа данных, в который нужно преобразовать строку.
     * @return объект типа, соответствующего указанному классу поля.
     * @throws IllegalArgumentException      если входная строка не соответствует формату ожидаемого типа данных.
     * @throws UnsupportedOperationException если указанный тип поля не поддерживается.
     * @throws RuntimeException             если возникает ошибка при преобразовании значения к типу поля.
     */
    public static Object convertToFieldType(String input, Class<?> fieldType) {
        try {
            if (fieldType == Integer.class || fieldType == int.class) {
                return Integer.parseInt(input);
            } else if (fieldType == Double.class || fieldType == double.class) {
                return Double.parseDouble(input);
            } else if (fieldType == String.class) {
                return input;
            } else if (fieldType == Boolean.class || fieldType == boolean.class) {
                return Boolean.parseBoolean(input);
            } else if (fieldType == Character.class || fieldType == char.class) {
                if (input.length() != 1) {
                    throw new IllegalArgumentException("Нужно ввести один символ");
                }
                return input.charAt(0);
            } else if (fieldType == Float.class || fieldType == float.class) {
                return Float.parseFloat(input);
            } else if (fieldType == Long.class || fieldType == long.class) {
                return Long.parseLong(input);
            } else if (fieldType == Short.class || fieldType == short.class) {
                return Short.parseShort(input);
            } else if (fieldType == Byte.class || fieldType == byte.class) {
                return Byte.parseByte(input);
            } else if (fieldType == BigInteger.class) {
                return new BigInteger(input);
            } else if (fieldType == BigDecimal.class) {
                return new BigDecimal(input);
            } else {
                throw new UnsupportedOperationException("Неподдерживаемый тип поля: " + fieldType);
            }
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception ex) {
            throw new RuntimeException("Невозможно привести значение к типу поля: " + fieldType);
        }
    }
}