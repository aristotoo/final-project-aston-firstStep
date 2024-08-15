package com.aston.project.service;

import com.aston.project.service.file.FileParser;

import java.util.List;
import java.util.stream.Collectors;


public class FileCollectionFillStrategy implements CollectionFillStrategy {

    private FileParser fileParser;

    public void setFileParser(FileParser fileParser) {
        this.fileParser = fileParser;
    }

    @Override
    public List<Object> fillCollection(int length) {
        return fileParser.parseFile().stream().limit(length).collect(Collectors.toList());
    }


}
