package com.aston.project.service.file;

import com.aston.project.model.entity.Animal;
import com.aston.project.service.utils.FileParsingUtils;

import java.util.Map;
import java.util.Optional;

public class AnimalParser implements EntityParser {
    private static final String SPECIES_PARAM = "species";
    private static final String EYE_PARAM = "eyeColor";
    private static final String HAS_FUR_PARAM = "hasFur";
    private static final String OPTION_FOR_TRUE = "YES";

    @Override
    public  Optional<? super Animal> parsing(Map<String, String> parameters) {
        String species = parameters.get(SPECIES_PARAM);
        String eyeColor = parameters.get(EYE_PARAM);
        String hasFurStr = parameters.get(HAS_FUR_PARAM);
        boolean hasFur = validateHasFur(hasFurStr);
        if (FileParsingUtils.validateString(species) && FileParsingUtils.validateString(eyeColor)) {
            return Optional.of(new Animal.AnimalBuilder()
                    .setSpecies(species)
                    .setEyeColor(eyeColor)
                    .setHasFur(hasFur)
                    .build());
        } else {
            return Optional.empty();
        }
    }

    private boolean validateHasFur(String hasFurStr) {
        return hasFurStr.equalsIgnoreCase(OPTION_FOR_TRUE) || hasFurStr.equalsIgnoreCase("true");
    }
}
