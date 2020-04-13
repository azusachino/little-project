package cn.az.project.miaosha.util;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @author az
 * @since 2020-04-13
 */
public class CommonUtil {

    private CommonUtil() {
    }

    private final static String MOBILE = "1\\d{10}";

    public static boolean isMobile(String src) {
        if (StringUtils.isEmpty(src)) {
            return false;
        }
        Pattern pattern = Pattern.compile(MOBILE);
        return pattern.matcher(src).matches();
    }

}
