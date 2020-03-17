package cn.az.code.batch.action;

import cn.az.code.batch.logic.AbstractBatchLogic;
import cn.az.code.batch.logic.MainControlLogic;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author az
 * @date 2020/3/15
 */
@Slf4j
public class BatchThreadAction {

    public static Map<String, Thread> batchLogicMap = new LinkedHashMap<>();

    public void execute() {
        String functionName = BatchThreadAction.class.getName() + "execute()";

        Executor executor = new ScheduledThreadPoolExecutor(10, ThreadUtil.newNamedThreadFactory("batch-%d", true));

        try {
            AbstractBatchLogic batchLogic = new MainControlLogic();
            batchLogicMap.put(batchLogic.getClass().getName(), batchLogic);
            executor.execute(batchLogic);
        } catch (Exception e) {
            log.error("err occurred in function : " + functionName, e);
        }
    }

}
