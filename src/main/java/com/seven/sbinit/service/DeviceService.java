package com.seven.sbinit.service;

import com.seven.sbinit.pojo.Device;

import java.util.List;


public interface DeviceService {

    void save(Device device);

    Device getDeviceById(String id);

    List<Device> getAllDevice();

    void deleteDeviceById(String id);

    void deleteDeviceByDeviceId(String deviceId);

    Device getDeviceByHql(String queryString, Object... params);

    void saveOrUpdate(Device device);

    List<Device> pageQuery(final String hql, final Integer page, final Integer size, final Object... objects);

    Integer getCount(String hql);

}
