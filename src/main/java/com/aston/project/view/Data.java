package com.aston.project.view;

import com.aston.project.model.entity.*;
import com.aston.project.service.*;
import com.aston.project.service.file.*;
import com.aston.project.service.generator.*;
import com.aston.project.service.handler.*;
import com.aston.project.service.sort.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;

/**
 * Класс Data содержит статические коллекции и методы для инициализации и управления данными.
 */
public final class Data {

    /**
     * Коллекция для хранения обработчиков ввода.
     */
    public static final Map<Integer, InputHandler> inputHandlers;

    /**
     * Коллекция для хранения генераторов сущностей.
     */
    public static final Map<Integer, EntityGenerator> entityGenerators;

    /**
     * Коллекция для хранения парсеров файлов.
     */
    public static final Map<Integer, FileParser> fileParsers;

    /**
     * Коллекция для хранения стратегий сортировки.
     */
    public static final Map<Integer, SortingStrategy> sortingStrategies;

    /**
     * Коллекция для хранения стратегий заполнения коллекций.
     */
    public static final Map<Integer, CollectionFillStrategy> collectionFillStrategies;

    /**
     * Список классов сущностей.
     */
    public static final List<Class<?>> classes = Arrays.asList(Animal.class, Barrel.class, Person.class);

    /**
     * Коллекция для хранения полей классов.
     */
    public static final Map<Integer, List<Field>> classFields;

    /**
     * Коллекция для хранения функций, возвращающих сравниваемые объекты.
     */
    public static final Map<Integer, List<Function<Object, Comparable<Object>>>> functions;

    static {
        // Инициализация коллекций
        inputHandlers = initializeInputHandlers();
        entityGenerators = initializeEntityGenerators();
        fileParsers = initializeFileParsers();
        sortingStrategies = initializeSortingStrategies();
        collectionFillStrategies = initializeCollectionFillStrategies();
        classFields = initializeClassFields();
        functions = initializeFunctions();
    }

    /**
     * Инициализирует коллекцию обработчиков ввода.
     *
     * @return коллекция обработчиков ввода.
     */
    private static Map<Integer, InputHandler> initializeInputHandlers() {
        Map<Integer, InputHandler> handlers = new LinkedHashMap<>();
        handlers.put(1, new AnimalInputHandler(new Scanner(System.in)));
        handlers.put(2, new BarrelInputHandler(new Scanner(System.in)));
        handlers.put(3, new PersonInputHandler(new Scanner(System.in)));
        return handlers;
    }

    /**
     * Инициализирует коллекцию генераторов сущностей.
     *
     * @return коллекция генераторов сущностей.
     */
    private static Map<Integer, EntityGenerator> initializeEntityGenerators() {
        Map<Integer, EntityGenerator> generators = new LinkedHashMap<>();
        generators.put(1, new RandomAnimalGenerator());
        generators.put(2, new RandomBarrelGenerator());
        generators.put(3, new RandomPersonGenerator());
        return generators;
    }

    /**
     * Инициализирует коллекцию парсеров файлов.
     *
     * @return коллекция парсеров файлов.
     */
    private static Map<Integer, FileParser> initializeFileParsers() {
        Map<Integer, FileParser> parsers = new LinkedHashMap<>();
        parsers.put(1, new TxtFileParser(new AnimalParser(), "animals.txt"));
        parsers.put(2, new TxtFileParser(new BarrelParser(), "barrel.txt"));
        parsers.put(3, new TxtFileParser(new PersonParser(), "person.txt"));
        return parsers;
    }

    /**
     * Инициализирует коллекцию стратегий сортировки.
     *
     * @return коллекция стратегий сортировки.
     */
    private static Map<Integer, SortingStrategy> initializeSortingStrategies() {
        Map<Integer, SortingStrategy> strategies = new LinkedHashMap<>();
        strategies.put(1, new EvenOddInsertionSortStrategy(true));
        strategies.put(2, new EvenOddInsertionSortStrategy(false));
        strategies.put(3, new InsertionSortStrategy());
        return strategies;
    }

    /**
     * Инициализирует коллекцию стратегий заполнения коллекций.
     *
     * @return коллекция стратегий заполнения коллекций.
     */
    private static Map<Integer, CollectionFillStrategy> initializeCollectionFillStrategies() {
        Map<Integer, CollectionFillStrategy> strategies = new LinkedHashMap<>();
        strategies.put(1, new FileCollectionFillStrategy());
        strategies.put(2, new RandomDataCollectionFillStrategy());
        strategies.put(3, new ManualCollectionFillStrategy());
        return strategies;
    }

    /**
     * Инициализирует коллекцию полей классов.
     *
     * @return коллекция полей классов.
     */
    private static Map<Integer, List<Field>> initializeClassFields() {
        Map<Integer, List<Field>> fields = new LinkedHashMap<>();
        int i = 1;
        for (Class<?> clazz : classes) {
            fields.put(i++, getClassField(clazz));
        }
        return fields;
    }

    /**
     * Инициализирует коллекцию функций, возвращающих сравниваемые объекты.
     *
     * @return коллекция функций, возвращающих сравниваемые объекты.
     */
    private static Map<Integer, List<Function<Object, Comparable<Object>>>> initializeFunctions() {
        Map<Integer, List<Function<Object, Comparable<Object>>>> funcMap = new LinkedHashMap<>();
        int j = 1;
        for (Class<?> clazz : classes) {
            funcMap.put(j++, getFunctions(clazz));
        }
        return funcMap;
    }

    /**
     * Получает список функций, возвращающих сравниваемые объекты для заданного класса.
     *
     * @param clazz класс, для которого нужно получить функции.
     * @return список функций, возвращающих сравниваемые объекты.
     */
    @SuppressWarnings("unchecked")
    private static List<Function<Object, Comparable<Object>>> getFunctions(Class<?> clazz) {
        List<Function<Object, Comparable<Object>>> functions = new LinkedList<>();
        Method[] methods = clazz.getDeclaredMethods();
        Arrays.sort(methods, Comparator.comparing(method -> {
            String name = method.getName();
            if (name.startsWith("get") || name.startsWith("is")) {
                return name.substring(name.startsWith("is") ? 2 : 3);
            }
            return name;
        }));
        for (Method method : methods) {
            if ((method.getName().startsWith("get") || method.getName().startsWith("is")) && method.getParameterCount() == 0) {
                functions.add(obj -> {
                    try {
                        return (Comparable<Object>) method.invoke(obj);
                    } catch (Exception e) {
                        throw new RuntimeException("Поле " + method.getName() +
                                " не подходит для сортировки и поиска");
                    }
                });
            }
        }
        return functions;
    }

    /**
     * Получает список полей для заданного класса.
     *
     * @param clazz класс, для которого нужно получить поля.
     * @return список полей класса.
     */
    private static List<Field> getClassField(Class<?> clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        Arrays.sort(declaredFields, Comparator.comparing(Field::getName));
        return new ArrayList<>(Arrays.asList(declaredFields));
    }
}