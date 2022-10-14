package com.restapi.demo.services;

import com.restapi.demo.dao.RoleDao;
import com.restapi.demo.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;

    public List<Role> getAll() {
        return roleDao.getAll();
    }

    public Role getById(long id) {
        return roleDao.getById(id);
    }

    public Role create(Role role) {
        return roleDao.create(role);
    }

    public Role update(Role role) {
        return roleDao.update(role);
    }

    public void delete(long id) {
        roleDao.delete(id);
    }
}
