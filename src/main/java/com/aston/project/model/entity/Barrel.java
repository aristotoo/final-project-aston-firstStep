package com.aston.project.model.entity;

import java.util.Objects;

public class Barrel {
    private final double volume;
    private final String storedMaterial;
    private final String material;

    private Barrel(BarrelBuilder builder) {
        this.volume = builder.volume;
        this.storedMaterial = builder.storedMaterial;
        this.material = builder.material;
    }

    public double getVolume() {
        return volume;
    }

    public String getStoredMaterial() {
        return storedMaterial;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Barrel barrel)) return false;

        if (Double.compare(barrel.volume, volume) != 0) return false;
        if (!Objects.equals(storedMaterial, barrel.storedMaterial))
            return false;
        return Objects.equals(material, barrel.material);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(volume);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (storedMaterial != null ? storedMaterial.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Barrel{" +
                "volume=" + volume +
                ", storedMaterial='" + storedMaterial + '\'' +
                ", material='" + material + '\'' +
                '}';
    }

    public static class BarrelBuilder {
        private double volume;
        private String storedMaterial;
        private String material;

        public BarrelBuilder setVolume(double volume) {
            this.volume = volume;
            return this;
        }

        public BarrelBuilder setStoredMaterial(String storedMaterial) {
            this.storedMaterial = storedMaterial;
            return this;
        }

        public BarrelBuilder setMaterial(String material) {
            this.material = material;
            return this;
        }

        public Barrel build() {
            return new Barrel(this);
        }
    }
}
