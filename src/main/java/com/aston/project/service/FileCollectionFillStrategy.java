package com.aston.project.service;

import com.aston.project.service.file.FileParser;

import java.util.List;


public class FileCollectionFillStrategy<T> implements CollectionFillStrategy<T> {

    private FileParser<T> fileParser;

    public FileCollectionFillStrategy(FileParser<T> fileParser) {
        this.fileParser = fileParser;
    }

    public void setFileParser(FileParser<T> fileParser) {
        this.fileParser = fileParser;
    }

    @Override
    public List<T> fillCollection(int length) {
        return fileParser.parseFile(length);
    }
}
