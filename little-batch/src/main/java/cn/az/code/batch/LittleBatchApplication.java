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
        SpringApplication application = new SpringApplication(LittleBatchApplication.class);
        // none web project
        application.setWebApplicationType(WebApplicationType.NONE);
        log.info("{} is running", LittleBatchApplication.class.getName());
        new BatchThreadAction().execute();
        application.run(args);
    }

}
