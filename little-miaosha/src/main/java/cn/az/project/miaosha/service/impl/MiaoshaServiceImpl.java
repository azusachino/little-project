package cn.az.project.miaosha.service.impl;

import cn.az.project.miaosha.constant.Constants;
import cn.az.project.miaosha.constant.MiaoshaUserKey;
import cn.az.project.miaosha.dao.MiaoshaUserDao;
import cn.az.project.miaosha.domain.MiaoshaUser;
import cn.az.project.miaosha.domain.vo.LoginVO;
import cn.az.project.miaosha.exception.GlobalException;
import cn.az.project.miaosha.result.CodeMessage;
import cn.az.project.miaosha.service.MiaoshaUserService;
import cn.az.project.miaosha.service.RedisService;
import cn.az.project.miaosha.util.BeanUtil;
import cn.az.project.miaosha.util.Md5Util;
import cn.hutool.core.util.IdUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Optional;

/**
 * @author az
 * @since 2020-04-13
 */
@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED, isolation = Isolation.READ_UNCOMMITTED)
public class MiaoshaServiceImpl implements MiaoshaUserService {

    private final MiaoshaUserDao miaoshaUserDao;

    private final RedisService redisService;

    @Autowired
    public MiaoshaServiceImpl(MiaoshaUserDao miaoshaUserDao, RedisService redisService) {
        this.miaoshaUserDao = miaoshaUserDao;
        this.redisService = redisService;
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @Override
    @Transactional(readOnly = true)
    public MiaoshaUser getById(long id) {
        return miaoshaUserDao.getById(id);
    }

    /**
     * Gets by token.
     *
     * @param token the token
     * @return the by token
     */
    @Override
    public MiaoshaUser getByToken(HttpServletResponse res,String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        Optional<MiaoshaUser> userOptional = BeanUtil.toBean(redisService.get(MiaoshaUserKey.token + token), MiaoshaUser.class);
        userOptional.ifPresent(user -> addCookie(res, IdUtil.fastSimpleUUID(), user));
        return userOptional.orElse(null);
    }

    /**
     * Login boolean.
     *
     * @param loginVo the login vo
     * @return the boolean
     */
    @Override
    public boolean login(HttpServletResponse res, LoginVO loginVo) {
        if (Objects.isNull(loginVo)) {
            throw new GlobalException(CodeMessage.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile(), password = loginVo.getPassword();
        //判断手机号是否存在
        MiaoshaUser user = getById(Long.parseLong(mobile));
        if (Objects.isNull(user)) {
            throw new GlobalException(CodeMessage.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        String salt = user.getSalt();
        String calcPass = Md5Util.md5All(password, salt);
        if (!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMessage.PASSWORD_ERROR);
        }
        addCookie(res, IdUtil.fastSimpleUUID(), user);
        return true;
    }

    private void addCookie(HttpServletResponse response, String token, MiaoshaUser user) {
        redisService.set(MiaoshaUserKey.token + token, BeanUtil.toString(user).orElse(""));
        Cookie cookie = new Cookie(Constants.COOKIE_NAME, token);
        cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
