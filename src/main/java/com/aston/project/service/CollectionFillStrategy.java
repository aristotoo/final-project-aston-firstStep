package com.aston.project.service;

import java.util.List;

public interface CollectionFillStrategy<T> {
    List<T> fillCollection(int length);
}
