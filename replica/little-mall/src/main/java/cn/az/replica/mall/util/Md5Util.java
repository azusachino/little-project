package cn.az.replica.mall.util;

import cn.hutool.log.Log;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Objects;

/**
 * Md5加密方法
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @since 2020-03-24
 */
public class Md5Util {

    private Md5Util() {
        throw new Error("not allowed");
    }

    private static final Log log = Log.get();

    private static final String MD5 = "MD5";

    private static byte[] toByte(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance(MD5);
            // Resets the digest for further use.
            md.reset();
            md.update(s.getBytes(StandardCharsets.UTF_8));
            return md.digest();
        } catch (Exception e) {
            log.error("encrypt error...", e);
        }
        return null;
    }

    private static String toHex(byte[] hash) {
        if (Objects.isNull(hash)) {
            return null;
        }
        int len = hash.length;
        StringBuilder sb = new StringBuilder(len * 2);

        for (byte b : hash) {
            if ((b & 0xff) < 0x10) {
                sb.append("0");
            }
            sb.append(Long.toString(b & 0xff, 16));
        }
        return sb.toString();
    }

    public static String hash(String s) {
        try {
            return new String(Objects.requireNonNull(toHex(toByte(s)))
                    .getBytes(StandardCharsets.UTF_8),
                    StandardCharsets.UTF_8);
        } catch (Exception e) {
            log.error("not supported charset...", e);
            return s;
        }
    }

}
