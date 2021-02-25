package cn.az.card.merchant.service.impl;

import cn.az.card.merchant.constant.Constants;
import cn.az.card.merchant.constant.ErrorCode;
import cn.az.card.merchant.dao.MerchantMapper;
import cn.az.card.merchant.entity.Merchant;
import cn.az.card.merchant.service.IMerchantService;
import cn.az.card.merchant.vo.CardTemplate;
import cn.az.card.merchant.vo.MerchantRequest;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author az
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.MANDATORY, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant> implements IMerchantService {

    /**
     * kafka 客户端
     */
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public int createMerchant(MerchantRequest request) {

        ErrorCode errorCode = validate(request);
        if (ErrorCode.SUCCESS.equals(errorCode)) {
            if (save(request.toMerchant())) {
                return getOne(Wrappers.<Merchant>query().eq("name", request.getName())).getId();
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    @Override
    public ErrorCode dropCardTemplate(CardTemplate template) {
        ErrorCode errorCode = validate(template);
        if (ErrorCode.SUCCESS.equals(errorCode)) {
            String passTemplate = JSON.toJSONString(template);
            kafkaTemplate.send(
                Constants.TEMPLATE_TOPIC,
                Constants.TEMPLATE_TOPIC,
                passTemplate
            );
            log.info("DropPassTemplates: {}", passTemplate);
        }
        return errorCode;
    }

    /**
     * <h2>验证请求的有效性</h2>
     *
     * @param request {@link MerchantRequest}
     * @return {@link ErrorCode}
     */
    public ErrorCode validate(MerchantRequest request) {

        if (Objects.nonNull(getOne(Wrappers.<Merchant>query().eq("name", request.getName())))) {
            return ErrorCode.DUPLICATE_NAME;
        }

        if (null == request.getLogoUrl()) {
            return ErrorCode.EMPTY_LOGO;
        }

        if (null == request.getBusinessLicenseUrl()) {
            return ErrorCode.EMPTY_BUSINESS_LICENSE;
        }

        if (null == request.getAddress()) {
            return ErrorCode.EMPTY_ADDRESS;
        }

        if (null == request.getPhone()) {
            return ErrorCode.ERROR_PHONE;
        }
        return ErrorCode.SUCCESS;
    }

    /**
     * <h2>校验优惠券对象的有效性</h2>
     *
     * @param template {@link CardTemplate}
     * @return {@link ErrorCode}
     */
    public ErrorCode validate(CardTemplate template) {

        if (Objects.isNull(getById(template.getId()))) {
            return ErrorCode.MERCHANT_NOT_EXIST;
        }

        return ErrorCode.SUCCESS;
    }
}
