package com.restapi.demo.controllers;

import com.restapi.demo.models.Permission;
import com.restapi.demo.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @GetMapping()
    List<Permission> getAll() {
        return permissionService.getAll();
    }

    @GetMapping("/{id}")
    Permission getById(@PathVariable long id) {
        return permissionService.getById(id);
    }

    @PostMapping()
    Permission create(@RequestBody Permission permission) {
        return permissionService.create(permission);
    }

    @PutMapping("/{id}")
    Permission update(@RequestBody Permission permission) {
        return permissionService.update(permission);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable long id) {
        permissionService.delete(id);
    }
}
