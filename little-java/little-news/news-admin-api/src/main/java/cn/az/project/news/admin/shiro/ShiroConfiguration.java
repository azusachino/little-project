package cn.az.project.news.admin.shiro;

import cn.az.project.news.core.jwt.JwtFilter;
import cn.hutool.core.map.MapUtil;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ShiroConfiguration
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @see ShiroRealm
 * @since 2020-03-20
 */
@Configuration
public class ShiroConfiguration {

    private static final String JWT = "jwt";

    @Autowired
    private ShiroRealm shiroRealm;

    @Bean
    public SessionsSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

        factoryBean.setSecurityManager(securityManager());
        Map<String, Filter> filters = MapUtil.createMap(LinkedHashMap.class);
        filters.put(JWT, jwtFilter());
        factoryBean.setFilters(filters);

        Map<String, String> filterChain = MapUtil.createMap(LinkedHashMap.class);
        filterChain.put("/*", JWT);
        factoryBean.setFilterChainDefinitionMap(filterChain);
        return factoryBean;
    }

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }
}
