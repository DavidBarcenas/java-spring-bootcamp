package com.restapi.demo.dao;

import com.restapi.demo.models.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAll();
    Role getById(long id);
    Role create(Role role);
    Role update(Role role);
    void delete(long id);
}
