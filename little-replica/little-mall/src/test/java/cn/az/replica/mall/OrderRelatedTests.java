package cn.az.replica.mall;

import cn.az.replica.mall.controller.vo.OrderListVo;
import cn.az.replica.mall.entity.Order;
import cn.az.replica.mall.service.IOrderService;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author az
 * @since 2020-04-01
 */
@SpringBootTest(classes = LittleMallApplication.class)
public class OrderRelatedTests {

    private static final Log log = Log.get();

    @Resource
    IOrderService orderService;

    @Test
    void orderTest() {
        Page<OrderListVo> page = new Page<>(1, 5);
        Order order = new Order();
        order.setUserId(1L);
        log.error(orderService.selectPage(page, order).getRecords().toString());
    }
}
