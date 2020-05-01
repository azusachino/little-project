package cn.az.project.miaosha.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.Objects;
import java.util.Optional;

/**
 * @author az
 * @since 2020-04-13
 */
@Slf4j
public class BeanUtil extends BeanUtils {

    private BeanUtil() {
    }

    private static final ObjectMapper OM = new ObjectMapper();

    public static <T> Optional<String> toString(T t) {
        try {
            return Optional.of(OM.writeValueAsString(t));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    public static <T> Optional<T> toBean(String str, Class<T> clazz) {
        if (StringUtils.isEmpty(str) || Objects.isNull(clazz)) {
            return Optional.empty();
        }
        try {
            return Optional.of(OM.readValue(str, clazz));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return Optional.empty();
    }
}
