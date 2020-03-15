package cn.az.code.batch.config;

import cn.az.code.batch.properties.BatchProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author az
 * @date 2020/3/15
 */
@Configuration
@EnableConfigurationProperties(value = {BatchProperties.class})
public class BatchConfiguration {

}
