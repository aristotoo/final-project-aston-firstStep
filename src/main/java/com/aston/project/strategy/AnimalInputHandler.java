package com.aston.project.input;

import com.aston.project.model.entity.Animal;

import java.util.Scanner;

public class AnimalInputHandler implements InputHandler<Animal> {

    private final Scanner scanner;

    public AnimalInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Animal handleInput() {
        System.out.print("Введите вид: ");
        String species = scanner.nextLine();

        System.out.print("Введите цвет глаз: ");
        String eyeColor = scanner.nextLine();

        System.out.print("Есть ли шерсть (true/false): ");
        boolean hasFur = Boolean.parseBoolean(scanner.nextLine());

        return new Animal.AnimalBuilder()
                .setSpecies(species)
                .setEyeColor(eyeColor)
                .setHasFur(hasFur)
                .build();
    }
}
