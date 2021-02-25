package cn.az.project.test.system.mapper;

import cn.az.project.test.system.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Role mapper.
 *
 * @author Liz
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * Find user roles list.
     *
     * @param loginId the login id
     * @return the list
     */
    List<Role> findUserRoles(@Param("loginId") String loginId);
}
