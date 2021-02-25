package cn.az.project.news.core.jwt;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * JSON Web Token
 *
 * @author az
 */
@Data
public class JwtToken implements AuthenticationToken {

    private static final long serialVersionUID = 1282057025599826155L;

    private String token;

    private String expire;

    /**
     * Instantiates a new Jwt token.
     *
     * @param token the token
     */
    public JwtToken(String token) {
        this.token = token;
    }

    /**
     * Instantiates a new Jwt token.
     *
     * @param token  the token
     * @param expire the expire
     */
    public JwtToken(String token, String expire) {
        this.token = token;
        this.expire = expire;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

}
