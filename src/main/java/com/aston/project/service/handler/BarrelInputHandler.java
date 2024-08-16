package com.aston.project.service.handler;

import com.aston.project.model.entity.Barrel;
import com.aston.project.service.Filler;

import java.util.Scanner;

public class BarrelInputHandler implements InputHandler, Filler {

    private final Scanner scanner;

    public BarrelInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Barrel handleInput() {
        System.out.print("Введите объем: ");
        double volume;
        try {
            volume = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректный объем. Введите число.");
        }

        System.out.print("Введите хранимый материал: ");
        String storedMaterial = scanner.nextLine();
        if (!storedMaterial.matches("[a-zA-Zа-яА-Я]+")) {
            throw new IllegalArgumentException("Хранимый материал может содержать только буквы.");
        }

        System.out.print("Введите материал изготовления бочки: ");
        String material = scanner.nextLine();
        if (!material.matches("[a-zA-Zа-яА-Я]+")) {
            throw new IllegalArgumentException("Материал изготовления может содержать только буквы.");
        }

        return new Barrel.BarrelBuilder()
                .setVolume(volume)
                .setStoredMaterial(storedMaterial)
                .setMaterial(material)
                .build();
    }
}
