package com.aston.project.randomdatagenerator;

import com.aston.project.Person;

import static com.aston.project.randomdatagenerator.CollectionFillStrategy.random;

/*
Генератор создания случайного объекта типа Person
у объекта этого типа есть три поля - пол, возраст и фамилия - каждый метод генерит случайные данные по этим полям
в статическом методе generatePerson данные передаются в сеттер-методы PersonBuilder. В завершении вызывается метод build для генерации объекта.
 */
public class RandomPersonGenerator implements EntityGenerator<Person> {
    public static int maxAge = 120;
    //создается два гендера на выбор - мужской или женский
    private String generateRandomGender(){
        int randomNumToGetRandomGender = random.nextInt(RandomDataSource.GENDERS.length);
        return RandomDataSource.GENDERS[randomNumToGetRandomGender];
    }
    //создается случайное число для указания возраста (максимум 119 лет)
    private int generateRandomAge(){
        return random.nextInt(maxAge);
    }
    //создается список фамилий на выбор
    private String generateRandomSurnames(){
        int randomNumToGetRandomSurname = random.nextInt(RandomDataSource.SURNAMES.length - 1);
        return RandomDataSource.SURNAMES[randomNumToGetRandomSurname];
    }
    @Override
    public Person generate(){
        return new Person.PersonBuilder().
                setGender(generateRandomGender()).
                setAge(generateRandomAge()).
                setSurname(generateRandomSurnames()).
                build();
    }
}
