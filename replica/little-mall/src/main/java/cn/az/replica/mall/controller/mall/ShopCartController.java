package cn.az.replica.mall.controller.mall;

import cn.az.replica.mall.constant.Constants;
import cn.az.replica.mall.controller.vo.ShopCartVo;
import cn.az.replica.mall.controller.vo.UserVo;
import cn.az.replica.mall.domain.R;
import cn.az.replica.mall.entity.ShopCart;
import cn.az.replica.mall.service.IShopCartService;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author az
 */
@Controller
public class ShopCartController {

    @Resource
    private IShopCartService cartService;

    @GetMapping("cart")
    public String cart(HttpServletRequest req, HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute(Constants.MALL_USER_SESSION_KEY);
        int itemTotal = 0;
        double priceTotal = 0.0;
        List<ShopCartVo> cartVos = cartService.getCart(userVo.getUserId());
        if (CollUtil.isNotEmpty(cartVos)) {
            itemTotal = cartVos.size();
            for (ShopCartVo vo : cartVos) {
                priceTotal += vo.getGoodsCount() * vo.getSellingPrice();
            }
        }
        req.setAttribute("itemsTotal", itemTotal);
        req.setAttribute("priceTotal", priceTotal);
        req.setAttribute("myShoppingCartItems", cartVos);
        return "mall/cart";
    }

    @GetMapping("cart/settle")
    public String settle(HttpServletRequest request, HttpSession session) {
        UserVo mallUserVO = (UserVo) session.getAttribute(Constants.MALL_USER_SESSION_KEY);
        List<ShopCart> cats = cartService.list(Wrappers.<ShopCart>query().eq("user_id", mallUserVO.getUserId()));
        if (CollectionUtils.isEmpty(cats)) {
            return "cart";
        }
        double priceTotal = 0;
        List<ShopCartVo> cartVos = cartService.getCart(mallUserVO.getUserId());
        if (CollectionUtils.isNotEmpty(cartVos)) {
            for (ShopCartVo vo : cartVos) {
                priceTotal += vo.getGoodsCount() * vo.getSellingPrice();
            }
        }
        request.setAttribute("priceTotal", priceTotal);
        request.setAttribute("myShoppingCartItems", cartVos);
        return "mall/settle";
    }

    @ResponseBody
    @RequestMapping(value = "cart", method = {RequestMethod.POST, RequestMethod.PUT})
    public R<?> save(@RequestBody ShopCart cartItem, HttpSession session) {
        UserVo userVo = (UserVo) session.getAttribute(Constants.MALL_USER_SESSION_KEY);
        cartItem.setUserId(userVo.getUserId());
        cartService.saveCart(cartItem);
        return R.success();

    }

    @ResponseBody
    @DeleteMapping("cart/{id}")
    public R<?> delete(@PathVariable("id") Long cartId) {
        if (cartService.removeById(cartId)) {
            return R.success();
        } else {
            return R.fail();
        }
    }


}
