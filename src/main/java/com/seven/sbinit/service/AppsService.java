package com.seven.sbinit.service;

import com.seven.sbinit.pojo.Apps;

import java.util.List;


public interface AppsService {

    void save(Apps apps);

    Apps getAppsById(String id);

    List<Apps> getAllApps();

    List<Apps> getAppsByDeviceId(String queryString, Object... params);

    Apps getAppsByHql(String queryString, Object... params);

    List<Apps> getAppsListByHql(String queryString);

    void saveOrUpdtae(Apps apps);

    List<Apps> pageQuery(final String hql, final Integer page, final Integer size, final Object... objects);

    Integer getCount(String hql);

    void deleteAppsByDeviceId(String deviceId);

    void deleteAppsById(String id);

}
