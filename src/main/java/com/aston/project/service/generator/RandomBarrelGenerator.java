package com.aston.project.service.generator;

import com.aston.project.model.entity.Barrel;
import com.aston.project.service.utils.generatorUtil.RandomDataSource;

/**
 * Генератор создания случайного объекта типа Barrel
 * у объекта этого типа есть три поля - объем бочки, хранимый в ней материал и материал, из которого изготовлена бочка - каждый метод генерит случайные данные по этим полям
 * в статическом методе generateBarrel данные передаются в сеттер-методы BarrelBuilder. В завершении вызывается метод build для генерации объекта.
 */
public class RandomBarrelGenerator implements EntityGenerator {
    private static final int RADIUS = random.nextInt(10);
    private static final int HEIGHT = random.nextInt(15);

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
