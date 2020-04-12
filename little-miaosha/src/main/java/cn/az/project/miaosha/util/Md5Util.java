package cn.az.project.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author az
 * @date 2020/4/12
 */
public class Md5Util {

    private Md5Util() {
    }

    private static final String SALT = "azusachino";

    private static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }
}
