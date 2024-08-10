package com.aston.project.storage;

import com.aston.project.model.entity.Barrel;

import java.util.ArrayList;
import java.util.List;

public class BarrelStorage {
    private final List<Barrel> barrels = new ArrayList<>();

    public void add(Barrel Barrel) {
        barrels.add(Barrel);
    }

    public List<Barrel> getBarrels() {
        return barrels;
    }
}
