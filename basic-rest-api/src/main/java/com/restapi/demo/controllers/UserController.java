package com.restapi.demo.controllers;

import com.restapi.demo.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping()
    List<User> getAll() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setName("David");
        user.setLastname("Barcenas");
        userList.add(user);

        return userList;
    }

    @GetMapping("/{id}")
    User getById(@PathVariable long id) {
        User user = new User();
        user.setName("David");
        user.setLastname("Barcenas");

        return user;
    }

    @PostMapping()
    User create(@RequestBody User user) {
        return user;
    }

    @PutMapping("/{id}")
    User update(@RequestBody User user) {
        return user;
    }

    @DeleteMapping("/{id}")
    Boolean delete(@PathVariable long id) {
        return true;
    }
}
