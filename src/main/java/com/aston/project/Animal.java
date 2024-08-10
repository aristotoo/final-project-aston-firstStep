import java.util.Objects;

public class Animal {
    private final String species;
    private final String eyeColor;
    private final boolean hasFur;

    private Animal(AnimalBuilder builder){
        this.species = builder.species;
        this.eyeColor = builder.eyeColor;
        this.hasFur = builder.hasFur;
    }

    public String getSpecies() {
        return species;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public boolean isHasFur() {
        return hasFur;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", hasFur=" + hasFur +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;

        if (hasFur != animal.hasFur) return false;
        if (!Objects.equals(species, animal.species)) return false;
        return Objects.equals(eyeColor, animal.eyeColor);
    }

    @Override
    public int hashCode() {
        int result = species != null ? species.hashCode() : 0;
        result = 31 * result + (eyeColor != null ? eyeColor.hashCode() : 0);
        result = 31 * result + (hasFur ? 1 : 0);
        return result;
    }

    public static class AnimalBuilder{
        private String species;
        private String eyeColor;
        private boolean hasFur;

        public AnimalBuilder setSpecies(String species){
            this.species = species;
            return this;
        }

        public AnimalBuilder setEyeColor(String eyeColor){
            this.eyeColor = eyeColor;
            return this;
        }

        public AnimalBuilder setHasFur(boolean hasFur){
            this.hasFur = hasFur;
            return this;
        }

        public Animal builder(){
            return new Animal(this);
        }
    }
}