package com.aston.project.service.file;

import java.util.List;

public interface FileParser<T> {
    List<T> parseFile(int length);
}
