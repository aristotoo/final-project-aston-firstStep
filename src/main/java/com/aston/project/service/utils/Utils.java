package com.aston.project.service.utils;

import com.aston.project.model.entity.Animal;
import com.aston.project.model.entity.Barrel;
import com.aston.project.model.entity.Person;

import java.util.Map;
import java.util.function.Function;

/**
 * Константы. Название сущностей, типы заполение.
 */
public class Utils {
    private Utils() {
    }

    public static final String PERSON_ENTITY = "person";
    public static final String ANIMAL_ENTITY = "animal";
    public static final String BARREL_ENTITY = "barrel";
    public static final String FILE_FILLING = "file";
    public static final String RANDOM_FILLING = "random";
    public static final String MANUAL_FILLING = "manual";
    public static final String PERSON_MANUAL_FILLING = PERSON_ENTITY + "-" + MANUAL_FILLING;
    public static final String PERSON_FILE_FILLING = PERSON_ENTITY + "-" + FILE_FILLING;
    public static final String PERSON_RANDOM_FILLING = PERSON_ENTITY + "-" + RANDOM_FILLING;
    public static final String ANIMAL_MANUAL_FILLING = ANIMAL_ENTITY + "-" + MANUAL_FILLING;
    public static final String ANIMAL_FILE_FILLING = ANIMAL_ENTITY + "-" + FILE_FILLING;
    public static final String ANIMAL_RANDOM_FILLING = ANIMAL_ENTITY + "-" + RANDOM_FILLING;
    public static final String BARREL_RANDOM_FILLING = BARREL_ENTITY + "-" + RANDOM_FILLING;
    public static final String BARREL_MANUAL_FILLING = BARREL_ENTITY + "-" + MANUAL_FILLING;
    public static final String BARREL_FILE_FILLING = BARREL_ENTITY + "-" + FILE_FILLING;

    public static final Function<Person, String> PERSON_SURNAME_FUNCTION = Person::getSurname;
    public static final Function<Person, Integer> PERSON_AGE_FUNCTION = Person::getAge;
    public static final Function<Animal, String> ANIMAL_SPECIES_FUNCTION = Animal::getSpecies;
    public static final Function<Animal, String> ANIMAL_EYE_COLOR_FUNCTION = Animal::getEyeColor;
    public static final Function<Barrel, String> BARREL_MATERIAL_FUNCTION = Barrel::getMaterial;
    public static final Function<Barrel, String> BARREL_STORED_MATERIAL_FUNCTION = Barrel::getStoredMaterial;
    public static final Function<Barrel, Double> BARREL_VOLUME_FUNCTION = Barrel::getVolume;
    public static final String AGE = "age";
    public static final String SURNAME = "surname";
    public static final String SPECIES = "species";
    public static final String EYE_COLOR = "eyeColor";
    public static final String MATERIAL = "material";
    public static final String STORED_MATERIAL = "storedMaterial";
    public static final String VOLUME = "volume";
    public static final Map<String, Function> FUNCTIONS_FOR_SEARCH = Map.of(SURNAME, PERSON_SURNAME_FUNCTION,
            AGE, PERSON_AGE_FUNCTION,
            SPECIES, ANIMAL_SPECIES_FUNCTION,
            EYE_COLOR, ANIMAL_EYE_COLOR_FUNCTION,
            MATERIAL, BARREL_MATERIAL_FUNCTION,
            STORED_MATERIAL, BARREL_STORED_MATERIAL_FUNCTION,
            VOLUME, BARREL_VOLUME_FUNCTION);
}
