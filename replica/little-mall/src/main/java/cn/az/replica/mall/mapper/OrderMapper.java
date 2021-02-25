package cn.az.replica.mall.mapper;

import cn.az.replica.mall.controller.vo.OrderListVo;
import cn.az.replica.mall.entity.Order;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

/**
 * The interface Order mapper.
 *
 * @author az
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 根据 entity 条件，查询全部记录（并翻页）
     *
     * @param <E>          the type parameter
     * @param page         分页查询条件（可以为 RowBounds.DEFAULT）
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     * @return the result
     */
    <E extends IPage<OrderListVo>> E selectUserPage(E page, @Param(Constants.WRAPPER) Wrapper<Order> queryWrapper);
}
