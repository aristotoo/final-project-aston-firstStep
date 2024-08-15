package com.aston.project.service.sort;

import java.util.Comparator;
import java.util.List;

public class InsertionSortStrategy implements SortingStrategy {
    /**
     * Сортировка вставками.
     *
     * @param input      - входной список для сортировки
     * @param comparator - компоратор по типу сравнения сущностей
     */
    @Override
    public <T> void sort(List<T> input, Comparator<? super T> comparator) {
        for (int i = 1; i < input.size(); i++) {
            T key = input.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(input.get(j), key) > 0) {
                input.set(j + 1, input.get(j));
                j--;
            }
            input.set(j + 1, key);
        }
    }
}
