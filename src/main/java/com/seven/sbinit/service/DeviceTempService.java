package com.seven.sbinit.service;

import com.seven.sbinit.pojo.DeviceTemp;

import java.util.List;


public interface DeviceTempService {

    void save(DeviceTemp deviceTemp);

    DeviceTemp getDeviceTempById(String id);

    List<DeviceTemp> getAllDeviceTemp();

    void deleteDeviceTempById(String id);

    void deleteDeviceTempByDeviceId(String deviceId);

    DeviceTemp getDeviceTempByHql(String queryString, Object... params);

    void saveOrUpdate(DeviceTemp deviceTemp);

    List<DeviceTemp> pageQuery(final String hql, final Integer page, final Integer size, final Object... objects);

    Integer getCount(String hql);

}
