package com.example.services.util;


import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.JsonParseException;

import java.util.concurrent.Callable;

/**
 * JSON工具类
 *
 * @author yanxingtong
 * @since 2024-01-07
 */
@Slf4j
public class JsonUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static <T> T parse(Callable<T> parse) {
        try {
            return parse.call();
        } catch (Exception e) {
            if (JacksonException.class.isAssignableFrom(e.getClass())) {
                throw new JsonParseException(e);
            }
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 对象转json
     *
     * @param object 入参对象
     * @return json
     */
    public static String objToString(Object object) {
        return parse(() -> OBJECT_MAPPER.writeValueAsString(object));
    }

    /**
     * json转对象
     *
     * @param jsonString json
     * @param targetClass 目标对象
     * @param <T> 目标对象
     * @return 目标对象
     */
    public static <T> T stringToObj(String jsonString, Class<T> targetClass) {
        return parse(() -> OBJECT_MAPPER.readValue(jsonString, targetClass));
    }
}