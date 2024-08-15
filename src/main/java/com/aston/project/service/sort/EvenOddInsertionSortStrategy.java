package com.aston.project.service.sort;

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
        if (getter.apply(input.get(0)) instanceof Number) {
            for (int i = 1; i < input.size(); i++) {
                T key = input.get(i);
                int j = i - 1;
                Number number = (Number) getter.apply(key);
                boolean isKeyEven = number.doubleValue() % 2 == 0;
                boolean shouldSortCurrentElement = (sortEven && isKeyEven) || (!sortEven && !isKeyEven);
                if (shouldSortCurrentElement) {
                    while (j >= 0 && isEven((Number) getter.apply(input.get(j))) == isKeyEven
                            && getter.apply(input.get(j)).compareTo(getter.apply(key)) > 0) {
                        input.set(j + 1, input.get(j));
                        j--;
                    }
                    input.set(j + 1, key);
                } else {
                    input.set(i, key);
                }
            }
        }
    }
    private static boolean isEven(Number number) {
        return number.doubleValue() % 2 == 0;
    }
}
