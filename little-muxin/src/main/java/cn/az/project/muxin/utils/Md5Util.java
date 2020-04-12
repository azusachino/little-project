package cn.az.project.muxin.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.util.Optional;

/**
 * @author az
 * @date 2020/4/10
 */
@Slf4j
public class Md5Util {

    private Md5Util() {
    }

    public static final String MD5 = "md5";

    public static Optional<String> toMd5(String raw) {
        try {
            MessageDigest md = MessageDigest.getInstance(MD5);
            return Optional.of(Base64.encodeBase64String(md.digest(raw.getBytes())));
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            return Optional.empty();
        }
    }
}
