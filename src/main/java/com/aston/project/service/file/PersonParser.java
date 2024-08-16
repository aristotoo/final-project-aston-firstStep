package com.aston.project.service.file;

import com.aston.project.model.entity.Person;
import com.aston.project.service.utils.FileParsingUtils;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class PersonParser implements EntityParser {
    private static final String SURNAME_PARAM = "surname";
    private static final String AGE_PARAM = "age";
    private static final String GENDER_PARAM = "gender";
    private static final Set<String> OPTION_FOR_GENDER =
            Set.of("мужской", "male", "женский", "female");

    @Override
    public Optional<? super Person> parsing(Map<String, String> parameters) {
        String surname = parameters.get(SURNAME_PARAM);
        String ageString = parameters.get(AGE_PARAM);
        String genderString = parameters.get(GENDER_PARAM);
        int age = parseAge(ageString);
        if (validateAge(age) && validateGender(genderString)
                && FileParsingUtils.validateString(surname)) {
            return Optional.of(new Person.PersonBuilder()
                    .setGender(genderString)
                    .setAge(age)
                    .setSurname(surname)
                    .build());
        } else {
            return Optional.empty();
        }
    }

    private boolean validateAge(int age) {
        return age > 0;
    }

    private boolean validateGender(String gender) {
        return gender != null && !gender.isEmpty() && OPTION_FOR_GENDER.contains(gender);
    }

    private int parseAge(String age) {
        try {
            return Integer.parseInt(age);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
