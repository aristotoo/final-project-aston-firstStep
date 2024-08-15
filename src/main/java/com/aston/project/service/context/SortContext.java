package com.aston.project.service.context;

import com.aston.project.service.sort.SortingStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class SortContext {
    private SortingStrategy sortingStrategy;

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public <T> void sort(List<T> list, Function<Object, Comparable<Object>> getter) {
        sortingStrategy.sort(list, getter);
    }
}
