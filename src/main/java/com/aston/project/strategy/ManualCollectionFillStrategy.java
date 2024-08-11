package com.aston.project.strategy;

import java.util.ArrayList;
import java.util.List;
import com.aston.project.input.InputHandler;

public class ManualCollectionFillStrategy<T> implements CollectionFillStrategy<T> {

    private final InputHandler<T> inputHandler;
    private List<T> collection;

    public ManualCollectionFillStrategy(InputHandler<T> inputHandler) {
        this.inputHandler = inputHandler;
    }

    @Override
    public List<T> fillCollection(int length) {
        collection = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            while (true) {
                try {
                    System.out.println("Введите данные для элемента " + (i + 1) + ": ");
                    collection.add(inputHandler.handleInput());
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
