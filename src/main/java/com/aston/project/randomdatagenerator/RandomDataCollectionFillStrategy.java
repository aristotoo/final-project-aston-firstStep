package com.aston.project.randomdatagenerator;

import java.util.ArrayList;
import java.util.List;

public class RandomDataCollectionFillStrategy<T> implements CollectionFillStrategy<T> {
        private final EntityGenerator<T> entityGenerator;
        private List<T> collection;
        public RandomDataCollectionFillStrategy(EntityGenerator<T> entityGenerator) {
            this.entityGenerator = entityGenerator;
        }
        @Override
        public List<T> fillWithRandomData(int size){
            collection = new ArrayList<>(size);
            collection.add(entityGenerator.generate());
            return collection;
        }
        public List<T> getCollection() {
            return collection;
        }
    }

