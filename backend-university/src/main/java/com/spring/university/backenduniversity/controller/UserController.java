package com.spring.university.backenduniversity.controller;

import com.spring.university.backenduniversity.dao.UserDAO;
import com.spring.university.backenduniversity.persistence.dto.UserDTO;
import com.spring.university.backenduniversity.persistence.entity.Employee;
import com.spring.university.backenduniversity.persistence.entity.Student;
import com.spring.university.backenduniversity.persistence.entity.Teacher;
import com.spring.university.backenduniversity.persistence.entity.User;
import com.spring.university.backenduniversity.persistence.mapper.StudentMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserController extends GenericController<User, UserDAO> {
    protected final StudentMapper studentMapper;
    public UserController(UserDAO service, StudentMapper studentMapper) {
        super(service);
        this.studentMapper = studentMapper;
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

    public UserDTO createUser(User user) {
        User newUser = service.save(user);
        UserDTO dto = null;

        if(newUser instanceof Student) {
            dto = studentMapper.mapStudentDTO((Student) newUser);
        } else if (newUser instanceof Teacher) {
            // mapper teacher
        } else if (newUser instanceof Employee) {
            // mapper employee
        }

        return dto;
    }
}
