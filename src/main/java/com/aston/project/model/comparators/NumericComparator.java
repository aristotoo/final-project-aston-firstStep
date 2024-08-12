package com.aston.project.model.comparators;

import java.util.Comparator;

public interface NumericComparator<T> extends Comparator<T> {
    boolean isEven(T value);
}
