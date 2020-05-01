package cn.az.project.miaosha.service;

import cn.az.project.miaosha.domain.vo.GoodsVO;

import java.util.List;

/**
 * The interface Goods service.
 *
 * @author az
 * @date 2020/4/24
 */
public interface GoodsService {

    /**
     * List goods vo list.
     *
     * @return the list
     */
    List<GoodsVO> listGoodsVO();

    /**
     * Gets goods vo by goods id.
     *
     * @param id the id
     * @return the goods vo by goods id
     */
    GoodsVO getGoodsVoByGoodsId(long id);

    /**
     * Reduce stock int.
     *
     * @param vo the vo
     * @return the int
     */
    int reduceStock(GoodsVO vo);

    /**
     * Reset stock int.
     *
     * @param vo the vo
     * @return the int
     */
    int resetStock(GoodsVO vo);
}
