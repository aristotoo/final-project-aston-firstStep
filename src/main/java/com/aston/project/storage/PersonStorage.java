package com.aston.project.storage;

import com.aston.project.model.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonStorage {
    private final List<Person> people = new ArrayList<>();
    public void add(Person person){
            people.add(person);
    }
    public List<Person> getPeople(){
        return people;
    }
}
