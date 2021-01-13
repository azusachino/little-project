package cn.az.project.news.db.mapper;

import cn.az.project.news.db.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Permission mapper.
 *
 * @author Liz
 */
@Component
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * Find user permissions list.
     *
     * @param username username
     * @return the list
     */
    List<Permission> findUserPermissions(@Param("username") String username);

}
