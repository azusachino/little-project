package cn.az.replica.mall.util;

import org.apache.commons.lang3.time.DateUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * DateUtil
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @see DateUtils
 * @since 2020-03-24
 */
public class DateUtil extends DateUtils {

    public static final String YYYY = "yyyy";

    public static final String DATE_FORMAT_HYPHEN = "yyyy/MM/dd";

    public static final String DATE_TIME_FORMAT_GENERAL = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static String datePath() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT_HYPHEN));
    }
}
