package com.aston.project.randomdatagenerator;

import com.aston.project.Animal;

import java.util.ArrayList;
import java.util.List;

import static com.aston.project.randomdatagenerator.RandomDataSource.*;

/*
Генератор создания случайного объекта типа Animal
у объекта этого типа есть три поля - вид животного, цвет глаз и наличие шерсти - каждый метод генерит случайные данные по этим полям
в статическом методе generateAnimal данные передаются в сеттер-методы AnimalBuilder. В завершении вызывается метод build для генерации объекта.
 */
public class GenerateRandomAnimal implements FillWithRandomData<Animal> {
    public Animal generateAnimal(){
        return new Animal.AnimalBuilder().
                setSpecies(generateRandomSpecies()).
                setEyeColor(generateRandomColor()).
                setHasFur(generateRandomFur())
                .build();

    }
    //создается список видов животных на выбор
    private String generateRandomSpecies(){
        int randomNumToGetRandomAnimal = random.nextInt(ANIMALS.length - 1);
        return RandomDataSource.ANIMALS[randomNumToGetRandomAnimal];
    }
    //создается список цвета глаз, который может быть у животного
    private String generateRandomColor(){
        int randomNumToGetRandomColor = random.nextInt(COLORS.length - 1);
        return RandomDataSource.COLORS[randomNumToGetRandomColor];
    }
    //создается случайная булевая переменная, которая указывает, есть ли у животного шерсть
    private boolean generateRandomFur(){
        return random.nextBoolean();
    }

    @Override
    public List<Animal> fillWithRandomData(List<Animal> animals, int size) {
            animals = new ArrayList<Animal>(size);
            for(int i = 0; i < size; i++) {
                animals.add(generateAnimal());
            }
            return animals;
    }
}
