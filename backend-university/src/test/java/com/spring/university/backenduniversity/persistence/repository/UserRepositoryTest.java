package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.Employee;
import com.spring.university.backenduniversity.persistence.entity.Teacher;
import com.spring.university.backenduniversity.persistence.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.spring.university.backenduniversity.data.DummyData.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    @Qualifier("studentRepository")
    UserRepository studentRepository;

    @Autowired
    @Qualifier("teacherRepository")
    UserRepository teacherRepository;

    @Autowired
    @Qualifier("employeeRepository")
    UserRepository employeeRepository;

    @Test
    void findByNameAndLastName() {
        User newEmployee = employeeRepository.save(employee1());
        Optional<User> employee = employeeRepository.findByNameAndLastName(employee1().getName(), employee1().getLastName());

        assertThat(employee.get()).isInstanceOf(Employee.class);
        assertThat(employee.get()).isEqualTo(newEmployee);
    }

    @Test
    void findByIdDocument() {
        User newTeacher = teacherRepository.save(teacher1());
        Optional<User> teacher = teacherRepository.findByIdDocument(teacher1().getIdDocument());

        assertThat(teacher.get()).isInstanceOf(Teacher.class);
        assertThat(teacher.get()).isEqualTo(newTeacher);
        assertThat(teacher.get().getIdDocument()).isEqualTo(newTeacher.getIdDocument());
    }

    @Test
    void findByLastName() {
        studentRepository.saveAll(Arrays.asList(student1(), student2(), student3()));

        String lastname = "Conde";
        List<User> students = (List<User>) this.studentRepository.findByLastName(lastname);

        assertThat(students.size() == 2).isTrue();
    }
}