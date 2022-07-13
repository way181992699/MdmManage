package com.seven.sbinit.dao;

import com.seven.sbinit.pojo.Device;

import java.util.List;


public interface DeviceDao {

    void add(Device device);

    Device getDeviceById(String id);

    List<Device> getAll();

    void deleteDeviceById(String id);

    void deleteDeviceByDeviceId(String deviceId);

    Device getByHql(String queryString, Object... params);

    void saveOrUpdate(Device device);

    List<?> pageQuery(final String hql, final Integer page, final Integer size, final Object... objects);

    List<?> pageQuery(String hql, Object... objects);

    int count(String hql);
}
