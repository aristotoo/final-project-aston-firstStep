package com.aston.project.service;

import com.aston.project.controller.Controller;

import java.util.List;
import java.util.Optional;

public class UserResponseService<T> {

    private final Controller<T> controller;

    public UserResponseService(Controller<T> controller) {
        this.controller = controller;
    }

    public void handleFillCollectionResponse(int length) {
        List<T> collection = controller.fillCollection(length);
        if (collection.isEmpty()) {
            System.out.println("Коллекция пуста.");
        } else {
            System.out.println("Коллекция успешно заполнена.");
            collection.forEach(System.out::println);
        }
    }

    public void handleSortCollectionResponse(List<T> collection) {
        controller.sortCollection(collection, null);
        System.out.println("Коллекция отсортирована:");
        collection.forEach(System.out::println);
    }

    public void handleSearchResponse(List<T> sortedList, Comparable<?> key) {
        Optional<T> result = controller.search(sortedList, key, null);
        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("Элемент не найден.");
        }
    }

    public void handleInvalidInput() {
        System.out.println("Некорректный ввод. Попробуйте снова.");
    }
}
