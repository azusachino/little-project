package cn.az.card.merchant.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * common utils
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @since 2020-03-18
 */
public class CommonUtil {

    protected CommonUtil() {
    }

    public static String getDateAfter(String currentDate, String fmt, long len, ChronoUnit unit) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(fmt);
        return LocalDate.parse(currentDate, dtf).plus(len, unit).format(dtf);
    }
}
