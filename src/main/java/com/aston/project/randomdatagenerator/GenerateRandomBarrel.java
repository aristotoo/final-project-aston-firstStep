package com.aston.project.randomdatagenerator;

import com.aston.project.Barrel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Генератор создания случайного объекта типа Barrel
у объекта этого типа есть три поля - объем бочки, хранимый в ней материал и материал, из которого изготовлена бочка - каждый метод генерит случайные данные по этим полям
в статическом методе generateBarrel данные передаются в сеттер-методы BarrelBuilder. В завершении вызывается метод build для генерации объекта.
*/
public class GenerateRandomBarrel implements FillWithRandomData<Barrel> {
    public static int radius = new Random().nextInt(10);
    public static int height = new Random().nextInt(15);
    public Barrel generateBarrel(){
        return new Barrel.BarrelBuilder().
                setVolume(generateRandomDouble()).
                setStoredMaterial(generateRandomStoredMaterial()).
                setMaterial(generateRandomMaterial()).
                build();

    }
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
    public List<Barrel> fillWithRandomData(List<Barrel> barrels, int size) {
        barrels = new ArrayList<Barrel>(size);
        for(int i = 0; i < size; i++) {
            barrels.add(generateBarrel());
        }
        return barrels;
    }
}
