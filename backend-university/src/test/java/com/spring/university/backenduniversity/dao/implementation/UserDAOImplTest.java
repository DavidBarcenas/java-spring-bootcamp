package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.UserDAO;
import com.spring.university.backenduniversity.persistence.repository.CareerRepository;
import com.spring.university.backenduniversity.persistence.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserDAOImplTest {
    UserDAO userDAO;

    @Mock
    StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        userDAO = new UserDAOImpl(studentRepository);
    }

    @Test
    void findByNameAndLastName() {
        userDAO.findByNameAndLastName(anyString(), anyString());
        verify(studentRepository).findByNameAndLastName(anyString(), anyString());
    }

    @Test
    void findByIdDocument() {
        userDAO.findByIdDocument(anyString());
        verify(studentRepository).findByIdDocument(anyString());
    }

    @Test
    void findByLastName() {
        userDAO.findByLastName(anyString());
        verify(studentRepository).findByLastName(anyString());
    }
}