package com.aston.project.randomdatagenerator;

import com.aston.project.Person;

import java.util.ArrayList;
import java.util.List;

/*
Генератор создания случайного объекта типа Person
у объекта этого типа есть три поля - пол, возраст и фамилия - каждый метод генерит случайные данные по этим полям
в статическом методе generatePerson данные передаются в сеттер-методы PersonBuilder. В завершении вызывается метод build для генерации объекта.
 */
public class GenerateRandomPerson implements FillWithRandomData<Person> {
    public static int maxAge = 120;
    public Person generatePerson(){
        return new Person.PersonBuilder().
                setGender(generateRandomGender()).
                setAge(generateRandomAge()).
                setSurname(generateRandomSurnames()).
                build();
    }
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
    public List<Person> fillWithRandomData(List<Person> people, int size) {
        people = new ArrayList<Person>(size);
        for(int i = 0; i < size; i++) {
            people.add(generatePerson());
        }
        return people;
    }
}
