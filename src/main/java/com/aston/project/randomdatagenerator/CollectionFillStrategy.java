package com.aston.project.randomdatagenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//интерфейс принимает в качестве параметров пустой список пока неизвестных объектов и длину этого списка
//возвращается список указанной длины
public interface CollectionFillStrategy<T>{
    List<T> fillWithRandomData(int size);
}
