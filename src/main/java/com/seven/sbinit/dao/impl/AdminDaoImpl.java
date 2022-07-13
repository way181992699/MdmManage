package com.seven.sbinit.dao.impl;

import com.seven.sbinit.pojo.Admin;
import com.seven.sbinit.dao.AdminDao;
import com.seven.sbinit.dao.common.BaseDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminDaoImpl extends BaseDao implements AdminDao {

    @Override
    public void add(Admin admin) {
        super.add(admin);
    }

    @Override
    public Admin getAdminById(String id) {
        Object object = super.getById(Admin.class, id);
        return (Admin) object;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Admin> getAll() {
        List<Admin> list = (List<Admin>) super.getAll(Admin.class);
        return list;
    }

    public Admin getByHql(String queryString, Object... params) {
        return (Admin) super.getByHql(queryString, params);
    }

    @Override
    public void saveOrUpdate(Admin admin) {
        super.saveOrUpdate(admin);
    }


}
