package cn.az.project.test.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Liz
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "common")
public class CommonProperties {

    public CommonProperties() {
    }

    private Boolean log;

    private String anonUrl;

    private Long timeOut = 3600L;

}
