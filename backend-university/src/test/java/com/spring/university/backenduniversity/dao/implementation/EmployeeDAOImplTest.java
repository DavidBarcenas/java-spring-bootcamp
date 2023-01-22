package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.EmployeeDAO;
import com.spring.university.backenduniversity.persistence.entity.EmployeeType;
import com.spring.university.backenduniversity.persistence.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class EmployeeDAOImplTest {
    @MockBean
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeDAO employeeDAO;

    @Test
    void findEmployeeByType() {
        employeeDAO.findEmployeeByType(EmployeeType.ADMINISTRATIVE);
        verify(employeeRepository).findEmployeeByType(EmployeeType.ADMINISTRATIVE);
    }
}