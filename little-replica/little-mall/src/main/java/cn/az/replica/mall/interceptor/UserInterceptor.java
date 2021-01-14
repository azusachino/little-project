package cn.az.replica.mall.interceptor;

import cn.az.replica.mall.constant.Constants;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author az
 * @since 2020-03-25
 */
public class UserInterceptor extends HandlerInterceptorAdapter {

    /**
     * This implementation always returns {@code true}.
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param handler  Object
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (Objects.isNull(request.getSession().getAttribute(Constants.MALL_USER_SESSION_KEY))) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        } else {
            return true;
        }
    }
}
