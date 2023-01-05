package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.StudentDAO;
import com.spring.university.backenduniversity.persistence.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class StudentDAOImplTest {
    @MockBean
    StudentRepository studentRepository;

    @Autowired
    StudentDAO studentDAO;

    @Test
    void findByCareerName() {
        studentDAO.findByCareerName(anyString());
        verify(studentRepository).findByCareerName(anyString());
    }
}