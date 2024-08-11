package com.aston.project.service.file.validation;

import com.aston.project.model.entity.Animal;

import java.util.Map;
import java.util.Optional;

import static com.aston.project.service.file.validation.utils.ValidationUtils.validateStringOnlyLetter;

public class AnimalValidation {
    private static final String SPECIES_PARAM = "species";
    private static final String EYE_PARAM = "eyeColor";
    private static final String HAS_FUR_PARAM = "hasFur";
    private static final String OPTION_FOR_TRUE = "YES";

    /**
     * Валидация данных. Animal
     *
     * @param parameters - HashMap параметр-значение
     */
    public static Optional<Animal> validation(Map<String, String> parameters) {
        String species = parameters.get(SPECIES_PARAM);
        String eyeColor = parameters.get(EYE_PARAM);
        String hasFurStr = parameters.get(HAS_FUR_PARAM);
        if (species == null || eyeColor == null || hasFurStr == null) {
            return Optional.empty();
        }
        boolean hasFur = hasFurStr.equalsIgnoreCase(OPTION_FOR_TRUE) || hasFurStr.equalsIgnoreCase("true");
        if (validateStringOnlyLetter(species) || validateStringOnlyLetter(eyeColor)) {
            return Optional.empty();
        }
        return Optional.of(new Animal.AnimalBuilder()
                .setSpecies(species)
                .setEyeColor(eyeColor)
                .setHasFur(hasFur)
                .builder());
    }
}
