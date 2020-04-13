package cn.az.project.miaosha.config;

import cn.az.project.miaosha.constant.Constants;
import cn.az.project.miaosha.domain.MiaoshaUser;
import cn.az.project.miaosha.service.MiaoshaUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Optional;

/**
 * @author az
 * @date 2020/4/12
 */
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private MiaoshaUserService userService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz = parameter.getParameterType();
        return clazz == MiaoshaUser.class;
    }

    @Override
    public Object resolveArgument(@NonNull MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        HttpServletRequest req = Objects.requireNonNull(webRequest.getNativeRequest(HttpServletRequest.class));
        HttpServletResponse res = Objects.requireNonNull(webRequest.getNativeResponse(HttpServletResponse.class));

        String paramToken = req.getParameter(Constants.COOKIE_NAME);
        String cookieToken = getCookieValue(req).orElse("");
        if (StringUtils.isAllEmpty(paramToken, cookieToken)) {
            return null;
        }
        String token = StringUtils.isEmpty(paramToken) ? cookieToken : paramToken;
        return userService.getByToken(res, token);
    }

    private Optional<String> getCookieValue(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (Objects.isNull(cookies)) {
            return Optional.empty();
        }
        for (Cookie c : cookies) {
            if (StringUtils.equals(c.getName(), Constants.COOKIE_NAME)) {
                return Optional.of(c.getValue());
            }
        }
        return Optional.empty();
    }
}
