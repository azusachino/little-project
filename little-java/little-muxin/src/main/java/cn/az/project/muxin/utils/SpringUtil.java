package cn.az.project.muxin.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

/**
 * @author az
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    private static Optional<?> getBean(String name) {
        return Optional.of(getApplicationContext().getBean(name));
    }

    public static <T> Optional<T> getBean(Class<T> clazz) {
        return Optional.of(getApplicationContext().getBean(clazz));
    }

    public static <T> Optional<T> getBean(String name, Class<T> clazz) {
        return Optional.of(getApplicationContext().getBean(name, clazz));
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext context) throws BeansException {
        if (Objects.isNull(applicationContext)) {
            applicationContext = context;
        }
    }
}
