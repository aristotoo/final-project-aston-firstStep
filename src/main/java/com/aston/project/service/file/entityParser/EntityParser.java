package com.aston.project.service.file.entityParser;

import java.util.Map;
import java.util.Optional;

public interface EntityParser {
    /**
     * Строим объект необходимой сущности или возвращаем пустой Optional
     *
     * @param parameters - параметры приходят ввиде ключ-значение (имя поле - значение)
     */
    Optional<?> parsing(Map<String, String> parameters);
}
