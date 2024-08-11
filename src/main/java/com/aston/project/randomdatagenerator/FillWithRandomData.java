package com.aston.project.randomdatagenerator;

import java.util.ArrayList;
import java.util.List;

//интерфейс принимает в качестве параметров пустой список пока неизвестных объектов и длину этого списка
//возвращается список указанной длины
public interface FillWithRandomData<T> {
    List<T> fillWithRandomData(ArrayList<T> ts, int size);
}
