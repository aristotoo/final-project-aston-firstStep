package com.aston.project.service.utils;

import com.aston.project.model.entity.Animal;
import com.aston.project.model.entity.Barrel;
import com.aston.project.model.entity.Person;
import com.aston.project.service.CollectionFillStrategy;
import com.aston.project.service.FileCollectionFillStrategy;
import com.aston.project.service.ManualCollectionFillStrategy;
import com.aston.project.service.RandomDataCollectionFillStrategy;
import com.aston.project.service.file.AnimalParser;
import com.aston.project.service.file.BarrelParser;
import com.aston.project.service.file.PersonParser;
import com.aston.project.service.file.TxtFileParser;
import com.aston.project.service.generator.RandomAnimalGenerator;
import com.aston.project.service.generator.RandomBarrelGenerator;
import com.aston.project.service.generator.RandomPersonGenerator;
import com.aston.project.service.handler.AnimalInputHandler;
import com.aston.project.service.handler.BarrelInputHandler;
import com.aston.project.service.handler.PersonInputHandler;

import java.util.Scanner;

public class EntityFillStrategy {
    public static CollectionFillStrategy<Animal> getAnimalFileStrategy(String fileName) {
        return new FileCollectionFillStrategy<>(
                new TxtFileParser<>(new AnimalParser(), fileName));
    }

    public static CollectionFillStrategy<Barrel> getBarrelFileStrategy(String fileName) {
        return new FileCollectionFillStrategy<>(
                new TxtFileParser<>(new BarrelParser(), fileName));
    }

    public static CollectionFillStrategy<Person> getPersonFileStrategy(String fileName) {
        return new FileCollectionFillStrategy<>(
                new TxtFileParser<>(new PersonParser(), fileName));
    }

    public static CollectionFillStrategy<Animal> getAnimalManualStrategy(Scanner scanner) {
        return new ManualCollectionFillStrategy<>(new AnimalInputHandler(scanner));
    }

    public static CollectionFillStrategy<Barrel> getBarrelManualStrategy(Scanner scanner) {
        return new ManualCollectionFillStrategy<>(new BarrelInputHandler(scanner));
    }

    public static CollectionFillStrategy<Person> getPersonManualStrategy(Scanner scanner) {
        return new ManualCollectionFillStrategy<>(new PersonInputHandler(scanner));
    }

    public static CollectionFillStrategy<Animal> getAnimalRandomStrategy() {
        return new RandomDataCollectionFillStrategy<>(new RandomAnimalGenerator());
    }

    public static CollectionFillStrategy<Barrel> getBarrelRandomStrategy() {
        return new RandomDataCollectionFillStrategy<>(new RandomBarrelGenerator());
    }

    public static CollectionFillStrategy<Person> getPersonRandomStrategy() {
        return new RandomDataCollectionFillStrategy<>(new RandomPersonGenerator());
    }
}
