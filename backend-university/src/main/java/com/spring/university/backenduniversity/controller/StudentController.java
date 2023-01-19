package com.spring.university.backenduniversity.controller;

import com.spring.university.backenduniversity.dao.CareerDAO;
import com.spring.university.backenduniversity.dao.UserDAO;
import com.spring.university.backenduniversity.persistence.entity.Career;
import com.spring.university.backenduniversity.persistence.entity.Student;
import com.spring.university.backenduniversity.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController extends UserController {
    private final CareerDAO careerDAO;

    @Autowired
    public StudentController(@Qualifier("studentDAOImpl") UserDAO studentDAO, CareerDAO careerDAO) {
        super(studentDAO);
        entityName = "Student";
        this.careerDAO = careerDAO;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody User student) {
        Map<String, Object> message = new HashMap<>();
        User newStudent = null;
        Optional<User> prevStudent = service.findById(id);

        if(prevStudent.isEmpty()) {
            message.put("success", Boolean.FALSE);
            message.put("message", String.format("The student with id %d does not exist", id));
            return ResponseEntity.badRequest().body(message);
        }
        newStudent = prevStudent.get();
        newStudent.setName(student.getName());
        newStudent.setLastName(student.getLastName());
        newStudent.setAddress(student.getAddress());

        message.put("success", Boolean.TRUE);
        message.put("data", service.save(newStudent));
        return ResponseEntity.ok(message);
    }


    @PutMapping("/{idStudent}/career/{idCareer}")
    public ResponseEntity<?> assignCareer(@PathVariable Integer idStudent, @PathVariable Integer idCareer) {
        Map<String, Object> message = new HashMap<>();
        Optional<User> student = service.findById(idStudent);
        if(student.isEmpty()) {
            message.put("success", Boolean.FALSE);
            message.put("message", String.format("The student with id %d does not exist", idStudent));
            return ResponseEntity.badRequest().body(message);
        }

        Optional<Career> career = careerDAO.findById(idCareer);
        if(career.isEmpty()) {
            message.put("success", Boolean.FALSE);
            message.put("message", String.format("The career with id %d does not exist", idCareer));
            return ResponseEntity.badRequest().body(message);
        }

        User updateStudent = student.get();
        ((Student)updateStudent).setCareer(career.get());

        message.put("success", Boolean.TRUE);
        message.put("data", service.save(updateStudent));
        return ResponseEntity.ok(message);
    }
}
