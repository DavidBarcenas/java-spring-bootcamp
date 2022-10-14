package com.restapi.demo.controllers;

import com.restapi.demo.models.Role;
import com.restapi.demo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping()
    List<Role> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    Role getById(@PathVariable long id) {
        return roleService.getById(id);
    }

    @PostMapping()
    Role create(@RequestBody Role role) {
        return roleService.create(role);
    }

    @PutMapping("/{id}")
    Role update(@RequestBody Role role) {
        return roleService.update(role);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable long id) {
        roleService.delete(id);
    }
}
