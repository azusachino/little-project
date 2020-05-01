package cn.az.project.miaosha.dao;

import cn.az.project.miaosha.domain.MiaoshaGoods;
import cn.az.project.miaosha.domain.vo.GoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author az
 * @date 2020/4/23
 */
@Mapper
public interface GoodsDao {

    /**
     * List Goods
     *
     * @return list
     */
    @Select("select g.*,mg.stock_count, mg.start_date, mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id")
    List<GoodsVO> listGoodsVo();

    /**
     * find goods
     *
     * @param goodsId id
     * @return good
     */
    @Select("select g.*,mg.stock_count, mg.start_date, mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id where g.id = #{goodsId}")
    GoodsVO getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

    /**
     * update Goods
     *
     * @param g goods
     * @return result
     */
    @Update("update miaosha_goods set stock_count = stock_count - 1 where goods_id = #{goodsId} and stock_count > 0")
    int reduceStock(MiaoshaGoods g);

    /**
     * reset stock
     *
     * @param g goods
     * @return result
     */
    @Update("update miaosha_goods set stock_count = #{stockCount} where goods_id = #{goodsId}")
    int resetStock(MiaoshaGoods g);

}
