package cn.az.project.shop.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Liz
 * @version 2020/01/02
 */
@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"cn.az.project.shop.admin", "cn.az.project.shop.core", "cn.az.project.shop.db"})
public class ShopAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopAdminApplication.class, args);
    }

}
