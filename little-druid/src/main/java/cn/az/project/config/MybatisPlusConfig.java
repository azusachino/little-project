package cn.az.project.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author az
 * @since 11/17/20
 */
@MapperScan(basePackages = "cn.az.project.mapper")
@Configuration
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor interceptor() {
        return new PaginationInterceptor();
    }
}
