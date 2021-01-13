package cn.az.project.shop.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author az
 * @since 09/09/20
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "cn.az.wx")
public class WxProperties {

    private String appId;

    private String appSecret;

    private String mchId;

    private String mchKey;

    private String notifyUrl;

    private String keyPath;
}
