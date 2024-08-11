package com.aston.project.model.searches;

import java.util.Comparator;
import java.util.function.Function;

/**
 * Класс для выполнения бинарного поиска в отсортированном массиве.
 */
public class BinarySearch {
    /**
     * Выполняет бинарный поиск элемента в отсортированном массиве.
     *
     * @param <T> тип элементов в массиве
     * @param <S> тип искомого элемента
     * @param arr массив, в котором выполняется поиск
     * @param key искомый элемент
     * @param getter функция для получения значения из элемента массива, которое будет сравниваться с искомым элементом
     * @param comparator компаратор для сравнения значений, полученных с помощью функции getter
     * @return найденный элемент массива, если он найден; null, если элемент не найден
     */
    public <T, S> T search(T[] arr, S key, Function<T, S> getter, Comparator<S> comparator) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int resultOfCompare = comparator.compare(getter.apply(arr[mid]), key);
            if (resultOfCompare == 0) {
                return arr[mid];
            } else if (resultOfCompare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
