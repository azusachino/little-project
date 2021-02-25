package cn.az.project.shop.db.mapper;

import cn.az.project.shop.db.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * The interface Role mapper.
 *
 * @author Liz
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * Gets user roles.
     *
     * @param username the username
     * @return the user roles
     */
    @Select(" SELECT * FROM role r " +
        "           LEFT JOIN admin_role ar on ar.role_id = r.id " +
        "           LEFT JOIN admin a ON ar.admin_id = a.id " +
        "    WHERE a.USERNAME = #{username} ")
    List<Role> getUserRoles(@Param("username") String username);

}
