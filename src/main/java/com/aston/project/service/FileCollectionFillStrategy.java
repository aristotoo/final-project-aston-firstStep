package com.aston.project.service;

import com.aston.project.service.file.FileParser;

import java.util.List;
import java.util.stream.Collectors;


public class FileCollectionFillStrategy implements CollectionFillStrategy {

    private Filler filler;

    @Override
    public void setFiller(Filler filler) {
        this.filler = filler;
    }

    @Override
    public List<Object> fillCollection(int length) {
        return ((FileParser) filler).parseFile().stream().limit(length).collect(Collectors.toList());
    }


}
