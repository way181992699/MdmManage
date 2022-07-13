package com.seven.sbinit.dao;

import com.seven.sbinit.pojo.Command;

import java.util.List;

public interface CommandDao {

    void add(Command command);

    Command getCommandById(String id);

    List<Command> getAll();

    void deleteCommandById(String id);

    void deleteCommandByDeviceId(String deviceId);

    Command getByHql(String queryString, Object... params);

    void saveOrUpdate(Command command);

    List<?> pageQuery(final String hql, final Integer page, final Integer size, final Object... objects);

    List<?> pageQuery(String hql, Object... objects);

    int count(String hql);

    List<Command> getAllByHql(String queryString, Object... params);
}
