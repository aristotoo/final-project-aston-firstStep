package com.aston.project.service;

import com.aston.project.service.generator.EntityGenerator;

import java.util.ArrayList;
import java.util.List;

public class RandomDataCollectionFillStrategy implements CollectionFillStrategy {
    private EntityGenerator entityGenerator;

    public void setEntityGenerator (EntityGenerator entityGenerator) {
        this.entityGenerator = entityGenerator;
    }

    @Override
    public List<Object> fillCollection(int length) {
        List<Object> collection = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            collection.add(entityGenerator.generate());
        }
        return collection;
    }
}

