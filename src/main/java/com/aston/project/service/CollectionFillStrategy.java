package com.aston.project.service;

import java.util.List;

public interface CollectionFillStrategy {
    void setFiller (Filler filler);
    List<Object> fillCollection(int length);
}
