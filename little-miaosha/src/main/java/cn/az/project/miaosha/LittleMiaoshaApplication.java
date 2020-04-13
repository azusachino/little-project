package cn.az.project.miaosha;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author az
 * @date 2020/4/12
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("cn.az.project.miaosha.dao")
public class LittleMiaoshaApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplicationBuilder(LittleMiaoshaApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.SERVLET)
                .build();
        application.run(args);
    }
}
