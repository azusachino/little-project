package cn.az.card.merchant;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author az
 */
@SpringBootApplication
public class LittleMerchantApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(LittleMerchantApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.setWebApplicationType(WebApplicationType.SERVLET);
        application.run(args);
    }

}
