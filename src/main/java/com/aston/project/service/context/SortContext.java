package com.aston.project.service.context;

import com.aston.project.service.sort.SortingStrategy;

import java.util.Comparator;
import java.util.List;

public class SortContext <T>{
    private SortingStrategy<T> sortingStrategy;

    public void setSortingStrategy(SortingStrategy<T> sortingStrategy){
        this.sortingStrategy = sortingStrategy;
    }

    public void sort(List<T> list, Comparator<? super T> comparator){
        sortingStrategy.sort(list,comparator);
    }
}
