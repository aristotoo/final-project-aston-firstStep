package com.aston.project.service;

import com.aston.project.service.generator.EntityGenerator;

import java.util.ArrayList;
import java.util.List;

public class RandomDataCollectionFillStrategy implements CollectionFillStrategy {

    private Filler filler;


    @Override
    public void setFiller(Filler filler) {
        this.filler = filler;
    }

    @Override
    public List<Object> fillCollection(int length) {
        List<Object> collection = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            collection.add(((EntityGenerator) filler).generate());
        }
        return collection;
    }
}

