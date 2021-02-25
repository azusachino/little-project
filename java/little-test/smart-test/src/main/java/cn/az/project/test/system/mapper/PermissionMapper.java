package cn.az.project.test.system.mapper;

import cn.az.project.test.system.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Permission mapper.
 *
 * @author Liz
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * Find user permissions list.
     *
     * @param loginId the login id
     * @return the list
     */
    List<Permission> findUserPermissions(@Param("loginId") String loginId);

}
