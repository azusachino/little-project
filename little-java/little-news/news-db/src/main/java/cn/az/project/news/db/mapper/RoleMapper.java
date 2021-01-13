package cn.az.project.news.db.mapper;

import cn.az.project.news.db.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Role mapper.
 *
 * @author Liz
 */
@Component
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * Find user roles list.
     *
     * @param username username
     * @return the list
     */
    List<Role> findUserRoles(@Param("username") String username);
}
