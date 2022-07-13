package com.seven.sbinit.service.impl;

import com.seven.sbinit.pojo.Device;
import com.seven.sbinit.dao.DeviceDao;
import com.seven.sbinit.service.DeviceService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class DeviceServiceImpl implements DeviceService {

    private DeviceDao deviceDao;

    @Override
    public void save(Device device) {
        deviceDao.add(device);
    }

    @Override
    public Device getDeviceById(String id) {
        return deviceDao.getDeviceById(id);
    }

    @Override
    public List<Device> getAllDevice() {
        return deviceDao.getAll();
    }

    public DeviceDao getDeviceDao() {
        return deviceDao;
    }

    @Resource
    public void setDeviceDao(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    @Override
    public Device getDeviceByHql(String queryString, Object... params) {
        return deviceDao.getByHql(queryString, params);
    }

    @Override
    public void saveOrUpdate(Device device) {
        if (null == device.getId() || "".equals(device.getId())) {
            device.setId(UUID.randomUUID().toString());
            deviceDao.add(device);
        } else {
            deviceDao.saveOrUpdate(device);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Device> pageQuery(String hql, Integer page, Integer size, Object... objects) {
        List<Device> list = (List<Device>) deviceDao.pageQuery(hql, page, size, objects);
        return list;
    }

    @Override
    public Integer getCount(String hql) {
        return deviceDao.count(hql);
    }

    @Override
    public void deleteDeviceById(String id) {
        deviceDao.deleteDeviceById(id);
    }

    @Override
    public void deleteDeviceByDeviceId(String deviceId) {
        deviceDao.deleteDeviceByDeviceId(deviceId);
    }


}
