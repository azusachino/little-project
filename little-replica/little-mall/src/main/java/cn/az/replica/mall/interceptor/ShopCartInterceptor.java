package cn.az.replica.mall.interceptor;

import cn.az.replica.mall.constant.Constants;
import cn.az.replica.mall.controller.vo.UserVo;
import cn.az.replica.mall.entity.ShopCart;
import cn.az.replica.mall.service.IShopCartService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author az
 * @since 2020-03-25
 */
public class ShopCartInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private IShopCartService shoppingCartItemService;

    /**
     * This implementation always returns {@code true}.
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param handler Object
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //购物车中的数量会更改，但是在这些接口中并没有对session中的数据做修改，这里统一处理一下
        HttpSession session = request.getSession();
        if (Objects.nonNull(session) && Objects.nonNull(session.getAttribute(Constants.MALL_USER_SESSION_KEY))) {
            //如果当前为登陆状态，就查询数据库并设置购物车中的数量值
            UserVo userVO = (UserVo) session.getAttribute(Constants.MALL_USER_SESSION_KEY);
            //设置购物车中的数量
            userVO.setShopCartItemCount(shoppingCartItemService.count(Wrappers.<ShopCart>query()
                    .eq("user_id", userVO.getUserId())));
            session.setAttribute(Constants.MALL_USER_SESSION_KEY, userVO);
        }
        return true;
    }
}
