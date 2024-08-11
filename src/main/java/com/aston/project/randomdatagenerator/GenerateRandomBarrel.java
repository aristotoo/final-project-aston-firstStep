package com.aston.project.randomdatagenerator;

import com.aston.project.Barrel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Генератор создания случайного объекта типа Barrel
у объекта этого типа есть три поля - объем бочки, хранимый в ней материал и материал, из которого изготовлена бочка - каждый метод генерит случайные данные по этим полям
в статическом методе generateBarrel данные передаются в сеттер-методы BarrelBuilder. В завершении вызывается метод build для генерации объекта.
*/
public class GenerateRandomBarrel implements FillWithRandomData<Barrel> {
    public static Random random = new Random();

    public Barrel generateBarrel(){
        return (Barrel) new Barrel.BarrelBuilder().
                setVolume(generateRandomDouble()).
                setStoredMaterial(generateRandomStoredMaterial()).
                setMaterial(generateRandomMaterial()).
                build();

    }

    //создается случайное число типа double для поля Volume
    private double generateRandomDouble(){
        return random.nextDouble();
    }
    //создается список материалов, и которых может быть сделана бочка
    private String generateRandomMaterial(){
        int i = random.nextInt(RandomDataSource.MATERIALS.length - 1);
        return RandomDataSource.MATERIALS[i];
    }
    //создается список материалов, который может храниться в бочке
    private String generateRandomStoredMaterial(){
        int i = random.nextInt(RandomDataSource.STOREDMATERIALS.length - 1);
        return RandomDataSource.STOREDMATERIALS[i];
    }

    @Override
    public List<Barrel> fillWithRandomData(ArrayList<Barrel> barrels, int size) {
        barrels = new ArrayList<Barrel>(size);
        for(int i = 0; i < size; i++) {
            barrels.add(generateBarrel());
        }
        return barrels;
    }
}
