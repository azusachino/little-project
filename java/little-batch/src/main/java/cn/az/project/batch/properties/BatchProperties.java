package cn.az.project.batch.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author az
 */
@Data
@ConfigurationProperties(prefix = "batch")
public class BatchProperties {

}
