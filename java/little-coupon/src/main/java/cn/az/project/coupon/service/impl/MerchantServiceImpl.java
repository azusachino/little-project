package cn.az.project.coupon.service.impl;

import cn.az.project.coupon.dao.MerchantMapper;
import cn.az.project.coupon.entity.Merchant;
import cn.az.project.coupon.service.IMerchantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author az
 */
@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant> implements IMerchantService {

}
