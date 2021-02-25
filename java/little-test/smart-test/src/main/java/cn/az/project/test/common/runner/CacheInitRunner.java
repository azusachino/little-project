package cn.az.project.test.common.runner;

import cn.az.project.test.common.service.CacheService;
import cn.az.project.test.system.entity.User;
import cn.az.project.test.system.manager.CodeManager;
import cn.az.project.test.system.manager.UserManager;
import cn.az.project.test.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 缓存初始化
 *
 * @author Liz
 */
@Slf4j
@Component
public class CacheInitRunner implements ApplicationRunner {

    @Resource
    private IUserService userService;

    @Resource
    private CacheService cacheService;

    @Resource
    private UserManager userManager;

    @Resource
    private CodeManager codeManager;

    @Resource
    private ConfigurableApplicationContext context;

    @Value("${spring.application.name}")
    private String application;

    @Override
    public void run(ApplicationArguments args) {
        try {
            log.info("Redis连接中 ······");
            cacheService.testConnect();

            log.info("缓存初始化 ······");
            log.info("缓存用户数据 ······");
            List<User> list = this.userService.list();
            for (User user : list) {
                userManager.saveUserRedisCache(user);
            }
            codeManager.saveCodeRedisCache();
        } catch (Exception e) {
            log.error("缓存初始化失败，{}", e.getMessage());
            log.error(" ____   __    _   _ ");
            log.error("| |_   / /\\  | | | |");
            log.error("|_|   /_/--\\ |_| |_|__");
            log.error("                        ");
            log.error(application + " 启动失败              ");
            if (e instanceof RedisConnectionFailureException) {
                log.error("Redis连接异常，请检查Redis连接配置并确保Redis服务已启动");
            }

            context.close();
        }
    }
}
