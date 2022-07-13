package com.seven.sbinit.dao;

import com.seven.sbinit.pojo.DeviceTemp;

import java.util.List;


public interface DeviceTempDao {

    void add(DeviceTemp deviceTemp);

    DeviceTemp getDeviceTempById(String id);

    List<DeviceTemp> getAll();

    void deleteDeviceTempById(String id);

    void deleteDeviceTempByDeviceId(String deviceId);

    DeviceTemp getByHql(String queryString, Object... params);

    void saveOrUpdate(DeviceTemp deviceTemp);

    List<?> pageQuery(final String hql, final Integer page, final Integer size, final Object... objects);

    List<?> pageQuery(String hql, Object... objects);

    int count(String hql);
}
