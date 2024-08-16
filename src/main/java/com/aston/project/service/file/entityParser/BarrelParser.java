package com.aston.project.service.file.entityParser;

import com.aston.project.model.Barrel;
import com.aston.project.service.utils.fileUtils.FileParsingUtils;

import java.util.Map;
import java.util.Optional;

public class BarrelParser implements EntityParser {
    private static final String VOLUME_PARAM = "volume";
    private static final String STORED_MATERIAL_PARAM = "storedMaterial";
    private static final String MATERIAL_PARAM = "material";

    @Override
    public Optional<? super Barrel> parsing(Map<String, String> parameters) {
        String volumeString = parameters.get(VOLUME_PARAM);
        String storedMaterial = parameters.get(STORED_MATERIAL_PARAM);
        String material = parameters.get(MATERIAL_PARAM);
        double volume = Double.parseDouble(volumeString);

        if (FileParsingUtils.validateString(storedMaterial) && FileParsingUtils.validateString(material)
                && validateVolume(volume)) {
            return Optional.of(new Barrel.BarrelBuilder()
                    .setVolume(volume)
                    .setMaterial(material)
                    .setStoredMaterial(storedMaterial)
                    .build());
        } else {
            return Optional.empty();
        }
    }

    private double parseVolume(String volumeString) {
        try {
            return Double.parseDouble(volumeString);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private boolean validateVolume(double volume) {
        return volume > 0;
    }
}
