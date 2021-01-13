package cn.az.project.test.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Liz
 */
@Configuration
@MapperScan(value = {"cn.az.test.system.mapper"})
public class MybatisPlusConfig {

    /**
     * paging
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
