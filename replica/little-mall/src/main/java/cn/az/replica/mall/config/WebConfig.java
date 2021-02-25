package cn.az.replica.mall.config;

import cn.az.replica.mall.constant.Constants;
import cn.az.replica.mall.interceptor.AdminInterceptor;
import cn.az.replica.mall.interceptor.ShopCartInterceptor;
import cn.az.replica.mall.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author az
 * @since 2020-03-25
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${upload.dir:/temp/upload}")
    private String uploadDir;

    /**
     * Override this method to add Spring MVC interceptors for
     * pre- and post-processing of controller invocation.
     *
     * @param registry InterceptorRegistry
     * @see InterceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/dist/**")
                .excludePathPatterns("/admin/plugins/**");
        registry.addInterceptor(userInterceptor())
                .excludePathPatterns("/login")
                .excludePathPatterns("/logout")
                .excludePathPatterns("/register")
                .excludePathPatterns("/upload/**")
                .excludePathPatterns("/goods-img/**")
                .excludePathPatterns("/common/**")
                .excludePathPatterns("/mall/**")
                .excludePathPatterns("/admin/**");
        registry.addInterceptor(shopCartInterceptor())
                .excludePathPatterns("/admin/**")
                .excludePathPatterns("/register")
                .excludePathPatterns("/login")
                .excludePathPatterns("/logout");
    }

    /**
     * Override this method to add resource handlers for serving static resources.
     *
     * @param registry ResourceHandlerRegistry
     * @see ResourceHandlerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:" + uploadDir + "/");
        registry.addResourceHandler("/goods/img/**")
                .addResourceLocations("file:" + Constants.FILE_UPLOAD_DIR);
    }

    /**
     * Override this method to add view controllers.
     *
     * @param registry ViewControllerRegistry
     * @see ViewControllerRegistry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/index");
    }

    @Bean
    public ShopCartInterceptor shopCartInterceptor() {
        return new ShopCartInterceptor();
    }

    @Bean
    public AdminInterceptor adminInterceptor() {
        return new AdminInterceptor();
    }

    @Bean
    public UserInterceptor userInterceptor() {
        return new UserInterceptor();
    }
}
