package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.TeacherDAO;
import com.spring.university.backenduniversity.persistence.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class TeacherDAOImplTest {
    @MockBean
    TeacherRepository teacherRepository;

    @Autowired
    TeacherDAO teacherDAO;

    @Test
    void findTeachersByCareer() {
        teacherRepository.findTeachersByCareer(anyString());
        verify(teacherRepository).findTeachersByCareer(anyString());
    }
}