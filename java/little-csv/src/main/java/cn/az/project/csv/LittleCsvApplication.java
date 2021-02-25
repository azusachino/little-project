package cn.az.project.csv;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author az
 */
@SpringBootApplication
public class LittleCsvApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplicationBuilder()
            .bannerMode(Banner.Mode.OFF)
            .web(WebApplicationType.NONE)
            .build(args);
        application.run();
    }

}
