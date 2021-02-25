package cn.az.project.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author az
 * @since 11/17/20
 */
@Configuration
@MapperScan(basePackages = "cn.az.project.mapper")
public class MybatisPlusConfig {

}
