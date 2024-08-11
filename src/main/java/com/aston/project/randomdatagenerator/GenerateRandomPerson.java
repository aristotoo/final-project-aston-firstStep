package com.aston.project.randomdatagenerator;

import com.aston.project.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Генератор создания случайного объекта типа Person
у объекта этого типа есть три поля - пол, возраст и фамилия - каждый метод генерит случайные данные по этим полям
в статическом методе generatePerson данные передаются в сеттер-методы PersonBuilder. В завершении вызывается метод build для генерации объекта.
 */
public class GenerateRandomPerson implements FillWithRandomData<Person> {
    public static Random random = new Random();
    public static int maxAge = 120;
    public Person generatePerson(){
        return (Person) new Person.PersonBuilder().
                setGender(generateRandomGender()).
                setAge(generateRandomAge()).
                setSurname(generateRandomSurnames()).
                build();
    }
    //создается два гендера на выбор - мужской или женский
    private String generateRandomGender(){
        int i = random.nextInt(RandomDataSource.GENDERS.length);
        return RandomDataSource.GENDERS[i];
    }
    //создается случайное число для указания возраста (максимум 119 лет)
    private int generateRandomAge(){
        int i = random.nextInt(maxAge);
        return i;
    }
    //создается список фамилий на выбор
    private String generateRandomSurnames(){
        int i = random.nextInt(RandomDataSource.SURNAMES.length - 1);
        return RandomDataSource.SURNAMES[i];
    }

    @Override
    public List<Person> fillWithRandomData(ArrayList<Person> people, int size) {
        people = new ArrayList<>(size);
        for(int i = 0; i < size; i++) {
            people.add(generatePerson());
        }
        return people;
    }
}
