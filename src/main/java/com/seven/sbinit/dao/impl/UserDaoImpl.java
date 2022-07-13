package com.seven.sbinit.dao.impl;

import com.seven.sbinit.pojo.User;
import com.seven.sbinit.dao.UserDao;
import com.seven.sbinit.dao.common.BaseDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public void add(User user) {
        super.add(user);
    }

    @Override
    public User getUserById(String id) {
        Object object = super.getById(User.class, id);
        return (User) object;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAll() {
        List<User> list = (List<User>) super.getAll(User.class);
        return list;
    }

    public User getByHql(String queryString, Object... params) {
        return (User) super.getByHql(queryString, params);
    }

    @Override
    public void saveOrUpdate(User user) {
        super.saveOrUpdate(user);
    }


}
