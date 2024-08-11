package com.aston.project.storage;

import com.aston.project.model.entity.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalStorage implements AbstractStorage<Animal> {
    private final List<Animal> animals = new ArrayList<>();

    @Override
    public void add(Animal model) {
        animals.add(model);
    }

    @Override
    public List<Animal> getStorage() {
        return animals;
    }
}
