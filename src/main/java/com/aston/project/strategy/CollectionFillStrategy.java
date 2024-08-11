package com.aston.project.strategy;

import java.util.List;

public interface CollectionFillStrategy<T> {
    List<T> fillCollection(int length);
}
