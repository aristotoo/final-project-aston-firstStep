package com.aston.project.service;

import com.aston.project.controller.Controller;
import com.aston.project.model.Request;
import com.aston.project.service.utils.Utils;

import java.util.List;
import java.util.Optional;

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

    public Optional<T> search() {

        if (request.getParameterName().equals(Utils.AGE)) {
            return controller.search(collection, Integer.parseInt(request.getSearchValue()),
                    Utils.FUNCTIONS_FOR_SEARCH.get(request.getParameterName()));
        } else if (request.getParameterName().equals(Utils.VOLUME)) {
            return controller.search(collection, Double.parseDouble(request.getSearchValue()),
                    Utils.FUNCTIONS_FOR_SEARCH.get(request.getParameterName()));
        } else {
            return controller.search(collection, request.getSearchValue(),
                    Utils.FUNCTIONS_FOR_SEARCH.get(request.getParameterName()));
        }
    }
}
