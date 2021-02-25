package cn.az.project.news.core.autoconfigure;

import cn.az.project.news.core.annotation.Log4j;
import cn.az.project.news.core.properties.CommonProperties;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * CommonProperties
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @see CommonProperties
 * @since 2020-03-20
 */
@Configuration
@ConditionalOnClass(Log4j.class)
@EnableConfigurationProperties({CommonProperties.class})
@AutoConfigureOrder(value = 100)
public class CommonPropertiesAutoConfigure {

}
