package cn.az.project.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author az
 */
@EnableScheduling
@EnableTransactionManagement
@MapperScan("cn.az.project.shop.db.mapper")
@SpringBootApplication(scanBasePackages = "cn.az.project.shop")
public class LittleShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(LittleShopApplication.class, args);
    }
}
