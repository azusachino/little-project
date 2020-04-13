package cn.az.project.miaosha.dao;

import cn.az.project.miaosha.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * The interface User dao.
 *
 * @author az
 * @date 2020/4/12
 */
@Repository
public interface UserDao {

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @Select("select * from user where id = #{id}")
    User getById(@Param("id") int id);

    /**
     * Insert int.
     *
     * @param user the user
     * @return the int
     */
    @Insert("insert into user(id, name) values(#{id}, #{name})")
    int insert(User user);
}
