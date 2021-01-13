package cn.az.project.test.common.jwt;

import cn.az.project.test.common.properties.CommonProperties;
import cn.az.project.test.common.utils.SpringUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author Liz
 */
@Slf4j
public class JwtUtil {

    private static final long EXPIRE_TIME = SpringUtil.getBean(CommonProperties.class).getTimeOut() * 1000;
    private static final String CLAIM = "Liz";

    /**
     * 校验 token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String loginId, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                .withClaim(CLAIM, loginId)
                .build();
            verifier.verify(token);
            log.info("token is valid");
            return true;
        } catch (Exception e) {
            log.info("token is invalid{}", e.getMessage());
            return false;
        }
    }

    /**
     * 从 token中获取用户名
     *
     * @return token中包含的用户名
     */
    public static String getLoginId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(CLAIM).asString();
        } catch (JWTDecodeException e) {
            log.error("error：{}", e.getMessage());
            return null;
        }
    }

    /**
     * 生成 token
     *
     * @param loginId 用户名
     * @param secret  用户的密码
     * @return token
     */
    public static String sign(String loginId, String secret) {
        try {
            loginId = StringUtils.lowerCase(loginId);
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                .withClaim(CLAIM, loginId)
                .withExpiresAt(date)
                .sign(algorithm);
        } catch (Exception e) {
            log.error("error：{}", e.getMessage());
            return null;
        }
    }
}
