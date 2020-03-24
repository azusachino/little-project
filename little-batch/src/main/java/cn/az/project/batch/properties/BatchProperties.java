package cn.az.project.batch.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author az
 * @date 2020/3/15
 */
@Data
@ConfigurationProperties(prefix = "batch")
public class BatchProperties {

}
