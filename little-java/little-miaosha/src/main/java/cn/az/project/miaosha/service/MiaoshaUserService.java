package cn.az.project.miaosha.service;

import cn.az.project.miaosha.domain.MiaoshaUser;
import cn.az.project.miaosha.domain.vo.LoginVO;

import javax.servlet.http.HttpServletResponse;

/**
 * The interface Miaosha user service.
 *
 * @author az
 * @since 2020-04-13
 */
public interface MiaoshaUserService {

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    MiaoshaUser getById(long id);

    /**
     * Gets by token.
     *
     * @param res   the res
     * @param token the token
     * @return the by token
     */
    MiaoshaUser getByToken(HttpServletResponse res, String token);

    /**
     * Login boolean.
     *
     * @param res     the res
     * @param loginVo the login vo
     * @return the boolean
     */
    boolean login(HttpServletResponse res, LoginVO loginVo);
}
