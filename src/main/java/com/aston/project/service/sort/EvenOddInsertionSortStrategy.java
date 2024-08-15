package com.aston.project.service.sort;

import com.aston.project.model.comparators.NumericComparator;

import java.util.Comparator;
import java.util.List;

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
     * @param comparator - тип компаратора для сравнения объектов.
     */
    @Override
    public <T> void sort(List<T> input, Comparator<? super T> comparator) {

        if (comparator instanceof NumericComparator) {
            NumericComparator<T> numericComp = (NumericComparator<T>) comparator;
            for (int i = 1; i < input.size(); i++) {
                T key = input.get(i);
                int j = i - 1;
                boolean isKeyEven = numericComp.isEven(key);
                boolean shouldSortCurrentElement = (sortEven && isKeyEven) || (!sortEven && !isKeyEven);
                if (shouldSortCurrentElement) {
                    while (j >= 0 && numericComp.isEven(input.get(j)) == isKeyEven
                            && numericComp.compare(input.get(j), key) > 0) {

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
}
