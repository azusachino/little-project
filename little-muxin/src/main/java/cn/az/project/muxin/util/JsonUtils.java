package cn.az.project.muxin.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

/**
 * @author az
 * @since 2020-03-27
 */
@Slf4j
public class JsonUtils {
    private JsonUtils() {
    }

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    /**
     * 将对象转换成json字符串。
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     *
     * @param data Object
     */
    public static <T> Optional<String> objectToJson(T data) {
        try {
            return Optional.ofNullable(OBJECT_MAPPER.writeValueAsString(data));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonData json数据
     * @param clazz    对象中的object类型
     */
    public static <T> Optional<T> jsonToPojo(String jsonData, Class<T> clazz) {
        try {
            return Optional.ofNullable(OBJECT_MAPPER.readValue(jsonData, clazz));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    /**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     *
     * @param jsonData json数据
     * @param clazz    对象中的object类型
     */
    public static <T> Optional<?> jsonToList(String jsonData, Class<T> clazz) {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, clazz);
        try {
            return OBJECT_MAPPER.readValue(jsonData, javaType);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return Optional.empty();
    }
}
