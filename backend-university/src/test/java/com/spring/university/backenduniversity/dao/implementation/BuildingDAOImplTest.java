package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.BuildingDAO;
import com.spring.university.backenduniversity.persistence.repository.BuildingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class BuildingDAOImplTest {
    @MockBean
    BuildingRepository buildingRepository;

    @Autowired
    BuildingDAO buildingDAO;

    @Test
    void findByLocation() {
        buildingDAO.findByLocation(anyString());
        verify(buildingRepository).findByLocation(anyString());
    }

    @Test
    void findByName() {
        buildingDAO.findByName(anyString());
        verify(buildingRepository).findByName(anyString());
    }
}