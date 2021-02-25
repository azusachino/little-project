package cn.az.replica.mall.service;

import cn.az.replica.mall.controller.vo.OrderListVo;
import cn.az.replica.mall.controller.vo.ShopCartVo;
import cn.az.replica.mall.controller.vo.UserVo;
import cn.az.replica.mall.entity.Order;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * The interface Order service.
 *
 * @author az
 */
public interface IOrderService extends IService<Order> {

    /**
     * Save order string.
     *
     * @param userVo         the user vo
     * @param shopCartVoList the shop cart vo list
     * @return the string
     */
    String saveOrder(UserVo userVo, List<ShopCartVo> shopCartVoList);

    /**
     * Select order list page.
     *
     * @param voPage the vo page
     * @param order  the order
     * @return the page
     */
    IPage<OrderListVo> selectPage(Page<OrderListVo> voPage, Order order);

    /**
     * Select page page.
     *
     * @param orderPage the order page
     * @param order     the order
     * @return the page
     */
    IPage<Order> selectPage(Page<Order> orderPage);
}
