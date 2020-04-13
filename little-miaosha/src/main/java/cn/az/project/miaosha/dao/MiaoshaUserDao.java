package cn.az.project.miaosha.dao;

import cn.az.project.miaosha.domain.MiaoshaUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author az
 * @since 2020-04-13
 */
@Repository
public interface MiaoshaUserDao {

    @Select("select * from miaosha_user where id = #{id}")
    MiaoshaUser getById(@Param("id") long id);
}
