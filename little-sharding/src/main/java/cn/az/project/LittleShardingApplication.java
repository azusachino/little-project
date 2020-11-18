package cn.az.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author az
 * @since 11/17/20
 */
@SpringBootApplication
@MapperScan(basePackages = {"cn.az.project.mapper"})
public class LittleShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(LittleShardingApplication.class, args);
    }
}
