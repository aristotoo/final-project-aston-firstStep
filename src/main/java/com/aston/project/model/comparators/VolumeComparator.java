package com.aston.project.model.comparators;

import com.aston.project.model.entity.Barrel;

public class VolumeComparator implements NumericComparator<Barrel> {
    @Override
    public boolean isEven(Barrel value) {
        return value.getVolume() % 2 == 0;
    }

    @Override
    public int compare(Barrel barrel, Barrel otherBarrel) {
        return Double.compare(barrel.getVolume(), otherBarrel.getVolume());
    }
}
