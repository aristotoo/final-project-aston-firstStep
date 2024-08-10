package com.aston.project.service.file;

import com.aston.project.model.entity.Animal;
import com.aston.project.service.file.validation.Validation;
import com.aston.project.storage.AnimalStorage;

import java.util.Map;
import java.util.Optional;

public class AnimalFillingStrategy implements TypeFillingStrategy {
    private final AnimalStorage storage;

    public AnimalFillingStrategy(AnimalStorage storage) {
        this.storage = storage;
    }

    @Override
    public void filling(Map<String, String> parameters) {
        Optional<Animal> animal = Validation.animalValidation(parameters);
        animal.ifPresent(storage::add);
    }
}
