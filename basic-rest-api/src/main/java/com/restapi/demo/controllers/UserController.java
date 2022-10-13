package com.restapi.demo.controllers;

import com.restapi.demo.models.User;
import com.restapi.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    User getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @PostMapping()
    User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable long id) {
        userService.delete(id);
    }
}
