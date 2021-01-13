package cn.az.project.miaosha.domain.vo;

import cn.az.project.miaosha.domain.MiaoshaUser;
import lombok.Data;
import lombok.ToString;

/**
 * @author az
 */
@Data
@ToString
public class GoodsDetailVO {

    private Integer miaoshaStatus;
    private Integer remainSeconds;
    private GoodsVO goods;
    private MiaoshaUser user;

}
