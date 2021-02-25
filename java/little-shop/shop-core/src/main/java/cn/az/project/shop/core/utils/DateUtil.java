package cn.az.project.shop.core.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author Liz
 */
public class DateUtil {

    /**
     * The constant FULL_TIME_PATTERN.
     */
    public static final String FULL_TIME_PATTERN = "yyyyMMddHHmmss";

    /**
     * The constant FULL_TIME_SPLIT_PATTERN.
     */
    public static final String FULL_TIME_SPLIT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * Format full time string.
     *
     * @param localDateTime the local date time
     * @return the string
     */
    public static String formatFullTime(LocalDateTime localDateTime) {
        return formatFullTime(localDateTime, FULL_TIME_PATTERN);
    }

    /**
     * Format full time string.
     *
     * @param localDateTime the local date time
     * @param pattern       the pattern
     * @return the string
     */
    public static String formatFullTime(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(dateTimeFormatter);
    }

    private static String getDateFormat(Date date, String dateFormatType) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormatType);
        return sdf.format(date);
    }
}
