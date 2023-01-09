package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.ClassRoomDAO;
import com.spring.university.backenduniversity.persistence.entity.Board;
import com.spring.university.backenduniversity.persistence.repository.ClassRoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ClassRoomDAOImplTest {
    @MockBean
    ClassRoomRepository classRoomRepository;

    @Autowired
    ClassRoomDAO classRoomDAO;

    @Test
    void findByBoardType() {
        classRoomDAO.findByBoardType(Board.WHITEBOARD);
        verify(classRoomRepository).findByBoardType(Board.WHITEBOARD);
    }

    @Test
    void findByBuildingName() {
        classRoomDAO.findByBuildingName(anyString());
        verify(classRoomRepository).findByBuildingName(anyString());
    }

    @Test
    void findByRoomNumber() {
        classRoomDAO.findByRoomNumber(1);
        verify(classRoomRepository).findByRoomNumber(1);
    }
}