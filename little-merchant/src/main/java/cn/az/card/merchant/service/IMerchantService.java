package cn.az.card.merchant.service;

import cn.az.card.merchant.constant.ErrorCode;
import cn.az.card.merchant.entity.Merchant;
import cn.az.card.merchant.vo.CardTemplate;
import cn.az.card.merchant.vo.MerchantRequest;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * The interface Merchant service.
 *
 * @author az
 * @date 2020 /3/17
 */
public interface IMerchantService extends IService<Merchant> {

    /**
     * Create merchant int.
     *
     * @param request the request
     * @return the int
     */
    int createMerchant(MerchantRequest request);

    /**
     * Drop card template error code.
     *
     * @param template the template
     * @return the error code
     */
    ErrorCode dropCardTemplate(CardTemplate template);
}
