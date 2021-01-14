package cn.az.replica.mall.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author az
 * @since 2020-03-25
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

    /**
     * This implementation always returns {@code true}.
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param handler  Object
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (Objects.isNull(session.getAttribute("loginUser"))) {
            session.setAttribute("errorMsg", "please login");
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        } else {
            session.removeAttribute("errorMsg");
            return true;
        }
    }
}
