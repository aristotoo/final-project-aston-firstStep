package com.aston.project.strategy;

import com.aston.project.input.InputHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManualCollectionFillStrategy<T> implements CollectionFillStrategy<T> {

    private final InputHandler<T> inputHandler;

    public ManualCollectionFillStrategy(InputHandler<T> inputHandler) {
        this.inputHandler = inputHandler;
    }

    @Override
    public List<T> fillCollection(int length) {
        List<T> collection = new ArrayList<>(length);

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
}
