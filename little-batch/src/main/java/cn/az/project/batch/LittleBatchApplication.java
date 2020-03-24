package cn.az.project.batch;

import cn.az.project.batch.action.BatchThreadAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author az
 */
@Slf4j
@SpringBootApplication
public class LittleBatchApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplicationBuilder()
                .lazyInitialization(true)
                .main(LittleBatchApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.NONE)
                .application();
        BatchThreadAction batchAction = new BatchThreadAction();
        log.info("{} is running", BatchThreadAction.class.getName());
        batchAction.execute();
    }

}
