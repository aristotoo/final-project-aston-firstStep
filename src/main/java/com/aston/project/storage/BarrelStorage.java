package com.aston.project.storage;

import com.aston.project.model.entity.Barrel;

import java.util.ArrayList;
import java.util.List;

public class BarrelStorage implements AbstractStorage<Barrel> {
    private final ArrayList<Barrel> barrels = new ArrayList<>();

    @Override
    public void add(Barrel model) {
        barrels.add(model);
    }

    @Override
    public List<Barrel> getStorage() {
        return barrels;
    }
}
