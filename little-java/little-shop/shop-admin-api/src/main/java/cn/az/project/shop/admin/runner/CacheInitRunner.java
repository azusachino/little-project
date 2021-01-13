package cn.az.project.shop.admin.runner;

import cn.az.project.shop.admin.manager.AdminManager;
import cn.az.project.shop.db.entity.Admin;
import cn.az.project.shop.db.service.IAdminService;
import cn.az.project.shop.db.service.ICacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Redis Relate Runner
 *
 * @author Liz
 */
@Order
@Slf4j
@Component
public class CacheInitRunner implements ApplicationRunner {

    @Resource
    private ICacheService cacheService;

    @Resource
    private IAdminService adminService;

    @Resource
    private AdminManager adminManager;

    @Resource
    private ConfigurableApplicationContext context;

    @Value("${spring.application.name}")
    private String application;

    @Override
    public void run(ApplicationArguments args) {
        try {
            log.info("caching admin info...");
            cacheService.testConnect();
            for (Admin admin : adminService.list()) {
                adminManager.saveUserRedisCache(admin);
            }
        } catch (Exception e) {
            log.error("Redis Connection Fail，{}", e.getMessage());
            log.error(" ____   __    _   _ ");
            log.error("| |_   / /\\  | | | |");
            log.error("|_|   /_/--\\ |_| |_|__");
            log.error("                        ");
            log.error(application + " fail to start!");
            if (e instanceof RedisConnectionFailureException) {
                log.error("Redis Connection Fail, please check redis relate settings");
            }
            context.close();
        }
    }
}
