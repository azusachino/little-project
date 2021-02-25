package cn.az.project.shop.core.storage.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author az
 * @since 09/16/20
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "cn.az.storage")
public class StorageProperties {

    private String active;
    private Local local;
    private AliYun aliYun;
    private Tencent tencent;
    private QiNiu qiNiu;

    @Data
    public static class Local {
        private String address;
        private String storagePath;
    }

    @Data
    public static class Tencent {
        private String secretId;
        private String secretKey;
        private String region;
        private String bucketName;
    }

    @Data
    public static class AliYun {
        private String endpoint;
        private String accessKeyId;
        private String accessKeySecret;
        private String bucketName;
    }

    @Data
    public static class QiNiu {
        private String endpoint;
        private String accessKey;
        private String secretKey;
        private String bucketName;
    }
}
