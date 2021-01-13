package cn.az.project.miaosha.dao;

import cn.az.project.miaosha.domain.MiaoshaOrder;
import cn.az.project.miaosha.domain.OrderInfo;
import org.springframework.stereotype.Repository;

/**
 * @author az
 */
@Repository
public interface OrderDao {


    /**
     * get MiaoSha Order
     *
     * @param userId  id
     * @param goodsId id
     * @return order
     */
    @Select("select * from miaosha_order where user_id=#{userId} and goods_id=#{goodsId}")
    MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(@Param("userId") long userId, @Param("goodsId") long goodsId);

    /**
     * get MiaoSha Order
     *
     * @param orderInfo order
     * @return success
     */
    @Insert("insert into order_info(user_id, goods_id, goods_name, goods_count, goods_price, order_channel, status, create_date)values("
        + "#{userId}, #{goodsId}, #{goodsName}, #{goodsCount}, #{goodsPrice}, #{orderChannel},#{status},#{createDate} )")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = long.class, before = false, statement = "select last_insert_id()")
    long insert(OrderInfo orderInfo);

    /**
     * get MiaoSha Order
     *
     * @param miaoshaOrder order
     * @return success
     */
    @Insert("insert into miaosha_order (user_id, goods_id, order_id)values(#{userId}, #{goodsId}, #{orderId})")
    int insertMiaoshaOrder(MiaoshaOrder miaoshaOrder);

    /**
     * get MiaoSha Order
     *
     * @param orderId id
     * @return order
     */
    @Select("select * from order_info where id = #{orderId}")
    OrderInfo getOrderById(@Param("orderId") long orderId);

    /**
     * del Orders
     */
    @Delete("truncate from order_info")
    void truncateOrders();

    /**
     * delete MiaoSha Order
     */
    @Delete("truncate from miaosha_order")
    void truncateMiaoshaOrders();

}
