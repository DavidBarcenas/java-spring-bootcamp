package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.Career;
import com.spring.university.backenduniversity.persistence.entity.Teacher;
import com.spring.university.backenduniversity.persistence.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static com.spring.university.backenduniversity.data.DummyData.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class TeacherRepositoryTest {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CareerRepository careerRepository;

    @Test
    void findTeachersByCareer() {
        User teacher = teacherRepository.save(teacher1());
        List<Career> careers = (List<Career>) careerRepository.saveAll(Arrays.asList(career1(), career2(), career3()));

        ((Teacher) teacher).setCareers(new HashSet<Career>(careers));

        List<User> teachers = (List<User>) this.teacherRepository.findTeachersByCareer("Systems Engineering");
        assertThat(teachers.size() == 1).isTrue();
    }
}