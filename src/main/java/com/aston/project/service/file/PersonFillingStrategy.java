package com.aston.project.service.file;

import com.aston.project.model.entity.Person;
import com.aston.project.service.file.validation.Validation;
import com.aston.project.storage.PersonStorage;

import java.util.Map;
import java.util.Optional;

public class PersonFillingStrategy implements TypeFillingStrategy {
    private final PersonStorage storage;

    public PersonFillingStrategy(PersonStorage storage) {
        this.storage = storage;
    }

    @Override
    public void filling(Map<String, String> parameters) {
        Optional<Person> person = Validation.personValidation(parameters);
        person.ifPresent(storage::add);
    }

}
