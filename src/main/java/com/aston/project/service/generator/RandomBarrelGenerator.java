package com.aston.project.service.generator;

import com.aston.project.model.Barrel;
import com.aston.project.service.Filler;
import com.aston.project.service.utils.generatorUtil.RandomDataSource;

/**
 * Генератор создания случайного объекта типа Barrel
 * у объекта этого типа есть три поля - объем бочки, хранимый в ней материал и материал, из которого изготовлена бочка - каждый метод генерит случайные данные по этим полям
 * в статическом методе generateBarrel данные передаются в сеттер-методы BarrelBuilder. В завершении вызывается метод build для генерации объекта.
 */
public class RandomBarrelGenerator implements EntityGenerator, Filler {

    @SuppressWarnings("unchecked")
    @Override
    public Barrel generate() {
        return new Barrel.BarrelBuilder().
                setVolume(generateRandomDouble()).
                setStoredMaterial(generateRandomStoredMaterial()).
                setMaterial(generateRandomMaterial()).
                build();

    }

    //создается случайное число типа double для поля Volume, затем округляется число до 3 цифр после запятой
    private double generateRandomDouble() {
        int RADIUS = random.nextInt(1,10);
        int HEIGHT = random.nextInt(1,15);
        double barrelVolume = Math.PI * Math.pow(RADIUS, 2) * HEIGHT;
        return Math.ceil(barrelVolume);
    }

    //создается список материалов, и которых может быть сделана бочка
    private String generateRandomMaterial() {
        int randomNumToGetMaterial = random.nextInt(RandomDataSource.MATERIALS.length - 1);
        return RandomDataSource.MATERIALS[randomNumToGetMaterial];
    }

    //создается список материалов, который может храниться в бочке
    private String generateRandomStoredMaterial() {
        int randomNumToGetMaterial = random.nextInt(RandomDataSource.STOREDMATERIAL.length - 1);
        return RandomDataSource.STOREDMATERIAL[randomNumToGetMaterial];
    }
}
