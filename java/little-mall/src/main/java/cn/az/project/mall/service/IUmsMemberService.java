package cn.az.project.mall.service;

import cn.az.project.mall.api.CommonResult;
import cn.az.project.mall.entity.UmsMember;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * The interface Ums member service.
 *
 * @author AzusaChino
 * @version 2019 -12-13
 */
public interface IUmsMemberService extends IService<UmsMember> {
    /**
     * 生成验证码
     *
     * @param telephone the telephone
     * @return the common result
     */
    CommonResult<?> generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     *
     * @param telephone the telephone
     * @param authCode  the auth code
     * @return the common result
     */
    CommonResult<?> verifyAuthCode(String telephone, String authCode);

}

