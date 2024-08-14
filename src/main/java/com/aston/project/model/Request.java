package com.aston.project.model;

/**
 * Класс содержащий ответы пользователя
 */
public class Request {
    private Entities entities;
    private TypeFilling typeFilling;
    private String fileName;
    private int length;
    private String parameterName;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public TypeFilling getTypeFilling() {
        return typeFilling;
    }

    public void setTypeFilling(TypeFilling typeFilling) {
        this.typeFilling = typeFilling;
    }

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }
}
