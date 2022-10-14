package com.restapi.demo.controllers;

import com.restapi.demo.models.User;
import com.restapi.demo.services.UserService;
import com.restapi.demo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    JWTUtil jwtUtil;

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

    @PostMapping("/login")
    Map<String, Object> login(@RequestBody User dto) {
        User user = userService.login(dto);

        Map<String, Object> result = new HashMap<>();
        if(user != null) {
            String token = jwtUtil.create(String.valueOf(user.getId()), user.getEmail());
            result.put("token", token);
            result.put("user", user);
        }

        return result;
    }
}
