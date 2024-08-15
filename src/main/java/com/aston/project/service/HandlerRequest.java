package com.aston.project.service;

import com.aston.project.controller.Controller;
import com.aston.project.model.Request;
import com.aston.project.model.comparators.ProviderEntityComparators;
import com.aston.project.service.utils.Utils;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

import static com.aston.project.service.utils.ProviderEntityControllers.getAnimalFileStrategy;
import static com.aston.project.service.utils.ProviderEntityControllers.getAnimalManualStrategy;
import static com.aston.project.service.utils.ProviderEntityControllers.getAnimalRandomStrategy;
import static com.aston.project.service.utils.ProviderEntityControllers.getBarrelFileStrategy;
import static com.aston.project.service.utils.ProviderEntityControllers.getBarrelManualStrategy;
import static com.aston.project.service.utils.ProviderEntityControllers.getBarrelRandomStrategy;
import static com.aston.project.service.utils.ProviderEntityControllers.getPersonFileStrategy;
import static com.aston.project.service.utils.ProviderEntityControllers.getPersonManualStrategy;
import static com.aston.project.service.utils.ProviderEntityControllers.getPersonRandomStrategy;

/**
 * Обработчик ответов пользователя.
 */
public class HandlerRequest {
    private Request request;
    private final Scanner scanner = new Scanner(System.in);
    private Map<String, Controller> controllers;

    public HandlerRequest(Request request) {
        this.request = request;

    }

    /**
     * Возвращаем контроллер созданный на основе выбора пользователя
     */
    public Controller createController() {
        registerControllers(request);
        return controllers.get(request.getEntity() + "-" + request.getTypeFilling());
    }

    /**
     * Возвращаем сомпаратор по имени поля.
     */
    public Comparator getComparator() {
        ProviderEntityComparators comparators = new ProviderEntityComparators();
        return comparators.getEntityComparator(request.getParameterName());
    }

    /**
     * Собираем коллекцию из ключевых слов (Сущность-Тип заполнения) - контроллеров
     */
    private void registerControllers(Request request) {
        controllers = Map.of(Utils.ANIMAL_FILE_FILLING, getAnimalFileStrategy(request.getFileName()),
                Utils.ANIMAL_MANUAL_FILLING, getAnimalManualStrategy(scanner),
                Utils.ANIMAL_RANDOM_FILLING, getAnimalRandomStrategy(),
                Utils.BARREL_FILE_FILLING, getBarrelFileStrategy(request.getFileName()),
                Utils.BARREL_MANUAL_FILLING, getBarrelManualStrategy(scanner),
                Utils.BARREL_RANDOM_FILLING, getBarrelRandomStrategy(),
                Utils.PERSON_FILE_FILLING, getPersonFileStrategy(request.getFileName()),
                Utils.PERSON_MANUAL_FILLING, getPersonManualStrategy(scanner),
                Utils.PERSON_RANDOM_FILLING, getPersonRandomStrategy());
    }

}
