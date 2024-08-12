package com.aston.project.randomdatagenerator;

import com.aston.project.Barrel;

import java.util.Random;

import static com.aston.project.randomdatagenerator.CollectionFillStrategy.random;

/*
Генератор создания случайного объекта типа Barrel
у объекта этого типа есть три поля - объем бочки, хранимый в ней материал и материал, из которого изготовлена бочка - каждый метод генерит случайные данные по этим полям
в статическом методе generateBarrel данные передаются в сеттер-методы BarrelBuilder. В завершении вызывается метод build для генерации объекта.
*/
public class RandomBarrelGenerator implements EntityGenerator<Barrel> {
    public static int radius = new Random().nextInt(10);
    public static int height = new Random().nextInt(15);
    //создается случайное число типа double для поля Volume, затем округляется число до 3 цифр после запятой
    private double generateRandomDouble(){
        double barrelVolume = Math.PI * Math.pow(radius, 2) * height;
        return Math.ceil(barrelVolume);
    }
    //создается список материалов, и которых может быть сделана бочка
    private String generateRandomMaterial(){
        int i = random.nextInt(RandomDataSource.MATERIALS.length - 1);
        return RandomDataSource.MATERIALS[i];
    }
    //создается список материалов, который может храниться в бочке
    private String generateRandomStoredMaterial(){
        int i = random.nextInt(RandomDataSource.STOREDMATERIAL.length - 1);
        return RandomDataSource.STOREDMATERIAL[i];
    }
    @Override
    public Barrel generate(){
        return new Barrel.BarrelBuilder().
                setVolume(generateRandomDouble()).
                setStoredMaterial(generateRandomStoredMaterial()).
                setMaterial(generateRandomMaterial()).
                build();

    }
}
