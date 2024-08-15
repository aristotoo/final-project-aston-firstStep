package com.aston.project.service.sort;

import java.util.List;
import java.util.function.Function;

public class InsertionSortStrategy implements SortingStrategy {
    /**
     * Сортировка вставками.
     *
     * @param input      - входной список для сортировки
     * @param getter - геттер Comparable поля для сравнения сущностей.
     */
    @Override
    public <T> void sort(List<T> input, Function<Object, Comparable<Object>> getter) {
        for (int i = 1; i < input.size(); i++) {
            T key = input.get(i);
            int j = i - 1;
            while (j >= 0 && getter.apply(input.get(j)).compareTo(key) > 0) {
                input.set(j + 1, input.get(j));
                j--;
            }
            input.set(j + 1, key);
        }
    }
}
