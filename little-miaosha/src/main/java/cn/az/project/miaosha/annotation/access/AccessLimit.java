package cn.az.project.miaosha.annotation.access;

import java.lang.annotation.*;

/**
 * @author az
 * @date 2020/4/23
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AccessLimit {

    int seconds();

    int maxCount();

    boolean needLogin() default true;
}
