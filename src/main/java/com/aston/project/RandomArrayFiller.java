package com.aston.project;

import java.util.*;

public class RandomArrayFiller {
    private static Random random = new Random();
    private static Barrel.BarrelBuilder generateBarrel(){
        Barrel.BarrelBuilder barrel = new Barrel.BarrelBuilder();
        barrel.setVolume(generateRandomDouble());
        barrel.setStoredMaterial(generateRandomStoredMaterial());
        barrel.setMaterial(generateRandomMaterial());
        return barrel;

    }
    private static double generateRandomDouble(){
        return random.nextDouble();
    }
    private static String generateRandomMaterial(){
        String[] materials = {"metal", "wood", "plastic"};
        int i = random.nextInt(materials.length - 1);
        return materials[i];
    }

    private static String generateRandomStoredMaterial(){
        String[] materials = {"oil", "drinking water", "distilled water", "acid"};
        int i = random.nextInt(materials.length - 1);
        return materials[i];
    }

    private static Person.PersonBuilder generatePerson(){
        Person.PersonBuilder person = new Person.PersonBuilder();
        person.setGender(generateRandomGender());
        person.setAge(generateRandomAge());
        person.setSurname(generateRandomSurnames());
        return person;
    }

    private static String generateRandomGender(){
        String[] genders = {"male", "female"};
        int i = random.nextInt(1);
        return genders[i];
    }
    private static int generateRandomAge(){
        int i = random.nextInt();
        if(i > 0 && i <= 120);
        return i;
    }
    private static String generateRandomSurnames(){
        String[] surnames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia","Rodriguez", "Mendoza", "Castillo"};
        int i = random.nextInt(surnames.length - 1);
        return surnames[i];
    }

    private static Animal.AnimalBuilder generateRandomAnimal(){
        Animal.AnimalBuilder animal = new Animal.AnimalBuilder();
        animal.setSpecies(generateRandomSpecies());
        animal.setEyeColor(generateRandomColor());
        animal.setHasFur(generateRandomFur());
        return animal;
    }

    private static String generateRandomSpecies(){
        String[] animals = {"dog", "cat", "bird", "fish", "tiger", "elephant", "turtle", "rat", "hamster"};
        int i = random.nextInt(animals.length - 1);
        return animals[i];
    }
    private static String generateRandomColor(){
        String[] colors = {"brown", "blue", "green", "black"};
        int i = random.nextInt(colors.length - 1);
        return colors[i];
    }
    private static boolean generateRandomFur(){
        return random.nextBoolean();
    }

    public static ArrayList<Barrel.BarrelBuilder> fillWithRandomBarrel(ArrayList<Barrel.BarrelBuilder> barrels, int size) {
        barrels = new ArrayList<Barrel.BarrelBuilder>(size);
        for(int i = 0; i < size; i++) {
            barrels.add(generateBarrel());
        }
        return barrels;

    }
    public static ArrayList<Person.PersonBuilder> fillWithRandomPerson(ArrayList<Person.PersonBuilder> people, int size){
        people = new ArrayList<Person.PersonBuilder>(size);
        for(int i = 0; i < size; i++) {
            people.add(generatePerson());
        }
        return people;

    }
    public static ArrayList<Animal.AnimalBuilder> fillWithRandomAnimal(ArrayList<Animal.AnimalBuilder> animals, int size) {
        animals = new ArrayList<Animal.AnimalBuilder>(size);
        for(int i = 0; i < size; i++) {
            animals.add(generateRandomAnimal());
        }
        return animals;
    }
}