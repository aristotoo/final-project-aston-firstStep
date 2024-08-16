package com.aston.project.service.utils.searches;


import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class BinarySearch {

    private BinarySearch() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Выполняет бинарный поиск элемента в отсортированном списке.
     *
     * @param list список, в котором выполняется поиск
     * @param key искомый элемент
     * @param getter функция для получения значения из элемента списка, которое будет сравниваться с искомым элементом
     * @return Optional, содержащий найденный элемент списка, если он найден; Optional.empty(), если элемент не найден
     */
    public static Optional<?> search(List<Object> list, Object key, Function<Object, Comparable<Object>> getter) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int resultOfCompare = getter.apply(list.get(mid)).compareTo(key);
            if (resultOfCompare == 0) {
                return Optional.of(list.get(mid));
            } else if (resultOfCompare < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return Optional.empty();
    }
}
