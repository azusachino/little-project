package cn.az.project.shop.db.mapper;

import cn.az.project.shop.db.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * The interface Permission mapper.
 *
 * @author Liz
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * Gets user permission.
     *
     * @param username the username
     * @return the user permission
     */
    @Select("SELECT * FROM permission p " +
        "    LEFT JOIN role_permission rp ON p.id = rp.permission_id " +
        "    LEFT JOIN role r on r.id = rp.role_id " +
        "    LEFT JOIN admin_role ar ON r.id = ar.role_id " +
        "    LEFT JOIN admin a ON ar.admin_id = a.id " +
        "    WHERE a.USERNAME = #{username} ")
    List<Permission> getUserPermissions(@Param("username") String username);
}
