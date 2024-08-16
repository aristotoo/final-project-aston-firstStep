package com.aston.project.service.generator;

import java.util.Random;

//в интерфейсе есть метод, который генерит и возвращает объект типа T
public interface EntityGenerator {
    Random random = new Random();

    <T> T generate();
}
