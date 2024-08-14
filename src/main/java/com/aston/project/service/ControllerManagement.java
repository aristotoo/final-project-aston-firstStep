package com.aston.project.service;

import com.aston.project.controller.Controller;
import com.aston.project.model.Request;

import java.util.List;

public class ControllerManagement<T> {
    private final Request request;
    private final HandlerRequest handlerRequest;
    private List<T> collection;
    private Controller<T> controller;

    public ControllerManagement(Request request, HandlerRequest handlerRequest) {
        this.request = request;
        this.handlerRequest = handlerRequest;
    }

    public List<T> getCollection() {
        return collection;
    }

    public void fillingList() {
        handlerRequest.createController();
        collection = controller.fillCollection(request.getLength());
    }

    public void sorting() {
        controller.sortCollection(collection, handlerRequest.getComparator());
    }
}
