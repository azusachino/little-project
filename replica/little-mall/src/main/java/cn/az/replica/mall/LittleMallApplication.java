package cn.az.replica.mall;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author az
 */
@SpringBootApplication
public class LittleMallApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplicationBuilder(LittleMallApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.SERVLET)
                .build();
        application.run(args);
    }

}
