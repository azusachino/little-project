package cn.az.project.coupon;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author az
 */
@SpringBootApplication
public class LittleCouponApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(LittleCouponApplication.class);
        application.setWebApplicationType(WebApplicationType.SERVLET);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

}
