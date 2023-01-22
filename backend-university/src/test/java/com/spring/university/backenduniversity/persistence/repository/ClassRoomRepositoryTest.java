package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.Board;
import com.spring.university.backenduniversity.persistence.entity.Building;
import com.spring.university.backenduniversity.persistence.entity.ClassRoom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.spring.university.backenduniversity.data.DummyData.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ClassRoomRepositoryTest {
    @Autowired
    ClassRoomRepository classRoomRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @BeforeEach
    void setup() {
        classRoomRepository.saveAll(Arrays.asList(classRoom1(), classRoom2(), classRoom3()));
    }

    @AfterEach
    void tearDown() {
        classRoomRepository.deleteAll();
    }

    @Test
    void findByBoardType() {
        List<ClassRoom> rooms = (List<ClassRoom>) classRoomRepository.findByBoardType(Board.BLACKBOARD);
        assertThat(rooms.size() == 2).isTrue();
    }

    @Test
    void findByBuildingName() {
        Iterable<ClassRoom> rooms = classRoomRepository.findAll();
        Building building = buildingRepository.save(building1());
        rooms.forEach(room -> room.setBuilding(building));
        classRoomRepository.saveAll(rooms);

        List<ClassRoom> roomsWithBuilding = (List<ClassRoom>) classRoomRepository.findByBuildingName(building1().getName());
        assertThat(roomsWithBuilding.size() == 3).isTrue();
    }

    @Test
    void findByRoomNumber() {
        Optional<ClassRoom> room = classRoomRepository.findByRoomNumber(2);
        ClassRoom roomWithId = classRoom2();
        roomWithId.setId(room.get().getId());
        assertThat(room.get()).isEqualTo(roomWithId);
    }
}