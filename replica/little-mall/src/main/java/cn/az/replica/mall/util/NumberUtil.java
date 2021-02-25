package cn.az.replica.mall.util;

import cn.hutool.core.util.RandomUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author az
 * @since 2020-03-25
 */
public class NumberUtil {

    public static final String PHONE = "^((13[0-9])|(14[5,7])|(15[^4,\\D])|(17[0-8])|(18[0-9]))\\d{8}$";

    private NumberUtil() {
        throw new Error("not allowed");
    }

    /**
     * 判断是否为11位电话号码
     *
     * @param phone 电话号码
     */
    public static boolean isPhone(String phone) {
        Pattern pattern = Pattern.compile(PHONE);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    /**
     * 生成订单流水号
     *
     * @return 订单流水号
     */
    public static String generateOrderNo() {
        StringBuilder buffer = new StringBuilder(String.valueOf(System.currentTimeMillis()));
        int num = RandomUtil.randomInt(0, 1000);
        buffer.append(num);
        return buffer.toString();
    }
}
