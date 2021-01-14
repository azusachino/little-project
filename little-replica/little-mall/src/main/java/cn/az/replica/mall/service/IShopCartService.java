package cn.az.replica.mall.service;

import cn.az.replica.mall.controller.vo.ShopCartVo;
import cn.az.replica.mall.entity.ShopCart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * The interface Shopping cart item service.
 *
 * @author az
 */
public interface IShopCartService extends IService<ShopCart> {

    /**
     * Save cart.
     *
     * @param item the item
     */
    void saveCart(ShopCart item);

    /**
     * Gets cart.
     *
     * @param userId the user id
     * @return the cart
     */
    List<ShopCartVo> getCart(Long userId);
}
