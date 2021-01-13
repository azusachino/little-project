package cn.az.project.miaosha.util;

import cn.az.project.miaosha.constant.Constants;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;
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

    public static Optional<String> getToken(HttpServletRequest request) {
        String paramToken = request.getParameter(Constants.COOKIE_NAME);
        String cookieToken = getCookieValue(request, Constants.COOKIE_NAME).orElse("");
        if (StringUtils.isAllEmpty(paramToken, cookieToken)) {
            return Optional.empty();
        }
        String token = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken;
        return Optional.of(token);

    }

    public static Optional<String> getCookieValue(HttpServletRequest req, String cookieName) {
        Cookie[] cookies = req.getCookies();
        if (Objects.isNull(cookies)) {
            return Optional.empty();
        }
        for (Cookie c : cookies) {
            if (StringUtils.equals(c.getName(), cookieName)) {
                return Optional.of(c.getValue());
            }
        }
        return Optional.empty();
    }
}
