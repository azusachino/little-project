package cn.az.project.news.db.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Liz
 */
@Configuration
@MapperScan(value = {"cn.az.news.db.mapper"})
public class MybatisPlusConfig {

    /**
     * Pagination
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
