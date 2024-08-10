package com.aston.project.service.file.validation;

import com.aston.project.model.entity.Animal;
import com.aston.project.model.entity.Barrel;
import com.aston.project.model.entity.Gender;
import com.aston.project.model.entity.Person;

import java.util.Map;
import java.util.Optional;

public class Validation {
    private static final String ONLY_LETTER_REGEXP = "[a-zA-Zа-яА-Я]+";

    public static Optional<Person> personValidation(Map<String, String> parameters) {
        String surname = parameters.get("surname");
        String ageString = parameters.get("age");
        String genderString = parameters.get("gender");
        if(surname == null || ageString == null || genderString == null){
            return Optional.empty();
        }
        int age = 0;
        try{
            age = Integer.parseInt(ageString);
        }catch (NumberFormatException e){
            return Optional.empty();
        }
        if(age <= 0){
            return Optional.empty();
        }
        if(!surname.matches(ONLY_LETTER_REGEXP) || !genderString.matches(ONLY_LETTER_REGEXP)){
            return Optional.empty();
        }
        Gender gender;
        if(genderString.equalsIgnoreCase("мужской")){
            gender = Gender.MALE;
        } else if (genderString.equalsIgnoreCase("женский")) {
            gender = Gender.FEMALE;
        } else {
            try{
                gender = Gender.valueOf(genderString.toUpperCase());
            }catch (Exception e){
                return Optional.empty();
            }
        }
        return Optional.of(new Person.PersonBuilder()
                        .setGender(gender)
                        .setAge(age)
                        .setSurname(surname)
                        .build()
                );
    }

    public static Optional<Animal> animalValidation(Map<String, String> parameters) {
        String species = parameters.get("species");
        String eyeColor = parameters.get("eyeColor");
        String hasFurStr = parameters.get("hasFur");
        if (species == null || eyeColor == null || hasFurStr == null) {
            return Optional.empty();
        }
        boolean hasFur = hasFurStr.equalsIgnoreCase("yes") || hasFurStr.equalsIgnoreCase("true");
        if (!species.matches(ONLY_LETTER_REGEXP) || !eyeColor.matches(ONLY_LETTER_REGEXP)) {
            return Optional.empty();
        }
        return Optional.of(new Animal.AnimalBuilder()
                .setSpecies(species)
                .setEyeColor(eyeColor)
                .setHasFur(hasFur)
                .builder());
    }
    public static Optional<Barrel> barrelValidation(Map<String, String> parameters){
        String volumeString = parameters.get("volume");
        String storedMaterial = parameters.get("storedMaterial");
        String material = parameters.get("material");
        if(volumeString == null || storedMaterial == null || material == null){
            return Optional.empty();
        }
        double volume = 0;
        try {
            volume = Double.parseDouble(volumeString);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
        if (volume <= 0) {
            return Optional.empty();
        }
        if (!material.matches(ONLY_LETTER_REGEXP) || !storedMaterial.matches(ONLY_LETTER_REGEXP)) {
            return Optional.empty();
        }
        return Optional.of(new Barrel.BarrelBuilder()
                .setVolume(volume)
                .setMaterial(material)
                .setStoredMaterial(storedMaterial)
                .build());
    }
}
