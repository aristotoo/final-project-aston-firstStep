package com.aston.project.service.context;

import com.aston.project.service.CollectionFillStrategy;

import java.util.List;

public class CollectionFillContext<T> {

    private final CollectionFillStrategy<T> fillStrategy;

    public CollectionFillContext(CollectionFillStrategy<T> fillStrategy) {
        this.fillStrategy = fillStrategy;
    }

    public List<T> fill(int length) {
        return fillStrategy.fillCollection(length);
    }
}
