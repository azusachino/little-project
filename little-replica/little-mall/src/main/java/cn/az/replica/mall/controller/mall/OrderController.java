package cn.az.replica.mall.controller.mall;

import cn.az.replica.mall.base.BaseController;
import cn.az.replica.mall.constant.Constants;
import cn.az.replica.mall.controller.vo.*;
import cn.az.replica.mall.domain.R;
import cn.az.replica.mall.entity.Order;
import cn.az.replica.mall.entity.OrderItem;
import cn.az.replica.mall.enums.OrderStatus;
import cn.az.replica.mall.enums.PayStatus;
import cn.az.replica.mall.enums.PayType;
import cn.az.replica.mall.exception.MallException;
import cn.az.replica.mall.service.IOrderItemService;
import cn.az.replica.mall.service.IOrderService;
import cn.az.replica.mall.service.IShopCartService;
import cn.az.replica.mall.util.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author az
 * @since 2020-03-31
 */
@Slf4j
@Controller
public class OrderController extends BaseController {

    private IShopCartService shopCartService;

    private IOrderService orderService;

    private IOrderItemService orderItemService;

    @Autowired
    public OrderController(IShopCartService shopCartService, IOrderService orderService, IOrderItemService orderItemService) {
        this.shopCartService = shopCartService;
        this.orderService = orderService;
        this.orderItemService = orderItemService;
    }

    @GetMapping("saveOrder")
    public String saveOrder() {
        UserVo userVo = (UserVo) session.getAttribute(Constants.MALL_USER_SESSION_KEY);
        List<ShopCartVo> shopCartVos = shopCartService.getCart(userVo.getUserId());

        if (CollUtil.isEmpty(shopCartVos)) {
            throw new MallException("购物车中无数据");
        }
        String orderNo = orderService.saveOrder(userVo, shopCartVos);
        return redirectTo("/orders" + orderNo);
    }

    @GetMapping("/orders/{orderNo}")
    public String orderDetail(@PathVariable("orderNo") String orderNo) {
        UserVo userVo = (UserVo) session.getAttribute(Constants.MALL_USER_SESSION_KEY);
        Order order = orderService.getOne(Wrappers.<Order>query().eq("order_no", orderNo));
        if (Objects.nonNull(order) && order.getUserId().equals(userVo.getUserId())) {
            List<OrderItem> orderItems = orderItemService.list(Wrappers.<OrderItem>query().eq("order_id", order.getOrderId()));
            if (CollUtil.isNotEmpty(orderItems)) {
                List<OrderItemVo> itemVoList = BeanUtil.copyList(orderItems, OrderItemVo.class);
                OrderDetailVo orderDetailVO = new OrderDetailVo();
                BeanUtils.copyProperties(order, orderDetailVO);
                orderDetailVO.setOrderStatusString(OrderStatus.of(orderDetailVO.getOrderStatus()).getMsg());
                orderDetailVO.setPayTypeString(PayType.of(orderDetailVO.getPayType()).getName());
                orderDetailVO.setOrderItems(itemVoList);
                request.setAttribute("orderDetailVO", orderDetailVO);
                return "mall/order-detail";
            }
            throw new MallException("订单项异常");
        }
        throw new MallException("订单详情异常");
    }

    @GetMapping("/orders")
    public String orderListPage() {
        Page<OrderListVo> page = getPage(request, Constants.ORDER_SEARCH_PAGE_LIMIT);
        UserVo userVo = (UserVo) session.getAttribute(Constants.MALL_USER_SESSION_KEY);
        Order order = new Order();
        order.setUserId(userVo.getUserId());
        List<OrderListVo> orderListVos = orderService.selectPage(page, order).getRecords();
        for (OrderListVo orderListVo : orderListVos) {
            orderListVo.setOrderStatusString(OrderStatus.of(orderListVo.getOrderStatus()).getMsg());
        }
        List<Long> ids = orderListVos.stream().map(OrderListVo::getOrderId).collect(Collectors.toList());
        List<OrderItem> orderItems = orderItemService.list(Wrappers.<OrderItem>query().in("order_id", ids));
        Map<Long, List<OrderItem>> idListMap = orderItems.stream().collect(Collectors.groupingBy(OrderItem::getOrderId));
        for (OrderListVo orderListVo : orderListVos) {
            if (idListMap.containsKey(orderListVo.getOrderId())) {
                List<OrderItem> orderItemList = idListMap.get(orderListVo.getOrderId());
                List<OrderItemVo> itemVOList = BeanUtil.copyList(orderItemList, OrderItemVo.class);
                orderListVo.setOrderItems(itemVOList);
            }
        }
        request.setAttribute("orderPageResult", orderListVos);
        request.setAttribute("path", "orders");
        return "mall/user-orders";
    }

    @ResponseBody
    @PostMapping("/orders/{orderNo}/cancel")
    public R<?> cancelOrder(@PathVariable("orderNo") String orderNo) {
        UserVo userVo = (UserVo) session.getAttribute(Constants.MALL_USER_SESSION_KEY);
        Order order = orderService.getOne(Wrappers.<Order>query().eq("order_no", orderNo));
        if (Objects.isNull(order) || !order.getUserId().equals(userVo.getUserId())) {
            throw new MallException("当前订单用户异常");
        }
        if (!order.getOrderStatus().equals(OrderStatus.ORDER_PAID.getStatus())
                || !order.getPayStatus().equals(PayStatus.PAY_SUCCESS.getStatus())) {
            throw new MallException("订单关闭异常");
        }
        order.setOrderStatus(OrderStatus.ORDER_CLOSED_BY_USER.getStatus());
        orderService.updateById(order);
        return R.success();
    }

    @ResponseBody
    @PutMapping("/orders/{orderNo}/finish")
    public R<?> finishOrder(@PathVariable("orderNo") String orderNo) {
        UserVo userVo = (UserVo) session.getAttribute(Constants.MALL_USER_SESSION_KEY);
        Order order = orderService.getOne(Wrappers.<Order>query().eq("order_no", orderNo));
        if (Objects.isNull(order) || !order.getUserId().equals(userVo.getUserId())) {
            throw new MallException("当前订单用户异常");
        }
        if (!order.getOrderStatus().equals(OrderStatus.ORDER_PAID.getStatus())
                || !order.getPayStatus().equals(PayStatus.PAY_SUCCESS.getStatus())) {
            throw new MallException("订单关闭异常");
        }
        order.setOrderStatus(OrderStatus.ORDER_SUCCESS.getStatus());
        orderService.updateById(order);
        return R.success();
    }

    @GetMapping("/selectPayType")
    public String selectPayType(@RequestParam("orderNo") String orderNo) {
        UserVo userVo = (UserVo) session.getAttribute(Constants.MALL_USER_SESSION_KEY);
        Order order = orderService.getOne(Wrappers.<Order>query().eq("order_no", orderNo));

        if (order == null || !order.getUserId().equals(userVo.getUserId())) {
            throw new MallException("当前订单用户异常");
        }

        if (!order.getOrderStatus().equals(OrderStatus.ORDER_PRE_PAY.getStatus())
                || !order.getPayStatus().equals(PayStatus.PAY_ING.getStatus())) {
            throw new MallException("订单结算异常");
        }
        request.setAttribute("orderNo", orderNo);
        request.setAttribute("totalPrice", order.getTotalPrice());
        return "mall/pay-select";
    }

    @GetMapping("/payPage")
    public String payOrder(@RequestParam("orderNo") String orderNo, @RequestParam("payType") int payType) {
        UserVo userVo = (UserVo) session.getAttribute(Constants.MALL_USER_SESSION_KEY);
        Order order = orderService.getOne(Wrappers.<Order>query().eq("order_no", orderNo));

        if (order == null || !order.getUserId().equals(userVo.getUserId())) {
            throw new MallException("当前订单用户异常");
        }

        if (!order.getOrderStatus().equals(OrderStatus.ORDER_PRE_PAY.getStatus())
                || !order.getPayStatus().equals(PayStatus.PAY_ING.getStatus())) {
            throw new MallException("订单结算异常");
        }
        request.setAttribute("orderNo", orderNo);
        request.setAttribute("totalPrice", order.getTotalPrice());
        if (payType == 1) {
            return "mall/alipay";
        } else {
            return "mall/wxpay";
        }
    }

    @ResponseBody
    @GetMapping("/paySuccess")
    public R<?> paySuccess(@RequestParam("orderNo") String orderNo, @RequestParam("payType") int payType) {
        Order order = orderService.getOne(Wrappers.<Order>query().eq("order_no", orderNo));
        if (Objects.nonNull(order)) {
            if (!order.getOrderStatus().equals(OrderStatus.ORDER_PRE_PAY.getStatus())
                    || !order.getPayStatus().equals(PayStatus.PAY_ING.getStatus())) {
                throw new MallException("订单关闭异常");
            }
            order.setOrderStatus(OrderStatus.ORDER_PAID.getStatus());
            order.setPayType(payType);
            order.setPayStatus(PayStatus.PAY_SUCCESS.getStatus());
            order.setPayTime(LocalDateTime.now());
            order.setUpdateTime(LocalDateTime.now());
            orderService.updateById(order);
        }
        return R.success();
    }

}
