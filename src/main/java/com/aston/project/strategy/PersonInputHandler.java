package com.aston.project.input;

import com.aston.project.model.entity.Person;

import java.util.Scanner;

public class PersonInputHandler implements InputHandler<Person> {

    private final Scanner scanner;

    public PersonInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Person handleInput() {
        System.out.print("Введите пол (Male/Female): ");
        String gender = scanner.nextLine();
        if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
            throw new IllegalArgumentException("Некорректный пол. Введите Male или Female.");
        }

        System.out.print("Введите возраст: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректный возраст. Введите число.");
        }
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Некорректный возраст. Введите значение от 0 до 120.");
        }

        System.out.print("Введите фамилию: ");
        String surname = scanner.nextLine();
        if (!surname.matches("[a-zA-Zа-яА-Я]+")) {
            throw new IllegalArgumentException("Фамилия может содержать только буквы.");
        }

        return new Person.PersonBuilder()
                .setGender(gender)
                .setAge(age)
                .setSurname(surname)
                .build();
    }
}
