package com.aston.project.model.comparators;

import com.aston.project.model.entity.Person;

public class AgeComparator implements NumericComparator<Person> {
    @Override
    public boolean isEven(Person value) {
        return value.getAge() % 2 == 0;
    }

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
    }
}
