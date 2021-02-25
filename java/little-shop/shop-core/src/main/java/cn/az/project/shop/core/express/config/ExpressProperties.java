package cn.az.project.shop.core.express.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author az
 * @since 09/09/20
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "cn.az.express")
public class ExpressProperties {
    private final List<Map<String, String>> vendors = new ArrayList<>();
    private boolean enable;
    private String appId;
    private String appKey;
}
