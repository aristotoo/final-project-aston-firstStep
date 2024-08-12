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
        public List<T> fillWithRandomData(List<T> collection, int size){
            collection = new ArrayList<T>(size);

            for (int i = 0; i < size; i++) {
                while (true) {
                    try {
                        collection.add(entityGenerator.generate());
                        break;
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage() + ". Попробуйте снова.");
                    }
                }
            }
            return collection;
        }

        public List<T> getCollection() {
            return collection;
        }
    }

