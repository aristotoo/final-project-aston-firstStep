package com.aston.project.view;

import java.util.List;

/**
 * Класс ConsoleView обеспечивает отображение информации в консоли для взаимодействия с пользователем.
 */
public class ConsoleView {

    /**
     * Отображает приветственное сообщение и меню выбора способа заполнения массива.
     */
    public void displayWelcomeMessage() {
        System.out.println("Добро пожаловать!");
        System.out.println("Выберите способ заполнения массива:");
        System.out.println("1. Заполнить данными из Файла");
        System.out.println("2. Заполнить случайными данными");
        System.out.println("3. Заполнить вручную");
        System.out.println("0. Выход из приложения");
        displayDivider();
    }

    /**
     * Отображает меню выбора сущности для заполнения коллекции.
     */
    public <T> void displayEntitySelection(List<T> entityList) {
        System.out.println("Выберите сущность, которой необходимо заполнить коллекцию:");
        int i = 1;
        for (T entity : entityList) {
            System.out.println(i++ + ". " + entity);
        }
        System.out.println("0. Выход из приложения");
        displayDivider();
    }


    /**
     * Запрашивает у пользователя размер создаваемой коллекции.
     */
    public void displayCollectionSizePrompt() {
        System.out.println("Сколько элементов должно быть в коллекции? Введите целое число:");
        displayDivider();
    }

    /**
     * Отображает сообщение о завершении заполнения коллекции.
     */
    public void displayCompletionMessage() {
        System.out.println("Готово!");
    }

    /**
     * Отображает меню выбора параметра для сортировки коллекции.
     *
     * @param fields массив доступных параметров для сортировки
     */
    public void displaySearchPrompt(List<String> fields) {
        System.out.println("Для сортировки коллекции выберите один из доступных параметров:");
        int i = 1;
        for (String field : fields) {
            System.out.println(i++ + ". " + field.substring(0, 1).toUpperCase() + field.substring(1));
        }
        displayDivider();
    }

    /**
     * Отображает меню с выбором способа сортировки.
     */
    public void displaySearches() {
        System.out.println("Выберите способ сортировки:");
        System.out.println("1. Сортировка чётных элементов");
        System.out.println("2. Сортировка нечётных элементов");
        System.out.println("3. Сортировка вставкой");
        displayDivider();
    }

    /**
     * Отображает разделитель текста.
     */
    public void displayDivider() {
        System.out.println("-----------------------------------------------------------");
    }

    /**
     * Отображает сообщение о завершении сортировки коллекции.
     */
    public void displaySortedMessage() {
        System.out.println("Коллекция отсортирована!");
    }

    /**
     * Запрашивает у пользователя значение искомого элемента.
     */
    public void displaySearchValuePrompt() {
        System.out.println("Введите значение искомого элемента:");
        displayDivider();
    }

    /**
     * Отображает результат поиска элемента.
     *
     * @param <T>    тип элемента
     * @param result результат поиска
     */
    public <T> void displaySearchResult(T result) {
        System.out.println("***********************************************************");
        System.out.println(result);
        System.out.println("***********************************************************");
    }

    /**
     * Отображает содержимое изначальной коллекции.
     *
     * @param <T>  тип элементов в коллекции
     * @param list список элементов для отображения
     */
    public <T> void displayUnsortedCollection(List<T> list) {
        System.out.println("***********************************************************");
        int i = 1;
        for (T element : list) {
            System.out.println(i++ + ". " + element);
        }
        System.out.println("***********************************************************");
    }

    /**
     * Отображает содержимое отсортированной коллекции.
     *
     * @param <T>  тип элементов в коллекции
     * @param list список элементов для отображения
     */
    public <T> void displaySortedCollection(List<T> list) {
        System.out.println("***********************************************************");
        int i = 1;
        for (T element : list) {
            System.out.println(i++ + ". " + element);
        }
        System.out.println("***********************************************************");
    }

    /**
     * Отображает сообщение об ошибке ввода пользователя.
     * Этот метод вызывается, когда ввод пользователя не соответствует ожидаемому формату или значению.
     *
     * @param errorMessage сообщение об ошибке, которое будет отображено пользователю
     */
    public void displayInputError(String errorMessage) {
        System.out.println("Ошибка ввода: " + errorMessage);
        System.out.println("Пожалуйста, попробуйте снова.");
        displayDivider();
    }

    /**
     * Отображает меню выбора дальнейших действий после завершения заполнения коллекции.
     */
    public void displayCompletionActions() {
        System.out.println("Выберите дальнейшее действие:");
        System.out.println("1. Посмотреть коллекцию");
        System.out.println("2. Сортировать коллекцию");
        System.out.println("3. Вернуться в начало");
        System.out.println("0. Выход из приложения");
        displayDivider();
    }

    /**
     * Отображает меню выбора дальнейших действий после завершения сортировки коллекции.
     */
    public void displaySortedActions() {
        System.out.println("Выберите дальнейшие действия:");
        System.out.println("1. Посмотреть отсортированную коллекцию");
        System.out.println("2. Найти элемент");
        System.out.println("3. Вернуться в начало");
        System.out.println("0. Выход из приложения");
        displayDivider();
    }
}