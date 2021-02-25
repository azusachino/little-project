package cn.az.project.shop.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : Liz
 * @date : 2019/08/31 11:15
 **/
@Data
@Component
@ConfigurationProperties(prefix = "common")
public class CommonProperties {

    private Boolean log;

    private String anonUrl;

    private Long timeOut = 86400L;

}
