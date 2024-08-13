package com.aston.project.model.entity;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private final String gender;
    private final int age;
    private final String surname;

    private Person(PersonBuilder builder) {
        this.gender = builder.gender;
        this.age = builder.age;
        this.surname = builder.surname;
    }

    @Override
    public int compareTo(Person o) {
        return this.getSurname().compareTo(o.getSurname());
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender='" + gender + '\'' +
                ", age=" + age +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;

        if (age != person.age) return false;
        if (!Objects.equals(gender, person.gender)) return false;
        return Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        int result = gender != null ? gender.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    public static class PersonBuilder {
        private String gender;
        private int age;
        private String surname;


        public PersonBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
