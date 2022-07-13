package com.seven.sbinit.service.impl;

import com.seven.sbinit.dao.UserDao;
import com.seven.sbinit.pojo.User;
import com.seven.sbinit.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.add(user);
    }

    @Override
    public User getUserById(String id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAll();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserByHql(String queryString, Object... params) {
        return userDao.getByHql(queryString, params);
    }

    @Override
    public void saveOrUpdtae(User user) {
        if (null == user.getId() || "".equals(user.getId())) {
            user.setId(UUID.randomUUID().toString());
            userDao.add(user);
        } else {
            userDao.saveOrUpdate(user);
        }
    }


}
