package cn.az.project.test.common.annotation;

import cn.az.project.test.common.validator.CronValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Liz
 * @version 2019/12/07
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CronValidator.class)
public @interface Cron {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
