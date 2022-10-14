package com.restapi.demo.services;

import com.restapi.demo.dao.PermissionDao;
import com.restapi.demo.models.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    PermissionDao permissionDao;

    public List<Permission> getAll() {
        return permissionDao.getAll();
    }

    public Permission getById(long id) {
        return permissionDao.getById(id);
    }

    public Permission create(Permission permission) {
        return permissionDao.create(permission);
    }

    public Permission update(Permission permission) {
        return permissionDao.update(permission);
    }

    public void delete(long id) {
        permissionDao.delete(id);
    }
}
