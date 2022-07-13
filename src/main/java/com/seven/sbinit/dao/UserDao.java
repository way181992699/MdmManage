package com.seven.sbinit.dao;

import com.seven.sbinit.pojo.User;

import java.util.List;


public interface UserDao {

    void add(User user);

    User getUserById(String id);

    List<User> getAll();

    User getByHql(String queryString, Object... params);

    void saveOrUpdate(User user);
}
