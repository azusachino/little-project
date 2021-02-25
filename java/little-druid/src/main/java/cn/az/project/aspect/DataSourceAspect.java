package cn.az.project.aspect;

import cn.az.project.annotation.DataSource;
import cn.az.project.common.DataSourceType;
import cn.az.project.common.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author az
 * @since 11/17/20
 */
@Aspect
@Order(1)
@Component
public class DataSourceAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("@annotation(cn.az.project.annotation.DataSource)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        DataSource ds = method.getAnnotation(DataSource.class);
        if (ds == null) {
            DynamicDataSource.setDataSource(DataSourceType.FIRST);
        } else {
            DynamicDataSource.setDataSource(ds.type());
        }

        LOGGER.info("当前接口使用的数据源是 " + DynamicDataSource.getDataSource());

        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
        }

    }
}
