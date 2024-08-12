package com.aston.project.service;

import com.aston.project.service.generator.EntityGenerator;

import java.util.ArrayList;
import java.util.List;

public class RandomDataCollectionFillStrategy<T> implements CollectionFillStrategy<T> {
        private final EntityGenerator<T> entityGenerator;
        public RandomDataCollectionFillStrategy(EntityGenerator<T> entityGenerator) {
            this.entityGenerator = entityGenerator;
        }
        @Override
        public List<T> fillCollection(int length){
            List<T> collection = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                collection.add(entityGenerator.generate());
            }
            return collection;
        }
    }

