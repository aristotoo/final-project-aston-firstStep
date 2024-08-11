package com.aston.project.input;

import com.aston.project.model.entity.Barrel;

import java.util.Scanner;

public class BarrelInputHandler implements InputHandler<Barrel> {
    private final Scanner scanner;
    public BarrelInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Barrel handleInput() {
        System.out.print("Введите объем: ");
        double volume = Double.parseDouble(scanner.nextLine());

        System.out.print("Введите хранимый материал: ");
        String storedMaterial = scanner.nextLine();

        System.out.print("Введите материал изготовления бочки: ");
        String material = scanner.nextLine();

        return new Barrel.BarrelBuilder()
                .setVolume(volume)
                .setStoredMaterial(storedMaterial)
                .setMaterial(material)
                .build();
    }
}
