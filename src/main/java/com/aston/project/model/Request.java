package com.aston.project.model;

/**
 * Класс содержащий ответы пользователя
 */
public class Request {
    private String entity;
    private String typeFilling;
    private String fileName;
    private int length;
    private String parameterName;

    public Request(RequestBuilder requestBuilder) {
        this.entity = requestBuilder.entity;
        this.typeFilling = requestBuilder.typeFilling;
        this.fileName = requestBuilder.fileName;
        this.length = requestBuilder.length;
        this.parameterName = requestBuilder.parameterName;
    }

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

    public String getTypeFilling() {
        return typeFilling;
    }

    public void setTypeFilling(String typeFilling) {
        this.typeFilling = typeFilling;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public static class RequestBuilder {
        private String entity;
        private String typeFilling;
        private String fileName;
        private int length;
        private String parameterName;

        public RequestBuilder entity(String entity) {
            this.entity = entity;
            return this;
        }

        public RequestBuilder typeFilling(String typeFilling) {
            this.typeFilling = typeFilling;
            return this;
        }

        public RequestBuilder fileName(String name) {
            this.fileName = name;
            return this;
        }

        public RequestBuilder length(int length) {
            this.length = length;
            return this;
        }

        public RequestBuilder parameterName(String parameterName) {
            this.parameterName = parameterName;
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }
}
