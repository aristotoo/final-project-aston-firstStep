package com.aston.project.controller;

import com.aston.project.service.context.CollectionFillContext;
import com.aston.project.service.context.SortContext;
import com.aston.project.service.utils.searches.BinarySearch;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Controller {
    SortContext sortContext;
    CollectionFillContext fillContext;

    public void setControllerSortContext(SortContext sortContext) {
        this.sortContext = sortContext;
    }
    public void setControllerFillContext(CollectionFillContext fillContext) {
        this.fillContext = fillContext;
    }

    public List<Object> fillCollection(int length) {
        return fillContext.fill(length);
    }

    public <T> void sortCollection(List<T> input, Function<Object, Comparable<Object>> getter) {
        sortContext.sort(input, getter);
    }

    public Optional<?> search(List<Object> sortedList, Object key, Function<Object, Comparable<Object>> getters) {
        return BinarySearch.search(sortedList, key, getters);
    }
}
