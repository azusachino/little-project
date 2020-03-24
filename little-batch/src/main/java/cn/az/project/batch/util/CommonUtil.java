package cn.az.project.batch.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author az
 * @date 2020/3/15
 */
@Slf4j
public class CommonUtil {

    protected CommonUtil() {

    }

    public static String createSpace(int len) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str.append(" ");
        }
        return str.toString();
    }
}
