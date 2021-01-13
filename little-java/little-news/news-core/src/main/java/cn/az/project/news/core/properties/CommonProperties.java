package cn.az.project.news.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Liz
 **/
@Data
@Component
@ConfigurationProperties(prefix = "common")
public class CommonProperties {

    private Boolean log;

    private String anonUrl;

    private Long timeOut = 86400L;

}
