package com.aston.project.service.file;

import java.util.Map;
import java.util.Optional;

public interface EntityParser<T> {
    /**
     * Строим объект необходимой сущности или возвращаем пустой Optional
     *
     * @param parameters - параметры приходят ввиде ключ-значение (имя поле - значение)
     */
    Optional<T> parsing(Map<String, String> parameters);
}
