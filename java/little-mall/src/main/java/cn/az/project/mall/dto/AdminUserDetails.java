package cn.az.project.mall.dto;

import cn.az.project.mall.entity.UmsAdmin;
import cn.az.project.mall.entity.UmsPermission;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author azusachino
 * @version 12/14/2019
 */
@AllArgsConstructor
public class AdminUserDetails implements UserDetails {

    private static final long serialVersionUID = -1362384931929953839L;

    private UmsAdmin umsAdmin;
    private List<UmsPermission> permissionList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissionList.stream()
            .filter(p -> p.getValue() != null)
            .map(p -> new SimpleGrantedAuthority(p.getValue()))
            .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }
}
