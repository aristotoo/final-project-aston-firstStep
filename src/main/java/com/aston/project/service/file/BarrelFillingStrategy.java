package com.aston.project.service.file;

import com.aston.project.model.entity.Barrel;
import com.aston.project.service.file.validation.Validation;
import com.aston.project.storage.BarrelStorage;

import java.util.Map;
import java.util.Optional;

public class BarrelFillingStrategy implements TypeFillingStrategy {
    private final BarrelStorage barrelStorage;

    public BarrelFillingStrategy(BarrelStorage barrelStorage) {
        this.barrelStorage = barrelStorage;
    }

    @Override
    public void filling(Map<String, String> parameters) {
        Optional<Barrel> barrel = Validation.barrelValidation(parameters);
        barrel.ifPresent(barrelStorage::add);
    }
}
