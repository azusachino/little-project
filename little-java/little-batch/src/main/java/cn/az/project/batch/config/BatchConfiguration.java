package cn.az.project.batch.config;

import cn.az.project.batch.properties.BatchProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author az
 */
@Configuration
@EnableConfigurationProperties(value = {BatchProperties.class})
public class BatchConfiguration {

}
