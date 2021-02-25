package cn.az.project.test.common.aspect;

import cn.az.project.test.common.properties.CommonProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Liz
 * @version 2019/10/26
 */
@Slf4j
@Aspect
@Component
public class Log4jAspect {

    @Resource
    private CommonProperties commonProperties;

    @Pointcut("@annotation(cn.az.project.test.common.annotation.Log4j)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result;
        long beginTime = System.currentTimeMillis();
        result = point.proceed();

        return result;
    }
}
