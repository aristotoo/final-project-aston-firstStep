package com.aston.project;

import com.aston.project.controller.Controller;
import com.aston.project.model.entity.Barrel;
import com.aston.project.model.entity.Person;
import com.aston.project.service.file.AnimalFillingStrategy;
import com.aston.project.service.file.BarrelFillingStrategy;
import com.aston.project.service.file.PersonFillingStrategy;
import com.aston.project.service.file.TxtFileFilling;
import com.aston.project.storage.AnimalStorage;
import com.aston.project.storage.BarrelStorage;
import com.aston.project.storage.PersonStorage;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        new Controller().start();
        String path = new File("").getAbsolutePath();
        PersonStorage personStorage = new PersonStorage();
        TxtFileFilling fileParsing =
                new TxtFileFilling(new PersonFillingStrategy(personStorage), path + "\\person.txt");
        fileParsing.parsingFile();
        List<Person> people = personStorage.getPeople();
        System.out.println(people);
        BarrelStorage barrelStorage = new BarrelStorage();
        fileParsing.setTypeFillingStrategy(new BarrelFillingStrategy(barrelStorage));
        fileParsing.setUri(path + "\\barrel.txt");
        fileParsing.parsingFile();
        List<Barrel> barrels = barrelStorage.getBarrels();
        System.out.println(barrels);
        AnimalStorage animalStorage = new AnimalStorage();
        fileParsing.setTypeFillingStrategy(new AnimalFillingStrategy(animalStorage));
        fileParsing.setUri(path + "\\animals.txt");
        fileParsing.parsingFile();
        System.out.println(animalStorage.getAnimals());
    }
}
