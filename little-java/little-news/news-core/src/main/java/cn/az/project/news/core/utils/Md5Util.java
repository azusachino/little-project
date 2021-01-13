package cn.az.project.news.core.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.security.MessageDigest;

/**
 * The type Md 5 util.
 *
 * @author Liz
 */
public class Md5Util {

    private static final String MD5 = "MD5";
    private static final int HASH_ITERATIONS = 2;
    private static final String[] HEX = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * Instantiates a new Md 5 util.
     */
    protected Md5Util() {

    }

    /**
     * Encrypt string.
     *
     * @param password the password
     * @return the string
     */
    public static String encrypt(String password) {
        return new SimpleHash(MD5, password, ByteSource.Util.bytes(password), HASH_ITERATIONS).toHex();
    }

    /**
     * Encrypt string.
     *
     * @param username the username
     * @param password the password
     * @return the string
     */
    public static String encrypt(String username, String password) {
        return new SimpleHash(MD5, password, ByteSource.Util.bytes(username + password),
            HASH_ITERATIONS).toHex();
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte value : b) {
            resultSb.append(byteToHexString(value));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX[d1] + HEX[d2];
    }

    public static String md5Encode(String origin) {
        return md5Encode(origin, "UTF-8");
    }

    public static String md5Encode(String origin, String charsetName) {
        if (StringUtils.isEmpty(origin)) {
            return origin;
        }
        String resultString = null;
        try {
            MessageDigest md = MessageDigest.getInstance(MD5);
            if (StringUtils.isEmpty(charsetName)) {
                resultString = byteArrayToHexString(md.digest(origin.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(origin.getBytes(charsetName)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("az"));
        System.out.println(md5Encode("az"));
    }
}
