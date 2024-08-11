package com.aston.project.storage;

import java.util.List;

public interface AbstractStorage<T> {
    void add(T model);

    List<T> getStorage();
}
