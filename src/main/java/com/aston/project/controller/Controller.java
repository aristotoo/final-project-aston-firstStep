package com.aston.project.controller;

import com.aston.project.service.context.CollectionFillContext;
import com.aston.project.service.context.SortContext;
import com.aston.project.service.utils.searches.BinarySearch;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Controller<T> {
    SortContext sortContext;
    CollectionFillContext<T> fillContext;

    public Controller(SortContext sortContext, CollectionFillContext<T> fillContext) {
        this.sortContext = sortContext;
        this.fillContext = fillContext;
    }

    public List<T> fillCollection(int length) {
        return fillContext.fill(length);
    }

    public void sortCollection(List<T> input, Comparator<? super T> comparator) {
        sortContext.sort(input, comparator);
    }

    public Optional<?> search(List<Object> sortedList, Object key, Function<Object, Comparable<Object>> getters) {
        return BinarySearch.search(sortedList, key, getters);
    }
}
