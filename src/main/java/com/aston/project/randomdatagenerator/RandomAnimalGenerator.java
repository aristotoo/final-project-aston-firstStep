package com.aston.project.randomdatagenerator;

import com.aston.project.Animal;

import static com.aston.project.randomdatagenerator.CollectionFillStrategy.random;
import static com.aston.project.randomdatagenerator.RandomDataSource.*;

/*
Генератор создания случайного объекта типа Animal
у объекта этого типа есть три поля - вид животного, цвет глаз и наличие шерсти - каждый метод генерит случайные данные по этим полям
в статическом методе generateAnimal данные передаются в сеттер-методы AnimalBuilder. В завершении вызывается метод build для генерации объекта.
 */
public class RandomAnimalGenerator implements EntityGenerator<Animal>{

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

    //в переопределенном методе интерфейса создается новый объект указанного типа
    @Override
    public Animal generate(){
        return new Animal.AnimalBuilder().
                setSpecies(generateRandomSpecies()).
                setEyeColor(generateRandomColor()).
                setHasFur(generateRandomFur())
                .build();

    }
}
