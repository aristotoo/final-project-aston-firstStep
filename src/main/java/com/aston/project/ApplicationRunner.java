package com.aston.project;

import com.aston.project.controller.Controller;
import com.aston.project.service.*;
import com.aston.project.service.context.CollectionFillContext;
import com.aston.project.service.context.SortContext;
import com.aston.project.service.utils.Converter;
import com.aston.project.service.utils.Data;
import com.aston.project.view.ConsoleView;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Класс ApplicationRunner отвечает за запуск консольного интерфейса приложения,
 * предоставляемого классом ConsoleView и управление его жизненным циклом.
 */
public class ApplicationRunner {
    private static final ConsoleView view = new ConsoleView();
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Object> collection = new ArrayList<>(); // коллекция
    private static boolean running = true;
    private static int collectionLength; // длина коллекции
    private static int fillStrategyId; // id стратегии заполнения
    private static int entityId; // id сущности
    private static final CollectionFillContext collectionFillContext = new CollectionFillContext();
    private static final SortContext sortContext = new SortContext();
    private static int fieldChoice = 0; //храним выбор поля для бинарного поиска
    private static final Controller controller = new Controller();


    /**
     * Запускает основной цикл приложения.
     */
    public static void startApplication() {
        while (running) {
            view.displayWelcomeMessage(); // отображаем приветственное сообщение с выбором действия
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
     * позволяя выбрать способ заполнения коллекции и сущность.
     */
    private static void handleWelcomeChoice() {
        final int LAST_MENU_ITEM = 3;
        final int EXIT = 0;

        int userChoice = getUserChoice(EXIT, LAST_MENU_ITEM);

        if (userChoice == EXIT) {
            running = false;
        } else {
            fillStrategyId = userChoice; // выбираем стратегию заполнения

            view.displayEntitySelection(Data.classes
                    .stream() //создаём поток из листа классов
                    .map(Class::getSimpleName) //преобразуем элементы потока в названия классов
                    .toList()); //собираем в лист и отображаем

            entityId = getUserChoice(1, Data.classes.size()); // выбираем сущность

            handleCompletionAction(); // переходим на следующий этап
        }
    }


    /**
     * Обрабатывает установку значения размера коллекции.
     */
    private static void handleCollectionSize() {
        view.displayCollectionSizePrompt();
        collection.clear(); // чистим коллекцию
        final int MIN_COLLECTION_SIZE = 1;
        final int MAX_COLLECTION_SIZE = Integer.MAX_VALUE;
        collectionLength = getUserChoice(MIN_COLLECTION_SIZE, MAX_COLLECTION_SIZE); // устанавливаем размер коллекции
    }

    /**
     * Обрабатывает заполнение коллекции, а также действия после завершения.
     */
    private static void handleCompletionAction() {
        // устанавливаем размер коллекции
        handleCollectionSize();

        // создаём стратегию заполнения
        CollectionFillStrategy collectionFillStrategy = Data.collectionFillStrategies.get(fillStrategyId);

        // сетаем филлер
        collectionFillStrategy.setFiller(Data.fillers.get(fillStrategyId).get(entityId));

        // сетаем контекст стратегией
        collectionFillContext.setCollectionFillContext(collectionFillStrategy);

        // сетаем контекст в контроллер
        controller.setControllerFillContext(collectionFillContext);

        // заполняем коллекцию
        collection = controller.fillCollection(collectionLength);

        // уведомляем об успешном заполнении коллекции
        view.displayCompletionMessage();

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
                    view.displayUnsortedCollection(collection); // отображаем коллекцию до сортировки
                    break;
                case SORT_COLLECTION:
                    // выводим пользователю список полей, по которым возможна сортировка
                    view.displaySearchPrompt(Data.classFields
                            .get(entityId) // получем поля
                            .stream() // создаём поток
                            .map(Field::getName) // преобразуем поля в названия полей
                            .toList()); // собираем в лист


                    // запоминаем выбор поля
                    fieldChoice = getUserChoice(1, Data.classFields.get(entityId).size());

                    // отображаем текущий список сортировок
                    view.displaySearches();

                    // выбираем сортировку
                    int sortChoice = getUserChoice(1, Data.sortingStrategies.size());

                    // сетаем стратегию сортировки в контекст
                    sortContext.setSortingStrategy(Data.sortingStrategies.get(sortChoice));

                    // сетаем контекст в контроллер
                    controller.setControllerSortContext(sortContext);

                    // запускаем сортировку
                    controller.sortCollection(collection, Data.functions
                            .get(entityId) // получаем список геттеров для сущности, которую выбрали ранее
                            .get(fieldChoice - 1)); // получаем геттер

                    // уведомляем об успешной сортировке
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
            // отображаем меню выбора действия доступных после сортировки
            view.displaySortedActions();
            int action = getUserChoice(EXIT, BACK_TO_TOP);
            switch (action) {
                case DISPLAY_COLLECTION:
                    view.displaySortedCollection(collection); // отображаем отсортированную коллекцию
                    break;
                case SEARCH_ELEMENT:
                    // запрашиваем ввести значение искомого элемента
                    view.displaySearchValuePrompt();
                    String searchValue = scanner.nextLine();

                    //конвертируем искомый элемент в нужный тип
                    Object objectForSearch = Converter.convertToFieldType(searchValue, Data.classFields
                            .get(entityId) //получаем список полей выбранной сущности
                            .get(fieldChoice - 1) //получаем поле объекта по которому производился поиск
                            .getType()); //получаем тип поля для присвоения нужного типа объекту поиска

                    // ищем элемент в коллекции при помощи контроллера
                    Optional<?> object = controller.search(collection, objectForSearch, Data.functions
                            .get(entityId) // получаем поля сущности
                            .get(fieldChoice - 1)); // получаем геттер поля возвращающий Comparable<Object>

                    // выводим результат поиска
                    if (object.isEmpty()) {
                        view.displaySearchResult("Элемент не найден");
                    } else {
                        view.displaySearchResult("Элемент найден: " + object);
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

