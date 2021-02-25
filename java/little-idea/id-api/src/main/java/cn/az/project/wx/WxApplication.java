package cn.az.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Liz
 * @since 1/20/2020
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WxApplication {

    public static void main(String[] args) {
        // 关闭热重启
        System.setProperty("spring.devtools.restart.enable", "false");
        SpringApplication.run(WxApplication.class, args);
    }
}
