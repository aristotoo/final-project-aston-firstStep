package com.aston.project.model.comparators;

import com.aston.project.model.entity.Animal;
import com.aston.project.model.entity.Barrel;
import com.aston.project.model.entity.Person;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс содержащий HashMap имя поля - компаратор
 */
public class ProviderEntityComparators {
    private static Map<String, Comparator> entityComparators = new HashMap<>();

    /**
     * Заполняем коллекцию
     */
    static {
        entityComparators.put("surname", Comparator.comparing(Person::getSurname));
        entityComparators.put("age", Comparator.comparing(Person::getAge));
        entityComparators.put("male", Comparator.comparing(Person::getGender));
        entityComparators.put("species", Comparator.comparing(Animal::getSpecies));
        entityComparators.put("eyeColor", Comparator.comparing(Animal::getEyeColor));
        entityComparators.put("volume", Comparator.comparing(Barrel::getVolume));
        entityComparators.put("material", Comparator.comparing(Barrel::getMaterial));
        entityComparators.put("storedMaterial", Comparator.comparing(Barrel::getStoredMaterial));
    }

    public Comparator getEntityComparator(String parameter) {
        return entityComparators.get(parameter);
    }

    public void addComparator(String parameter, Comparator comparator) {
        entityComparators.put(parameter, comparator);
    }
}
