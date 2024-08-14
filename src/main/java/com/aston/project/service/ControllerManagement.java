package com.aston.project.service;

import com.aston.project.controller.Controller;
import com.aston.project.model.Request;

import java.util.List;

public class ControllerManagement {
    private final Request request;
    private final HandlerRequest handlerRequest;
    private List collection;
    private Controller controller;

    public ControllerManagement(Request request, HandlerRequest handlerRequest) {
        this.request = request;
        this.handlerRequest = handlerRequest;
    }

    public List getCollection() {
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
