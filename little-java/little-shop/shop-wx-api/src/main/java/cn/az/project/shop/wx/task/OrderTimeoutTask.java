package cn.az.project.shop.wx.task;

import cn.az.project.shop.core.task.Task;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Liz
 * @date 1/18/2020
 */
@Slf4j
public class OrderTimeoutTask extends Task {

    private final int orderId;

    public OrderTimeoutTask(Integer orderId, long delayInMilliseconds) {
        super("OrderTimeOutTask-" + orderId, delayInMilliseconds);
        this.orderId = orderId;
    }

    public OrderTimeoutTask(Integer orderId){
        super("OrderUnpaidTask-" + orderId, 30 * 60 * 1000);
        this.orderId = orderId;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     */
    @Override
    public String call() {
        log.info("系统开始处理延时任务---订单超时未付款---" + this.orderId);
/*
        IOrderService orderService = SpringUtil.getBean(IOrderService.class);
        IOrderProductService productService = SpringUtil.getBean(IOrderProductService.class);

        Order order = orderService.getById(this.orderId);
        if(order == null){
            return "";
        }
        if(!OrderUtil.isCreateStatus(order)){
            return "";
        }

        // 设置订单已取消状态
        order.setOrderStatus(OrderUtil.STATUS_AUTO_CANCEL.intValue());
        order.setEndTime(LocalDateTime.now());
        if (orderService.updateWithOptimisticLocker(order) == 0) {
            throw new RuntimeException("更新数据已失效");
        }

        // 商品货品数量增加
        Integer orderId = order.getId();
        List<OrderProduct> orderGoodsList = orderGoodsService.queryByOid(orderId);
        for (OrderProduct orderProduct : orderGoodsList) {
            Integer productId = orderProduct.getProductId();
            Short number = orderProduct.getNumber().shortValue();
            if (productService.addStock(productId, number) == 0) {
                throw new RuntimeException("商品货品库存增加失败");
            }
        }*/
        log.info("系统结束处理延时任务---订单超时未付款---" + this.orderId);
        return "";
    }
}
