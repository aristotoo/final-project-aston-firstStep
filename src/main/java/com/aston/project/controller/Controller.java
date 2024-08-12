package com.aston.project.controller;

import com.aston.project.service.context.CollectionFillContext;
import com.aston.project.service.context.SortContext;
import com.aston.project.service.utils.searches.BinarySearch;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Класс (@code Controller) общий класс предоставляющий общие методы по заполнению коллекции, ее сортировке
 * и поиску элемента.
 * @param <T>
 */
public class Controller<T> {
    SortContext<T> sortContext;
    CollectionFillContext<T> fillContext;

    public Controller(SortContext<T> sortContext, CollectionFillContext<T> fillContext) {
        this.sortContext = sortContext;
        this.fillContext = fillContext;
    }

    public List<T> fillCollection(int length) {
        return fillContext.fill(length);
    }

    public void sortCollection(List<T> input, Comparator<? super T> comparator) {
        sortContext.sort(input, comparator);
    }

    public <T, S extends Comparable<? super S>> Optional<T> search(List<T> sortedList, S key, Function<T, S> getters) {
        return BinarySearch.search(sortedList, key, getters);
    }
}
