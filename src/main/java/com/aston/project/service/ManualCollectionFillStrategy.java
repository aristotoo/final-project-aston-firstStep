package com.aston.project.service;

import com.aston.project.service.handler.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class ManualCollectionFillStrategy implements CollectionFillStrategy {

    Filler filler;

    @Override
    public void setFiller(Filler filler) {
        this.filler = filler;
    }

    @Override
    public List<Object> fillCollection(int length) {
        List<Object> collection = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            while (true) {
                try {
                    System.out.println("Введите данные для элемента " + (i + 1) + ": ");
                    collection.add(((InputHandler) filler).handleInput());
                    break;
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage() + ". Попробуйте снова.");
                }
            }
        }
        return collection;
    }
}
