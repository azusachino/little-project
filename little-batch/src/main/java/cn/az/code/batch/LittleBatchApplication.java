package cn.az.code.batch;

import cn.az.code.batch.action.BatchThreadAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author az
 */
@Slf4j
@SpringBootApplication
public class LittleBatchApplication {

    public static void main(String[] args) {
        BatchThreadAction batchAction = new BatchThreadAction();
        log.info("{} is running", BatchThreadAction.class.getName());
        batchAction.execute();
    }

}
