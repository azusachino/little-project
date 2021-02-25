package cn.az.replica.mall.util;

import cn.az.replica.mall.function.CallBack;
import cn.hutool.log.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyAccessorFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.*;

/**
 * The type Bean util.
 *
 * @author az
 * @since 2020 -03-31
 */
public class BeanUtil {

    private static final Log log = Log.get();

    private BeanUtil() {
    }

    /**
     * Copy properties.
     *
     * @param source           the source
     * @param target           the target
     * @param ignoreProperties the ignore properties
     */
    public static void copyProperties(Object source, Object target, String... ignoreProperties) {
        Objects.requireNonNull(source);
        BeanUtils.copyProperties(source, target, ignoreProperties);
    }

    /**
     * Copy list list.
     *
     * @param <T>     the type parameter
     * @param sources the sources
     * @param clazz   the clazz
     * @return the list
     */
    public static <T> List<T> copyList(List<?> sources, Class<T> clazz) {
        return copyList(sources, clazz, null);
    }

    /**
     * Copy list list.
     *
     * @param <T>      the type parameter
     * @param sources  the sources
     * @param clazz    the clazz
     * @param callback the callback
     * @return the list
     */
    public static <T> List<T> copyList(List<?> sources, Class<T> clazz, CallBack<T> callback) {
        List<T> targetList = new ArrayList<>();
        if (sources != null) {
            try {
                for (Object source : sources) {
                    T target = clazz.getConstructor().newInstance();
                    copyProperties(source, target);
                    if (callback != null) {
                        callback.set(source, target);
                    }
                    targetList.add(target);
                }
            } catch (Exception e) {
                log.warn(e);
            }
        }
        return targetList;
    }

    /**
     * To map map.
     *
     * @param bean             the bean
     * @param ignoreProperties the ignore properties
     * @return the map
     */
    public static Map<String, Object> toMap(Object bean, String... ignoreProperties) {
        Map<String, Object> map = new LinkedHashMap<>();
        List<String> ignoreList = new ArrayList<>(Arrays.asList(ignoreProperties));
        ignoreList.add("class");
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(bean);
        for (PropertyDescriptor pd : beanWrapper.getPropertyDescriptors()) {
            if (!ignoreList.contains(pd.getName()) && beanWrapper.isReadableProperty(pd.getName())) {
                Object propertyValue = beanWrapper.getPropertyValue(pd.getName());
                map.put(pd.getName(), propertyValue);
            }
        }
        return map;
    }

    /**
     * To bean t.
     *
     * @param <T>      the type parameter
     * @param map      the map
     * @param beanType the bean type
     * @return the t
     */
    public static <T> T toBean(Map<String, Object> map, Class<T> beanType) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(beanType);
        map.forEach((key, value) -> {
            if (beanWrapper.isWritableProperty(key)) {
                beanWrapper.setPropertyValue(key, value);
            }
        });
        return (T) beanWrapper.getWrappedInstance();
    }

    /**
     * 检查Pojo对象是否有null字段
     *
     * @param o   Object
     * @param clz class
     * @return check status
     */
    public static boolean checkPojoNullField(Object o, Class<?> clz) {
        try {
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(o) == null) {
                    return false;
                }
            }
            if (clz.getSuperclass() != Object.class) {
                return checkPojoNullField(o, clz.getSuperclass());
            }
            return true;
        } catch (IllegalAccessException e) {
            return false;
        }
    }
}
