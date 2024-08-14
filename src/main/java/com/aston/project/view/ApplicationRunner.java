package com.aston.project.view;

import java.util.*;

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

    /**
     * Главный метод, запускающий приложение.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        startApplication(); // Для проверки работы
    }

    /**
     * Запускает основной цикл приложения.
     */
    private static void startApplication() {
        while (running) {
            view.displayWelcomeMessage();
            int choice = getUserChoice(0, 3);
            handleWelcomeChoice(choice);
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
     * Обрабатывает выбор пользователя на начальном экране.
     *
     * @param choice выбор пользователя
     */
    private static void handleWelcomeChoice(int choice) {
        switch (choice) {
            case 1:
                handleFileFilling();
                break;
            case 2:
                handleRandomFilling();
                break;
            case 3:
                handleManualFilling();
                break;
            case 0:
                running = false;
                break;
        }
    }

    /**
     * Обрабатывает заполнение коллекции данными из файла.
     */
    private static void handleFileFilling() {
        view.displayFileFilling();
        collection.clear();
        boolean pass = false;
        while (!pass) {
            try {
                String filePath = scanner.nextLine();
                // Место для логики заполнения коллекции из файла
                collection.add("someEntity1"); // Заглушка
                collection.add("someEntity2");
                collection.add("someEntity3");
                pass = true;
            } catch (Exception e) {
                view.displayInputError(e.getMessage());
            }
        }
        view.displayCompletionMessage();
        handleCompletionAction();
    }

    /**
     * Обрабатывает заполнение коллекции случайными данными.
     */
    private static void handleRandomFilling() {
        view.displayEntitySelection(classes); // Заглушка внутри аргументов метода
        int entityChoice = getUserChoice(0, classes.size());
        handleRandomEntityChoice(entityChoice);
    }

    /**
     * Обрабатывает выбор сущности для случайного заполнения коллекции.
     *
     * @param choice выбор пользователя
     */
    private static void handleRandomEntityChoice(int choice) {
        view.displayCollectionSizePrompt();
        int size = getUserChoice(1, Integer.MAX_VALUE);
        collection.clear();
        switch (choice) {
            case 1:
                for (int i = 0; i < size; i++) { // Заглушка
                    String name = "RandomAnimalName" + i;
                    String age = String.valueOf(i);
                    collection.add("Animal: " + name + ", Age: " + age);
                }
                break;
            case 2:
                for (int i = 0; i < size; i++) { // Заглушка
                    String name = "RandomPersonName" + i;
                    String age = String.valueOf(i);
                    collection.add("Person: " + name + ", Age: " + age);
                }
                break;
            case 3:
                for (int i = 0; i < size; i++) { // Заглушка
                    String material = "RandomMaterial" + i;
                    String volume = String.valueOf(i);
                    collection.add("Barrel: " + material + ", Volume: " + volume);
                }
                break;
        }
        view.displayCompletionMessage();
        handleCompletionAction();
    }

    /**
     * Обрабатывает ручное заполнение коллекции.
     */
    private static void handleManualFilling() {
        view.displayEntitySelection(classes);
        int entityChoice = getUserChoice(0, classes.size());
        handleEntityChoice(entityChoice);
    }

    /**
     * Обрабатывает выбор сущности для ручного заполнения коллекции.
     *
     * @param choice выбор пользователя
     */
    private static void handleEntityChoice(int choice) {
        switch (choice) {
            case 1:
                handleAnimalManualFilling();
                break;
            case 2:
                handlePersonManualFilling();
                break;
            case 3:
                handleBarrelManualFilling();
                break;
            case 0:
                running = false;
                break;
        }
    }

    /**
     * Обрабатывает ручное заполнение коллекции сущностью Animal.
     */
    private static void handleAnimalManualFilling() {
        view.displayCollectionSizePrompt();
        int size = getUserChoice(1, Integer.MAX_VALUE);
        collection.clear();
        for (int i = 0; i < size; i++) {
            view.displayManualFilling("name"); // Заглушка
            String name = scanner.nextLine();
            view.displayManualFilling("age");
            String age = scanner.nextLine();
            collection.add("Animal: " + name + ", Age: " + age);
        }
        view.displayCompletionMessage();
        handleCompletionAction();
    }

    /**
     * Обрабатывает ручное заполнение коллекции сущностью Person.
     */
    private static void handlePersonManualFilling() {
        view.displayCollectionSizePrompt();
        int size = getUserChoice(1, Integer.MAX_VALUE);
        collection.clear();
        for (int i = 0; i < size; i++) {
            view.displayManualFilling("name"); // Заглушка
            String name = scanner.nextLine();
            view.displayManualFilling("age");
            String age = scanner.nextLine();
            collection.add("Person: " + name + ", Age: " + age);
        }
        view.displayCompletionMessage();
        handleCompletionAction();
    }

    /**
     * Обрабатывает ручное заполнение коллекции сущностью Barrel.
     */
    private static void handleBarrelManualFilling() {
        view.displayCollectionSizePrompt();
        int size = getUserChoice(1, Integer.MAX_VALUE);
        collection.clear();
        for (int i = 0; i < size; i++) {
            view.displayManualFilling("material"); // Заглушка
            String material = scanner.nextLine();
            view.displayManualFilling("volume");
            String volume = scanner.nextLine();
            collection.add("Barrel: " + material + ", Volume: " + volume);
        }
        view.displayCompletionMessage();
        handleCompletionAction();
    }

    /**
     * Обрабатывает действия после завершения заполнения коллекции.
     */
    private static void handleCompletionAction() {
        boolean pass = false;
        while (!pass) {
            view.displayCompletionActions();
            int action = getUserChoice(0, 3);
            switch (action) {
                case 1:
                    view.displayUnsortedCollection(collection); // Заглушка в аргументах
                    break;
                case 2:
                    String[] fields = {"name", "age"}; // Пример полей для сортировки, заменить на реальные
                    view.displaySearchPrompt(fields);
                    int sortChoice = getUserChoice(1, fields.length);
                    // Место для логики сортировки коллекции
                    view.displaySortedMessage();
                    pass = true;
                    handleSortedAction();
                    break;
                case 3:
                    pass = true;
                    break;
                case 0:
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
        boolean pass = false;
        while (!pass) {
            view.displaySortedActions();
            int action = getUserChoice(0, 3);
            switch (action) {
                case 1:
                    view.displaySortedCollection(collection);
                    break;
                case 2:
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
                case 3:
                    pass = true;
                    break;
                case 0:
                    pass = true;
                    running = false;
                    break;
            }
        }
    }
}