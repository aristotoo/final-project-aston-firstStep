package com.aston.project.service.utils;

import com.aston.project.controller.Controller;
import com.aston.project.model.entity.Animal;
import com.aston.project.model.entity.Barrel;
import com.aston.project.model.entity.Person;
import com.aston.project.service.FileCollectionFillStrategy;
import com.aston.project.service.ManualCollectionFillStrategy;
import com.aston.project.service.RandomDataCollectionFillStrategy;
import com.aston.project.service.context.CollectionFillContext;
import com.aston.project.service.context.SortContext;
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

public class ProviderEntityControllers {

    public static Controller<Animal> getAnimalFileStrategy(String fileName) {
        return new Controller<>(new SortContext<>(), new CollectionFillContext<>(new FileCollectionFillStrategy<>(
                new TxtFileParser<>(new AnimalParser(), fileName))));
    }

    public static Controller<Barrel> getBarrelFileStrategy(String fileName) {
        return new Controller<>(new SortContext<>(), new CollectionFillContext<>(new FileCollectionFillStrategy<>(
                new TxtFileParser<>(new BarrelParser(), fileName))));
    }

    public static Controller<Person> getPersonFileStrategy(String fileName) {
        return new Controller<>(new SortContext<>(), new CollectionFillContext<>(
                new FileCollectionFillStrategy<>(
                        new TxtFileParser<>(new PersonParser(), fileName)
                )));
    }

    public static Controller<Animal> getAnimalManualStrategy(Scanner scanner) {
        return new Controller<>(new SortContext<>(), new CollectionFillContext<>(
                new ManualCollectionFillStrategy<>(new AnimalInputHandler(scanner))));
    }

    public static Controller<Barrel> getBarrelManualStrategy(Scanner scanner) {
        return new Controller<>(new SortContext<>(), new CollectionFillContext<>(
                new ManualCollectionFillStrategy<>(new BarrelInputHandler(scanner))));
    }

    public static Controller<Person> getPersonManualStrategy(Scanner scanner) {
        return new Controller<>(new SortContext<>(), new CollectionFillContext<>(
                new ManualCollectionFillStrategy<>(new PersonInputHandler(scanner))));
    }

    public static Controller<Animal> getAnimalRandomStrategy() {
        return new Controller<>(new SortContext<>(), new CollectionFillContext<>(
                new RandomDataCollectionFillStrategy<>(new RandomAnimalGenerator())));
    }

    public static Controller<Barrel> getBarrelRandomStrategy() {
        return new Controller<>(new SortContext<>(), new CollectionFillContext<>(
                new RandomDataCollectionFillStrategy<>(new RandomBarrelGenerator())));
    }

    public static Controller<Person> getPersonRandomStrategy() {
        return new Controller<>(new SortContext<>(), new CollectionFillContext<>(
                new RandomDataCollectionFillStrategy<>(new RandomPersonGenerator())));
    }
}
