package com.seven.sbinit.service;

import com.seven.sbinit.pojo.User;

import java.util.List;


public interface UserService {

    void save(User user);

    User getUserById(String id);

    List<User> getAllUser();

    User getUserByHql(String queryString, Object... params);

    void saveOrUpdtae(User user);
}
