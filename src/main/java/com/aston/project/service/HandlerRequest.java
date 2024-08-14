package com.aston.project.service;

import com.aston.project.controller.Controller;
import com.aston.project.model.Request;
import com.aston.project.model.TypeFilling;
import com.aston.project.model.comparators.EntityComparators;
import com.aston.project.service.context.CollectionFillContext;
import com.aston.project.service.context.SortContext;

import java.util.Comparator;
import java.util.Scanner;

import static com.aston.project.service.utils.EntityFillStrategy.getAnimalFileStrategy;
import static com.aston.project.service.utils.EntityFillStrategy.getAnimalManualStrategy;
import static com.aston.project.service.utils.EntityFillStrategy.getAnimalRandomStrategy;
import static com.aston.project.service.utils.EntityFillStrategy.getBarrelFileStrategy;
import static com.aston.project.service.utils.EntityFillStrategy.getBarrelManualStrategy;
import static com.aston.project.service.utils.EntityFillStrategy.getBarrelRandomStrategy;
import static com.aston.project.service.utils.EntityFillStrategy.getPersonFileStrategy;
import static com.aston.project.service.utils.EntityFillStrategy.getPersonManualStrategy;
import static com.aston.project.service.utils.EntityFillStrategy.getPersonRandomStrategy;

/**
 * Обработчик ответов пользователя.
 */
public class HandlerRequest {
    private Request request;

    public HandlerRequest(Request request) {
        this.request = request;
    }

    /**
     * Возвращаем контроллер созданный на основе выбора пользователя
     */
    public Controller createController() {
        Scanner scanner = new Scanner(System.in);
        if (request.getTypeFilling().equals(TypeFilling.FILE)) {
            switch (request.getEntities()) {
                case ANIMAL -> {
                    return new Controller<>(new SortContext<>(),
                            new CollectionFillContext<>(getAnimalFileStrategy(request.getFileName())));
                }
                case BARREL -> {
                    return new Controller<>(new SortContext<>(),
                            new CollectionFillContext<>(getBarrelFileStrategy(request.getFileName())));
                }
                case PERSON -> {
                    return new Controller<>(new SortContext<>(),
                            new CollectionFillContext<>(getPersonFileStrategy(request.getFileName())));
                }
            }
        } else if (request.getTypeFilling().equals(TypeFilling.MANUAL)) {
            switch (request.getEntities()) {
                case ANIMAL -> {
                    return new Controller<>(new SortContext<>(),
                            new CollectionFillContext<>(getAnimalManualStrategy(scanner)));
                }
                case BARREL -> {
                    return new Controller<>(new SortContext<>(),
                            new CollectionFillContext<>(getBarrelManualStrategy(scanner)));
                }
                case PERSON -> {
                    return new Controller<>(new SortContext<>(),
                            new CollectionFillContext<>(getPersonManualStrategy(scanner)));
                }
            }
        } else if (request.getTypeFilling().equals(TypeFilling.RANDOM)) {
            switch (request.getEntities()) {
                case ANIMAL -> {
                    return new Controller<>(new SortContext<>(),
                            new CollectionFillContext<>(getAnimalRandomStrategy()));
                }
                case BARREL -> {
                    return new Controller<>(new SortContext<>(),
                            new CollectionFillContext<>(getBarrelRandomStrategy()));
                }
                case PERSON -> {
                    return new Controller<>(new SortContext<>(),
                            new CollectionFillContext<>(getPersonRandomStrategy()));
                }

            }
        }
        return null;
    }

    /**
     * Возвращаем сомпаратор по имени поля.
     */
    public Comparator getComparator() {
        EntityComparators comparators = new EntityComparators();
        return comparators.getEntityComparator(request.getParameterName());
    }
}
