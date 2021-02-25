package cn.az.project.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author az
 */
public class Md5Util {

    private Md5Util() {
    }

    private static final String SALT = "azusachino";

    private static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }

    public static String md5First(String input) {
        String str = SALT.charAt(0) + SALT.charAt(2) + input + SALT.charAt(5) + SALT.charAt(4);
        return md5(str);
    }

    public static String md5Second(String formInput, String salt) {
        String str = salt.charAt(0) + salt.charAt(2) + formInput + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String md5All(String input, String salt) {
        return md5Second(md5First(input), salt);
    }
}
