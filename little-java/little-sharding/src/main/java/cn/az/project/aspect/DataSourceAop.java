package cn.az.project.aspect;

import cn.az.project.common.DataSourceType;
import io.shardingsphere.api.HintManager;
import io.shardingsphere.core.hint.HintManagerHolder;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author az
 * @since 11/18/20
 */
@Aspect
@Order(1)
@Component
public class DataSourceAop {

    public static final Logger logger = LoggerFactory.getLogger(DataSourceAop.class);

    /**
     * mysql库切入点,读写分离 shading jdbc控制
     */
    @Pointcut("execution(* cn.az.project.mapper.first..*.*(..))")
    public void switchFirst() {
    }

    @Before("switchFirst()")
    public void switchFirstBefore() {
        HintManager hintManager = HintManager.getInstance();
        hintManager.setDatabaseShardingValue(DataSourceType.FIRST);
        logger.info("切换到MYSQL数据源~");
    }

    /**
     * 恢复默认数据源
     */
    @After("switchFirst()")
    public void switchFirstAfter() {
        //清理掉当前设置的数据源，让默认的数据源不受影响
        HintManager hintManager = HintManagerHolder.get();
        if (hintManager != null) {
            hintManager.close();
        }
    }

    /**
     * pg库切入点,读写分离shading jdbc控制
     */
    @Pointcut("execution(* cn.az.project.mapper.second..*.*(..))")
    public void switchSecond() {
    }

    @Before("switchSecond()")
    public void switchSecondBefore() {
        HintManager hintManager = HintManager.getInstance();
        hintManager.setDatabaseShardingValue(DataSourceType.SECOND);
        logger.info("切换到POSTGRE数据源~");
    }

    /**
     * 恢复默认数据源
     */
    @After("switchSecond()")
    public void switchSecondAfter() {
        //清理掉当前设置的数据源，让默认的数据源不受影响
        HintManager hintManager = HintManagerHolder.get();
        if (hintManager != null) {
            hintManager.close();
        }
    }
}
