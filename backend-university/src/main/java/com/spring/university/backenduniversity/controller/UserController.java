package com.spring.university.backenduniversity.controller;

import com.spring.university.backenduniversity.dao.UserDAO;
import com.spring.university.backenduniversity.persistence.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserController extends GenericController<User, UserDAO> {
    public UserController(UserDAO service) {
        super(service);
    }

    @GetMapping("/name")
    public ResponseEntity<?> searchByNameAndLastname(@RequestParam String name, @RequestParam String lastname) {
        Map<String, Object> message = new HashMap<>();
        Optional<User> user = service.findByNameAndLastName(name, lastname);
        if(user.isEmpty()) {
            message.put("success", Boolean.FALSE);
            message.put("message", String.format("The user with name %s and lastname %s does not exist", name, lastname));
            return ResponseEntity.badRequest().body(message);
        }

        message.put("success", Boolean.TRUE);
        message.put("data", user.get());
        return ResponseEntity.ok(message);
    }
}
