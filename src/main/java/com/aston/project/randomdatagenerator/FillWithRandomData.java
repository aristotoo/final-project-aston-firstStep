package com.aston.project.randomdatagenerator;

import java.util.List;
import java.util.Random;

//интерфейс принимает в качестве параметров пустой список пока неизвестных объектов и длину этого списка
//возвращается список указанной длины
public interface FillWithRandomData<T> {
    Random random = new Random();
    List<T> fillWithRandomData(List<T> ts, int size);
}
