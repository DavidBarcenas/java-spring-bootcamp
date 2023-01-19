package com.spring.university.backenduniversity.controller;

import com.spring.university.backenduniversity.dao.UserDAO;
import com.spring.university.backenduniversity.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final UserDAO studentDAO;

    @Autowired
    public StudentController(@Qualifier("studentDAOImpl") UserDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @PostMapping
    public User create(@RequestBody User student) {
        return studentDAO.save(student);
    }
}
