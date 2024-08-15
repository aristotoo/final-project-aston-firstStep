package com.aston.project.service.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class EvenOddInsertionSortStrategy implements SortingStrategy {
    /**
     * Переменная показывающая четность ключегого элемента сортировки
     */
    private final boolean sortEven;

    public EvenOddInsertionSortStrategy(boolean sortEven) {
        this.sortEven = sortEven;
    }

    /**
     * Метод сортировки вставками для четных или нечетных чисел.Сортируются только четные с четными или
     * нечетные с нечтными, остальные элементы остаются на своих местах, четность нечетность выбирает
     * пользователь используя флаг sortEven.
     *
     * @param input      - список для сортировки.
     * @param getter - геттер Comparable поля для сравнения сущностей.
     */
    @Override
    public <T> void sort(List<T> input, Function<Object, Comparable<Object>> getter) {
        List<T> sortedElements = new ArrayList<>();
        List<T> unsortedElements = new ArrayList<>();

        // Разделяем элементы на сортируемые и несортируемые
        for (T element : input) {
            Comparable<Object> value = getter.apply(element);
            if (value instanceof Number number) {
                boolean isEven = number.doubleValue() % 2 == 0;
                if ((sortEven && isEven) || (!sortEven && !isEven)) {
                    sortedElements.add(element);
                } else {
                    unsortedElements.add(element);
                }
            } else {
                unsortedElements.add(element);
            }
        }

        // Сортируем сортируемые элементы методом вставки
        insertionSort(sortedElements, getter);

        // Объединяем отсортированные элементы с неотсортированными
        input.clear();
        input.addAll(sortedElements);
        input.addAll(unsortedElements);
    }

    private <T> void insertionSort(List<T> list, Function<Object, Comparable<Object>> getter) {
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;
            while (j >= 0 && getter.apply(list.get(j)).compareTo(getter.apply(key)) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }
}
