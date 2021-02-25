package cn.az.project.shop.db.utils;

import cn.az.project.shop.db.domain.OrderHandlerOption;
import cn.az.project.shop.db.entity.Order;
import cn.az.project.shop.db.enums.OrderStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 订单流程：下单成功－》支付订单－》发货－》收货
 * 订单状态：
 * 101 订单生成，未支付；102，下单未支付用户取消；103，下单未支付超期系统自动取消
 * 201 支付完成，商家未发货；202，订单生产，已付款未发货，用户申请退款；203，管理员执行退款操作，确认退款成功；
 * 301 商家发货，用户未确认；
 * 401 用户确认收货，订单结束； 402 用户没有确认收货，但是快递反馈已收货后，超过一定时间，系统自动确认收货，订单结束。
 * <p>
 * 当101用户未付款时，此时用户可以进行的操作是取消或者付款
 * 当201支付完成而商家未发货时，此时用户可以退款
 * 当301商家已发货时，此时用户可以有确认收货
 * 当401用户确认收货以后，此时用户可以进行的操作是退货、删除、去评价或者再次购买
 * 当402系统自动确认收货以后，此时用户可以删除、去评价、或者再次购买
 *
 * @author Liz
 */
public class OrderUtil {

    public static final Integer STATUS_CREATE = 101;
    public static final Integer STATUS_PAY = 201;
    public static final Integer STATUS_SHIP = 301;
    public static final Integer STATUS_CONFIRM = 401;
    public static final Integer STATUS_CANCEL = 102;
    public static final Integer STATUS_AUTO_CANCEL = 103;
    public static final Integer STATUS_ADMIN_CANCEL = 104;
    public static final Integer STATUS_REFUND = 202;
    public static final Integer STATUS_REFUND_CONFIRM = 203;
    public static final Integer STATUS_AUTO_CONFIRM = 402;
    public static final Integer STATUS_PAY_GROUPON = 200;
    public static final Integer STATUS_TIMEOUT_GROUPON = 204;


    public static String orderStatusText(Order order) {
        OrderStatus status = order.getOrderStatus();
        return status.getStatus();
    }


    public static OrderHandlerOption build(Order order) {
        OrderStatus status = order.getOrderStatus();
        OrderHandlerOption handleOption = new OrderHandlerOption();
        switch (status) {
            case STATUS_CREATE:
                // 如果订单没有被取消，且没有支付，则可支付，可取消
                handleOption.setCancel(true);
                handleOption.setPay(true);
                break;
            case STATUS_CANCEL:
            case STATUS_AUTO_CANCEL:
            case STATUS_ADMIN_CANCEL:
            case STATUS_REFUND_CONFIRM:
                // 如果订单，则可删除
                // 如果订单已经取消或是已完成,已经退款，则可删除
                handleOption.setDelete(true);
                break;
            case STATUS_PAY_GROUP:
            case STATUS_PAY:
                // 如果订单已付款，没有发货，则可退款
                handleOption.setRefund(true);
                break;
            case STATUS_SHIP:
                // 如果订单已经发货，没有收货，则可收货操作,
                // 此时不能取消订单
                handleOption.setConfirm(true);
                break;
            case STATUS_CONFIRM:
            case STATUS_AUTO_CONFIRM:
                // 如果订单已经支付，且已经收货，则可删除、去评论和再次购买
                handleOption.setDelete(true);
                handleOption.setComment(true);
                handleOption.setReBuy(true);
                break;
            default:
                break;

        }

        return handleOption;
    }

    public static List<Integer> orderStatus(Integer showType) {
        // 全部订单
        if (showType.equals(0)) {
            return null;
        }

        List<Integer> status = new ArrayList<>(2);

        if (showType.equals(1)) {
            // 待付款订单
            status.add(101);
        } else if (showType.equals(2)) {
            // 待发货订单
            status.add(201);
        } else if (showType.equals(3)) {
            // 待收货订单
            status.add(301);
        } else if (showType.equals(4)) {
            // 待评价订单
            status.add(401);
//            系统超时自动取消，此时应该不支持评价
//            status.add((Integer
//           )402);
        } else {
            return null;
        }

        return status;
    }


    public static boolean isCreateStatus(Order order) {
        return OrderUtil.STATUS_CREATE.equals(order.getOrderStatus().getVal());
    }

    public static boolean hasPayed(Order order) {
        return !OrderUtil.STATUS_CREATE.equals(order.getOrderStatus().getVal())
            && !OrderUtil.STATUS_CANCEL.equals(order.getOrderStatus().getVal())
            && !OrderUtil.STATUS_AUTO_CANCEL.equals(order.getOrderStatus().getVal());
    }

    public static boolean isPayStatus(Order order) {
        return OrderUtil.STATUS_PAY.equals(order.getOrderStatus().getVal());
    }

    public static boolean isShipStatus(Order order) {
        return OrderUtil.STATUS_SHIP.equals(order.getOrderStatus().getVal());
    }

    public static boolean isConfirmStatus(Order order) {
        return OrderUtil.STATUS_CONFIRM.equals(order.getOrderStatus().getVal());
    }

    public static boolean isCancelStatus(Order order) {
        return OrderUtil.STATUS_CANCEL.equals(order.getOrderStatus().getVal());
    }

    public static boolean isAutoCancelStatus(Order order) {
        return OrderUtil.STATUS_AUTO_CANCEL.equals(order.getOrderStatus().getVal());
    }

    public static boolean isRefundStatus(Order order) {
        return OrderUtil.STATUS_REFUND.equals(order.getOrderStatus().getVal());
    }

    public static boolean isRefundConfirmStatus(Order order) {
        return OrderUtil.STATUS_REFUND_CONFIRM.equals(order.getOrderStatus().getVal());
    }

    public static boolean isAutoConfirmStatus(Order order) {
        return OrderUtil.STATUS_AUTO_CONFIRM.equals(order.getOrderStatus().getVal());
    }
}
