package cn.az.project.miaosha.service.impl;

import cn.az.project.miaosha.constant.MiaoshaUserKey;
import cn.az.project.miaosha.dao.MiaoshaUserDao;
import cn.az.project.miaosha.domain.MiaoshaUser;
import cn.az.project.miaosha.domain.vo.LoginVO;
import cn.az.project.miaosha.exception.GlobalException;
import cn.az.project.miaosha.result.CodeMessage;
import cn.az.project.miaosha.service.MiaoshaUserService;
import cn.az.project.miaosha.service.RedisService;
import cn.az.project.miaosha.util.BeanUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Optional;

/**
 * @author az
 */
@Service
public class MiaoshaUserServiceImpl implements MiaoshaUserService {

    MiaoshaUserDao miaoshaUserDao;

    RedisService redisService;

    @Autowired
    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    @Autowired
    public void setMiaoshaUserDao(MiaoshaUserDao miaoshaUserDao) {
        this.miaoshaUserDao = miaoshaUserDao;
    }

    @Override
    public MiaoshaUser getById(long id) {
        Optional<MiaoshaUser> optionalMiaoshaUser = BeanUtil.toBean(redisService.get(MiaoshaUserKey.getById() + String.valueOf(id)), MiaoshaUser.class);

        if (optionalMiaoshaUser.isPresent()) {
            return optionalMiaoshaUser.get();
        }
        MiaoshaUser mu = miaoshaUserDao.getById(id);
        if (Objects.nonNull(mu)) {
            redisService.set(MiaoshaUserKey.getById() + String.valueOf(id), BeanUtil.toString(mu).orElse(""));
        }

        return mu;

    }

    @Override
    public MiaoshaUser getByToken(HttpServletResponse res, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        Optional<MiaoshaUser> optionalMiaoshaUser = BeanUtil.toBean(redisService.get(MiaoshaUserKey.token() + token), MiaoshaUser.class);
        optionalMiaoshaUser.ifPresent(miaoshaUser -> refreshToken(res, token, miaoshaUser));
        return optionalMiaoshaUser.orElse(null);
    }

    @Override
    public boolean login(HttpServletResponse res, LoginVO loginVo) {
        if (Objects.isNull(loginVo)) {
            throw new GlobalException(CodeMessage.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile(), formPass = loginVo.getPassword();
        MiaoshaUser mu = getById(Long.parseLong(mobile));
        if (Objects.isNull(mu)) {
            throw new GlobalException(CodeMessage.MOBILE_NOT_EXIST);
        }
        String
        return false;
    }

    private void refreshToken(HttpServletResponse res, String token, MiaoshaUser mu) {
        redisService.set(MiaoshaUserKey.token() + token, BeanUtil.toString(mu).orElse(""));
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(MiaoshaUserKey.TOKEN_EXPIRE);
        cookie.setPath("/");
        res.addCookie(cookie);
    }
}
