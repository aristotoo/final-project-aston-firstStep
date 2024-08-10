package com.aston.project.storage;

import com.aston.project.model.entity.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalStorage {
    private final List<Animal> animals = new ArrayList<>();
    public void add(Animal animal){
        animals.add(animal);
    }
    public List<Animal> getAnimals(){
        return animals;
    }
}
