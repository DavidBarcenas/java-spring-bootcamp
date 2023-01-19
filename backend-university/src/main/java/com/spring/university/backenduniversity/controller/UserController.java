package com.spring.university.backenduniversity.controller;

import com.spring.university.backenduniversity.dao.UserDAO;
import com.spring.university.backenduniversity.exception.BadRequestException;
import com.spring.university.backenduniversity.persistence.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class UserController extends GenericController<User, UserDAO> {
    public UserController(UserDAO service) {
        super(service);
    }

    @GetMapping("/name")
    public User searchByNameAndLastname(@RequestParam String name, @RequestParam String lastname) {
        Optional<User> user = service.findByNameAndLastName(name, lastname);
        if(user.isEmpty()) {
            throw new BadRequestException(String.format("The user with name %s and lastname %s does not exist", name, lastname));
        }
        return user.get();
    }
}
