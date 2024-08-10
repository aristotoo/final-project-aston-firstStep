package com.aston.project.strategy;

import com.aston.project.model.entity.Person;
import com.aston.project.model.entity.Animal;
import com.aston.project.model.entity.Barrel;

import java.util.Scanner;

public class ManualArrayFillStrategy<T> implements ArrayFillStrategy<T> {

    private final Class<T> clazz;

    public ManualArrayFillStrategy(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T[] fillArray(int length) {
        Scanner scanner = new Scanner(System.in);
        T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, length);

        for (int i = 0; i < length; i++) {
            while (true) {
                try {
                    System.out.println("Введите данные для элемента " + (i + 1) + ": ");
                    array[i] = createObject(scanner);
                    break;
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage() + ". Попробуйте снова.");
                }
            }
        }
        return array;
    }

    private T createObject(Scanner scanner) {
        if (clazz.equals(Person.class)) {
            System.out.print("(Male/Female): ");
            String gender = scanner.nextLine();
            if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
                throw new IllegalArgumentException("Некорректный пол. Введите Male или Female.");
            }

            System.out.print("Возраст: ");
            int age = Integer.parseInt(scanner.nextLine());
            if (age < 0 || age > 120) {
                throw new IllegalArgumentException("Некорректный возраст. Введите значение от 0 до 120.");
            }

            System.out.print("Введите фамилию: ");
            String surname = scanner.nextLine();
            if (surname.isEmpty()) {
                throw new IllegalArgumentException("Фамилия не может быть пустой.");
            }

            return (T) new Person.PersonBuilder()
                    .setGender(gender)
                    .setAge(age)
                    .setSurname(surname)
                    .build();

        } else if (clazz.equals(Animal.class)) {
            System.out.print("Введите вид: ");
            String species = scanner.nextLine();

            System.out.print("Введите цвет глаз: ");
            String eyeColor = scanner.nextLine();

            System.out.print("Есть ли шерсть (true/false): ");
            boolean hasFur = Boolean.parseBoolean(scanner.nextLine());

            return (T) new Animal.AnimalBuilder()
                    .setSpecies(species)
                    .setEyeColor(eyeColor)
                    .setHasFur(hasFur)
                    .builder();

        } else if (clazz.equals(Barrel.class)) {
            System.out.print("Введите объем: ");
            double volume = Double.parseDouble(scanner.nextLine());

            System.out.print("Введите хранимый материал: ");
            String storedMaterial = scanner.nextLine();

            System.out.print("Введите материал изготовления бочки: ");
            String material = scanner.nextLine();

            return (T) new Barrel.BarrelBuilder()
                    .setVolume(volume)
                    .setStoredMaterial(storedMaterial)
                    .setMaterial(material)
                    .build();

        } else {
            throw new UnsupportedOperationException("Поддерживаются только объекты классов Person, Animal и Barrel.");
        }
    }
}
