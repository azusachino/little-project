package cn.az.project.miaosha.dao;

import cn.az.project.miaosha.domain.MiaoshaUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author az
 * @since 2020-04-13
 */
@Repository
public interface MiaoshaUserDao {

    /**
     * get Miaosha User By Id
     *
     * @param id id
     * @return user
     */
    @Select("select * from miaosha_user where id = #{id}")
    MiaoshaUser getById(@Param("id") long id);

    /**
     * get Miaosha User By Id
     *
     * @param mu User
     * @return success
     */
    @Update("update miaosha_user set password = #{password} where id = #{id}")
    int updateMiaoshaUser(MiaoshaUser mu);
}
