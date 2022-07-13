package com.seven.sbinit.service.impl;

import com.seven.sbinit.pojo.Command;
import com.seven.sbinit.dao.CommandDao;
import com.seven.sbinit.dao.DeviceDao;
import com.seven.sbinit.service.CommandService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Component
public class CommandServiceImpl implements CommandService {

    private CommandDao commandDao;
    private DeviceDao deviceDao;

    @Override
    public void save(Command command) {
        commandDao.add(command);
    }

    @Override
    public Command getCommandById(String id) {
        return commandDao.getCommandById(id);
    }

    @Override
    public void deleteCommandById(String id) {
        commandDao.deleteCommandById(id);
    }

    @Override
    public List<Command> getAllCommand() {
        return commandDao.getAll();
    }

    public CommandDao getCommandDao() {
        return commandDao;
    }

    @Resource
    public void setCommandDao(CommandDao commandDao) {
        this.commandDao = commandDao;
    }

    public DeviceDao getDeviceDao() {
        return deviceDao;
    }

    @Resource
    public void setDeviceDao(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    @Override
    public Command getCommandByHql(String queryString, Object... params) {
        return commandDao.getByHql(queryString, params);
    }

    @Override
    public void saveOrUpdate(Command command) {
        if (null == command.getId() || "".equals(command.getId())) {
            command.setId(UUID.randomUUID().toString());
            commandDao.add(command);
        } else {
            commandDao.saveOrUpdate(command);
        }
    }

    @Override
    public void deleteCommandByDeviceId(String deviceId) {
        commandDao.deleteCommandByDeviceId(deviceId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Command> pageQuery(String hql, Integer page, Integer size, Object... objects) {
        List<Command> list = (List<Command>) commandDao.pageQuery(hql, page, size, objects);
        return list;
    }

    @Override
    public Integer getCount(String hql) {
        return commandDao.count(hql);
    }

    @Override
    public List<Command> getAllCommandByHql(String queryString, Object... params) {
        return commandDao.getAllByHql(queryString, params);
    }

}
