package com.spring.university.backenduniversity.controller;

import com.spring.university.backenduniversity.dao.CareerDAO;
import com.spring.university.backenduniversity.dao.UserDAO;
import com.spring.university.backenduniversity.exception.BadRequestException;
import com.spring.university.backenduniversity.persistence.entity.Career;
import com.spring.university.backenduniversity.persistence.entity.Student;
import com.spring.university.backenduniversity.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    /*
    @GetMapping
    public List<User> getAll() {
        List<User> students = (List<User>) studentDAO.findAll();
        if(students.isEmpty()) {
            throw new BadRequestException("No results found");
        }
        return students;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        Optional<User> student = studentDAO.findById(id);
        if(student.isEmpty()) {
            throw new BadRequestException(String.format("The student with id %d does not exist", id));
        }
        return student.get();
    }

    @PostMapping
    public User create(@RequestBody User student) {
        return studentDAO.save(student);
    }



    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        studentDAO.deleteById(id);
    }*/

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody User student) {
        User newStudent = null;
        Optional<User> prevStudent = service.findById(id);
        if(prevStudent.isEmpty()) {
            throw new BadRequestException(String.format("The student with id %d does not exist", id));
        }
        newStudent = prevStudent.get();
        newStudent.setName(student.getName());
        newStudent.setLastName(student.getLastName());
        newStudent.setAddress(student.getAddress());
        return service.save(newStudent);
    }


    @PutMapping("/{idStudent}/career/{idCareer}")
    public User assignCareer(@PathVariable Integer idStudent, @PathVariable Integer idCareer) {
        Optional<User> student = service.findById(idStudent);
        if(student.isEmpty()) {
            throw new BadRequestException(String.format("The student with id %d does not exist", idStudent));
        }

        Optional<Career> career = careerDAO.findById(idCareer);
        if(career.isEmpty()) {
            throw new BadRequestException(String.format("The career with id %d does not exist", idCareer));
        }

        User updateStudent = student.get();

        ((Student)updateStudent).setCareer(career.get());
        return service.save(updateStudent);
    }
}
