package com.seven.sbinit.service.impl;

import com.seven.sbinit.pojo.Admin;
import com.seven.sbinit.dao.AdminDao;
import com.seven.sbinit.service.AdminService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao;

    @Override
    public void save(Admin admin) {
        adminDao.add(admin);
    }

    @Override
    public Admin getAdminById(String id) {
        return adminDao.getAdminById(id);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminDao.getAll();
    }

    public AdminDao getAdminDao() {
        return adminDao;
    }

    @Resource
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Admin getAdminByHql(String queryString, Object... params) {
        return adminDao.getByHql(queryString, params);
    }

    @Override
    public void saveOrUpdtae(Admin admin) {
        if (null == admin.getId() || "".equals(admin.getId())) {
            admin.setId(UUID.randomUUID().toString());
            adminDao.add(admin);
        } else {
            adminDao.saveOrUpdate(admin);
        }
    }


}
