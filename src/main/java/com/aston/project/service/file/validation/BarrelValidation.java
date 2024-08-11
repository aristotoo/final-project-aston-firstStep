package com.aston.project.service.file.validation;

import com.aston.project.model.entity.Barrel;

import java.util.Map;
import java.util.Optional;

import static com.aston.project.service.file.validation.utils.ValidationUtils.validateStringOnlyLetter;

public class BarrelValidation {
    private static final String VOLUME_PARAM = "volume";
    private static final String STORED_MATERIAL_PARAM = "storedMaterial";
    private static final String MATERIAL_PARAM = "material";

    /**
     * Валидация данных. Barrel
     *
     * @param parameters - HashMap параметр-значение
     */
    public static Optional<Barrel> validation(Map<String, String> parameters) {
        String volumeString = parameters.get(VOLUME_PARAM);
        String storedMaterial = parameters.get(STORED_MATERIAL_PARAM);
        String material = parameters.get(MATERIAL_PARAM);
        if (volumeString == null || storedMaterial == null || material == null) {
            return Optional.empty();
        }
        double volume;
        try {
            volume = Double.parseDouble(volumeString);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
        if (volume <= 0) {
            return Optional.empty();
        }
        if (validateStringOnlyLetter(material) || validateStringOnlyLetter(storedMaterial)) {
            return Optional.empty();
        }
        return Optional.of(new Barrel.BarrelBuilder()
                .setVolume(volume)
                .setMaterial(material)
                .setStoredMaterial(storedMaterial)
                .build());
    }
}
