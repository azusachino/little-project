package cn.az.project.test.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * The type Md 5 util.
 *
 * @author Liz
 */
public class Md5Util {

    private static final String ALGORITHM_NAME = "md5";
    private static final int HASH_ITERATIONS = 2;

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
        return new SimpleHash(ALGORITHM_NAME, password, ByteSource.Util.bytes(password), HASH_ITERATIONS).toHex();
    }

    /**
     * Encrypt string.
     *
     * @param loginId  the username
     * @param password the password
     * @return the string
     */
    public static String encrypt(String loginId, String password) {
        return new SimpleHash(ALGORITHM_NAME, password, ByteSource.Util.bytes(loginId + password),
            HASH_ITERATIONS).toHex();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("az", "123"));
    }
}
