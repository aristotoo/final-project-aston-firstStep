package com.aston.project.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Класс ApplicationRunner отвечает за запуск консольного интерфейса приложения,
 * предоставляемого классом ConsoleView и управление его жизненным циклом.
 */
public class ApplicationRunner {
    private static final ConsoleView view = new ConsoleView();
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Object> collection = new ArrayList<>(); // Заглушка
    private static final List<String> classes = new ArrayList<>(List.of("Animal", "Person", "Barrel")); // Заглушка
    private static boolean running = true;
    public static int collectionLength;


    /**
     * Запускает основной цикл приложения.
     */
    private static void startApplication() {
        while (running) {
            view.displayWelcomeMessage();
            handleWelcomeChoice();
        }
        scanner.close();
    }

    /**
     * Запрашивает у пользователя выбор из заданного диапазона.
     *
     * @param min минимальное значение выбора
     * @param max максимальное значение выбора
     * @return выбор пользователя
     */
    private static int getUserChoice(int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < min || choice > max) {
                    view.displayInputError("Пожалуйста, введите число от " + min + " до " + max + ".");
                }
            } catch (NumberFormatException e) {
                view.displayInputError("Пожалуйста, введите число от " + min + " до " + max + ".");
            }
        }
        return choice;
    }

    /**
     * Обрабатывает выбор пользователя на начальном экране,
     * позволяя выбрать способ заполнения коллекции.
     */
    private static void handleWelcomeChoice() {
        final int FILE_FILLING = 1;
        final int RANDOM_FILLING = 2;
        final int MANUAL_FILLING = 3;
        final int EXIT = 0;
        int choice = getUserChoice(EXIT, MANUAL_FILLING);
        switch (choice) {
            case FILE_FILLING:
                //присваиваем стратегию FileCollectionFillStrategy
                handleEntity();
                break;
            case RANDOM_FILLING:
                //присваиваем стратегию ManualCollectionFillStrategy
                handleEntity();
                break;
            case MANUAL_FILLING:
                //присваиваем стратегию RandomDataCollectionFillStrategy
                handleEntity();
                break;
            case EXIT:
                running = false;
                break;
        }
    }

    /**
     * Обрабатывает выбор сущности для заполнения коллекции.
     */
    private static void handleEntity() {
        view.displayEntitySelection(classes); //classes коллекция заглушка с названиями классов
        final int ANIMAL_FILLING = 1;
        final int PERSON_FILLING = 2;
        final int BARREL_FILLING = 3;
        final int EXIT = 0;
        int choice = getUserChoice(EXIT, BARREL_FILLING);
        //присваиваем тип сущности для нашего варианта заполнения коллекции и устанавливаем размер коллекции
        switch (choice) {
            case ANIMAL_FILLING:
                //вставляем логику для Animal
                handleCollectionSize();
                //запускаем метод fillCollection с аргументом collectionLength
                handleCompletionAction();
                break;
            case PERSON_FILLING:
                //вставляем логику для Person
                handleCollectionSize();
                //запускаем метод fillCollection с аргументом collectionLength
                handleCompletionAction();
                break;
            case BARREL_FILLING:
                //вставляем логику для Barrel
                handleCollectionSize();
                //запускаем метод fillCollection с аргументом collectionLength
                handleCompletionAction();
                break;
            case EXIT:
                running = false;
                break;
        }
    }

    private static void handleCollectionSize() {
        view.displayCollectionSizePrompt();
        collection.clear();
        final int MIN_COLLECTION_SIZE = 1;
        final int MAX_COLLECTION_SIZE = Integer.MAX_VALUE;
        collectionLength = getUserChoice(MIN_COLLECTION_SIZE, MAX_COLLECTION_SIZE);
        view.displayCompletionMessage();
    }

    /**
     * Обрабатывает действия после завершения заполнения коллекции.
     */
    private static void handleCompletionAction() {
        final int DISPLAY_COLLECTION = 1;
        final int SORT_COLLECTION = 2;
        final int BACK_TO_TOP = 3;
        final int EXIT = 0;
        boolean pass = false;
        while (!pass) {
            view.displayCompletionActions();
            int action = getUserChoice(EXIT, BACK_TO_TOP);
            switch (action) {
                case DISPLAY_COLLECTION:
                    view.displayUnsortedCollection(collection); // Заглушка в аргументах
                    break;
                case SORT_COLLECTION:
                    String[] fields = {"name", "age"}; // Пример полей для сортировки, заменить на реальные
                    view.displaySearchPrompt(fields);
                    int sortChoice = getUserChoice(1, fields.length);
                    // Место для логики сортировки коллекции
                    view.displaySortedMessage();
                    pass = true;
                    handleSortedAction();
                    break;
                case BACK_TO_TOP:
                    pass = true;
                    break;
                case EXIT:
                    pass = true;
                    running = false;
                    break;
            }
        }
    }

    /**
     * Обрабатывает действия после завершения сортировки коллекции.
     */
    private static void handleSortedAction() {
        final int DISPLAY_COLLECTION = 1;
        final int SEARCH_ELEMENT = 2;
        final int BACK_TO_TOP = 3;
        final int EXIT = 0;
        boolean pass = false;
        while (!pass) {
            view.displaySortedActions();
            int action = getUserChoice(EXIT, BACK_TO_TOP);
            switch (action) {
                case DISPLAY_COLLECTION:
                    view.displaySortedCollection(collection);
                    break;
                case SEARCH_ELEMENT:
                    view.displaySearchValuePrompt();
                    String searchValue = scanner.nextLine();
                    // Логика для поиска элемента
                    Optional<?> object = Optional.empty(); // Заглушка
                    if (object.isEmpty()) {
                        view.displaySearchResult("Элемент не найден");
                    } else {
                        view.displaySearchResult("Элемент найден: " + searchValue);
                    }
                    break;
                case BACK_TO_TOP:
                    pass = true;
                    break;
                case EXIT:
                    pass = true;
                    running = false;
                    break;
            }
        }
    }
}

