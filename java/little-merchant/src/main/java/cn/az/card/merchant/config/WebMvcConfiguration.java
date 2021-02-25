package cn.az.card.merchant.config;

import cn.az.card.merchant.security.AuthCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * Local WebMvcConfiguration
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @see WebMvcConfigurationSupport
 * @since 2020-03-18
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Resource
    private AuthCheckInterceptor authCheckInterceptor;

    /**
     * Override this method to add Spring MVC interceptors for
     * pre- and post-processing of controller invocation.
     *
     * @param registry InterceptorRegistry
     * @see InterceptorRegistry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authCheckInterceptor)
            .addPathPatterns("/merchant/*");
        super.addInterceptors(registry);
    }
}
