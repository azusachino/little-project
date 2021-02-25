package cn.az.project.batch.action;

import cn.az.project.batch.concurrent.DelegateThreadFactory;
import cn.az.project.batch.logic.AbstractBatchLogic;
import cn.az.project.batch.logic.MainControlLogic;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author az
 */
@Slf4j
public class BatchThreadAction {

    public static Map<String, Thread> batchLogicMap = new LinkedHashMap<>();

    public void execute() {
        String functionName = BatchThreadAction.class.getName() + "execute()";
        DelegateThreadFactory threadFactory = new DelegateThreadFactory(ThreadUtil.newNamedThreadFactory("batch-%d", true), batchLogicMap);
        ExecutorService service = new ScheduledThreadPoolExecutor(10, threadFactory);

        try {
            AbstractBatchLogic batchLogic = new MainControlLogic();
            service.submit(batchLogic);
        } catch (Exception e) {
            log.error("err occurred in function : " + functionName, e);
        }
    }

}
