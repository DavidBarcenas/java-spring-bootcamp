package com.restapi.demo.dao;

import com.restapi.demo.models.Permission;

import java.util.List;

public interface PermissionDao {
    List<Permission> getAll();
    Permission getById(long id);
    Permission create(Permission permission);
    Permission update(Permission permission);
    void delete(long id);
}
