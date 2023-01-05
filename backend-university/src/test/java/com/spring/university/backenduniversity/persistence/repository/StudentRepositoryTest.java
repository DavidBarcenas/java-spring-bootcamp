package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.Career;
import com.spring.university.backenduniversity.persistence.entity.Student;
import com.spring.university.backenduniversity.persistence.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static com.spring.university.backenduniversity.data.DummyData.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    @Qualifier("studentRepository")
    UserRepository studentRepository;

    @Autowired
    CareerRepository careerRepository;

    @Test
    void findByCareerName() {
        Iterable<User> students = studentRepository.saveAll(Arrays.asList(student1(), student2(), student3()));
        Career career =  careerRepository.save(career1());

        students.forEach(student -> ((Student)student).setCareer(career));
        studentRepository.saveAll(students);

        String careerName = "Systems Engineering";
        List<User> studentList = (List<User>) ((StudentRepository) studentRepository).findByCareerName(careerName);

        assertThat(studentList.size() == 3).isTrue();
    }

    @Test
    void shouldNotFindStudents() {
        Iterable<User> students = studentRepository.saveAll(Arrays.asList(student1(), student2(), student3()));
        Career career =  careerRepository.save(career1());

        students.forEach(student -> ((Student)student).setCareer(career));
        studentRepository.saveAll(students);

        String careerName = "Travel";
        List<User> studentList = (List<User>) ((StudentRepository) studentRepository).findByCareerName(careerName);

        assertThat(studentList.isEmpty()).isTrue();
    }
}