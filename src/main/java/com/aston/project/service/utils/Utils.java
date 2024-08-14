package com.aston.project.service.utils;

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
}
