package cn.az.project.news.admin.shiro;

import cn.az.project.news.core.jwt.JwtUtil;
import cn.az.project.news.core.utils.CommonUtil;
import cn.az.project.news.core.utils.IpUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Objects;

/**
 * ShiroRealm
 *
 * @author <a href="mailto:azusa146@gmail.com">az</a>
 * @see AuthorizingRealm
 * @since 2020-03-20
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = JwtUtil.getUsername(principalCollection.toString());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(Collections.emptySet());
        info.setStringPermissions(Collections.emptySet());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String token = Objects.requireNonNull(authenticationToken.getCredentials()).toString();

        String ip = IpUtil.getIpAddr(CommonUtil.getHttpServletRequest());
        String encryptedToken = CommonUtil.encryptToken(token);

        return new SimpleAuthenticationInfo(token, token, getName());
    }
}
