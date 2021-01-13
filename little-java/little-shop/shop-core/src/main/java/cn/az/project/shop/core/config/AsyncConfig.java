package cn.az.project.shop.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author az
 * @date 2020/3/22
 */
@EnableAsync
@Configuration
public class AsyncConfig {

    @Bean("asyncExecutor")
    public ThreadPoolTaskExecutor asyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(20);
        threadPoolTaskExecutor.setMaxPoolSize(50);
        threadPoolTaskExecutor.setKeepAliveSeconds(30);
        threadPoolTaskExecutor.setThreadNamePrefix("little_shop_async_");
        threadPoolTaskExecutor.setTaskDecorator(r -> {
            RequestAttributes qr = RequestContextHolder.getRequestAttributes();
            return () -> {
                try {
                    // transfer context to the async context
                    RequestContextHolder.setRequestAttributes(qr);
                    r.run();
                } finally {
                    RequestContextHolder.resetRequestAttributes();
                }
            };
        });
        // 停止运行
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        return threadPoolTaskExecutor;
    }
}
