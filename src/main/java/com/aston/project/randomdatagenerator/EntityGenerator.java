package com.aston.project.randomdatagenerator;

//в интерфейсе есть метод, который генерит и возвращает объект типа T
public interface EntityGenerator<T> {
    T generate();
}
