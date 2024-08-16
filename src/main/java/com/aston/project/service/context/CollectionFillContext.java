package com.aston.project.service.context;

import com.aston.project.service.CollectionFillStrategy;

import java.util.List;

public class CollectionFillContext {

    private CollectionFillStrategy fillStrategy;

    public void setCollectionFillContext(CollectionFillStrategy fillStrategy) {
        this.fillStrategy = fillStrategy;
    }

    public List<Object> fill(int length) {
        return fillStrategy.fillCollection(length);
    }
}
