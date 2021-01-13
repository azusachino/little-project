package cn.az.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author az
 * @since 11/17/20
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LittleDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(LittleDruidApplication.class, args);
    }
}
