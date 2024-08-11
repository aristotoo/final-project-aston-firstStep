package com.aston.project.model.searches;

import java.util.Optional;
import java.util.function.Function;

/**
 * Класс для выполнения бинарного поиска в отсортированном массиве.
 */
public class BinarySearch {
    /**
     * Выполняет бинарный поиск элемента в отсортированном массиве.
     *
     * @param <T> тип элементов в массиве
     * @param <S> тип искомого элемента, должен реализовывать Comparable
     * @param arr массив, в котором выполняется поиск
     * @param key искомый элемент
     * @param getter функция для получения значения из элемента массива, которое будет сравниваться с искомым элементом
     * @return Optional, содержащий найденный элемент массива, если он найден; Optional.empty(), если элемент не найден
     */
    public <T, S extends Comparable<? super S>> Optional<T> search(T[] arr, S key, Function<T, S> getter) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int resultOfCompare = getter.apply(arr[mid]).compareTo(key);;
            if (resultOfCompare == 0) {
                return Optional.of(arr[mid]);
            } else if (resultOfCompare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return Optional.empty();
    }
}


