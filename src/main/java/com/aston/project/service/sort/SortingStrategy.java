package com.aston.project.service.sort;

import java.util.List;
import java.util.function.Function;

public interface SortingStrategy {
    <T> void sort(List<T> input, Function<Object, Comparable<Object>> getter);
}
