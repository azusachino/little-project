package cn.az.project.muxin.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

/**
 * @author az
 */
@Slf4j
public class JsonUtil {

    private JsonUtil() {
    }

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> Optional<String> toJson(T t) {
        try {
            return Optional.of(MAPPER.writeValueAsString(t));
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            return Optional.empty();
        }
    }

    public static <T> Optional<T> toObject(String json, Class<T> clazz) {
        try {
            return Optional.of(MAPPER.readValue(json, clazz));
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            return Optional.empty();
        }
    }

    public static <T> Optional<List<T>> toList(String json, Class<T> clazz) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, clazz);

        try {
            return Optional.of(MAPPER.readValue(json, javaType));
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            return Optional.empty();
        }
    }
}
