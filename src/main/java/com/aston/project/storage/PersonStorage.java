package com.aston.project.storage;

import com.aston.project.model.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonStorage implements AbstractStorage<Person> {
    private final List<Person> persons = new ArrayList<>();

    @Override
    public void add(Person model) {
        persons.add(model);
    }

    @Override
    public List<Person> getStorage() {
        return persons;
    }
}
