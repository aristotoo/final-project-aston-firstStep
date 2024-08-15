package com.aston.project.service;

import com.aston.project.service.file.FileParser;

import java.util.List;
import java.util.stream.Collectors;


public class FileCollectionFillStrategy<T> implements CollectionFillStrategy<T> {

    private FileParser<T> fileParser;

    public void setFileParser(FileParser<T> fileParser) {
        this.fileParser = fileParser;
    }

    @Override
    public List<T> fillCollection(int length) {
        return fileParser.parseFile().stream().limit(length).collect(Collectors.toList());
    }
}
