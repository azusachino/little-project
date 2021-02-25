package cn.az.project.mall.mapper;

import cn.az.project.mall.entity.UmsAdmin;
import cn.az.project.mall.entity.UmsPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Ums admin mapper.
 *
 * @author AzusaChino
 * @version 2019 -12-14
 */
@Repository
public interface UmsAdminMapper extends BaseMapper<UmsAdmin> {

    /**
     * Gets permission list.
     *
     * @param id the id
     * @return the permission list
     */
    List<UmsPermission> getPermissionList(long id);

}
