package com.aston.project.service.sort;

import java.util.Comparator;
import java.util.List;

public interface SortingStrategy {
    <T> void sort(List<T> input, Comparator<? super T> comparator);
}
