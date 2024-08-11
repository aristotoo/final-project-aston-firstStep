package com.aston.project.service.file.validation;

import com.aston.project.model.entity.Gender;
import com.aston.project.model.entity.Person;
import com.aston.project.service.file.validation.utils.ValidationUtils;

import java.util.Map;
import java.util.Optional;

import static com.aston.project.service.file.validation.utils.ValidationUtils.validateStringOnlyLetter;

public class PersonValidation {
    private static final String SURNAME_PARAM = "surname";
    private static final String AGE_PARAM = "age";
    private static final String GENDER_PARAM = "gender";

    /**
     * Валидация данных. Person
     *
     * @param parameters - HashMap параметр-значение
     */
    public static Optional<Person> validation(Map<String, String> parameters) {
        String surname = parameters.get(SURNAME_PARAM);
        String ageString = parameters.get(AGE_PARAM);
        String genderString = parameters.get(GENDER_PARAM);
        if (surname == null || ageString == null || genderString == null) {
            return Optional.empty();
        }
        int age;
        try {
            age = Integer.parseInt(ageString);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
        if (age <= 0) {
            return Optional.empty();
        }
        if (ValidationUtils.validateStringOnlyLetter(surname) || validateStringOnlyLetter(genderString)) {
            return Optional.empty();
        }
        Gender gender;
        if (genderString.equalsIgnoreCase("мужской")) {
            gender = Gender.MALE;
        } else if (genderString.equalsIgnoreCase("женский")) {
            gender = Gender.FEMALE;
        } else {
            try {
                gender = Gender.valueOf(genderString.toUpperCase());
            } catch (Exception e) {
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
}
