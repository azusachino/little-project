package cn.az.project.test.common.task;

import cn.az.project.test.common.constant.Setting;
import cn.az.project.test.common.service.RedisService;
import cn.az.project.test.common.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * clear expired user
 *
 * @author Liz
 * @version 2019/12/07
 */

@Slf4j
@Component
public class CacheTask {

    @Resource
    private RedisService redisService;

    @Scheduled(fixedRate = 3600000)
    public void run() {
        try {
            String now = DateUtil.formatFullTime(LocalDateTime.now());
            redisService.zremrangeByScore(Setting.ACTIVE_USERS_ZSET_PREFIX, "-inf", now);
            log.info("delete expired user");
        } catch (Exception ignore) {
        }
    }
}
