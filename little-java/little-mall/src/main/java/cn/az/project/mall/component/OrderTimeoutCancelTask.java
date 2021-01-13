package cn.az.project.mall.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Liz
 */
@Slf4j
@Component
public class OrderTimeoutCancelTask {

    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeoutOrder() {
        log.info("取消订单，并根据sku编号释放锁定库存");
    }
}
