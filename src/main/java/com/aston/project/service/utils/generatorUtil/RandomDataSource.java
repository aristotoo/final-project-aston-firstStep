package com.aston.project.service.utils.generatorUtil;

//класс utility с данными для полей в виде массивов
public final class RandomDataSource {
    private RandomDataSource() {
        throw new UnsupportedOperationException("Utility class");
    }
    public static final String[] ANIMALS = {"dog", "cat", "bird", "fish", "tiger", "elephant", "turtle", "rat", "hamster"};
    public static final String[] COLORS = {"brown", "blue", "green", "black", "blue"};
    public static final String[] MATERIALS = {"metal", "wood", "plastic", "glass"};
    public static final String[] STOREDMATERIAL = {"oil", "drinking water", "distilled water", "acid", "toxic waste"};
    public static final String[] GENDERS = {"male", "female"};
    public static final String[] SURNAMES = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia","Rodriguez", "Mendoza", "Castillo"};
}
