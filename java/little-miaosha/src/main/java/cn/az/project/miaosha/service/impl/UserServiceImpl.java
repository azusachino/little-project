package cn.az.project.miaosha.service.impl;

import cn.az.project.miaosha.dao.UserDao;
import cn.az.project.miaosha.domain.User;
import cn.az.project.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Objects;

/**
 * @author az
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, rollbackFor = SQLException.class)
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    /**
     * Insert int.
     *
     * @param user the user
     * @return the int
     */
    @Override
    public int insert(User user) {
        if (Objects.isNull(user)) {
            return 0;
        }
        return userDao.insert(user);
    }
}
