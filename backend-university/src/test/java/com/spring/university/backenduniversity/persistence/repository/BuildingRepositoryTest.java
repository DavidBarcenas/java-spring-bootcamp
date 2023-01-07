package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.Building;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static com.spring.university.backenduniversity.data.DummyData.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class BuildingRepositoryTest {
    @Autowired
    BuildingRepository buildingRepository;

    @BeforeEach
    void setup() {
        buildingRepository.saveAll(Arrays.asList(building1(), building2(), building3()));
    }

    @Test
    void findByLocation() {
        List<Building> buildings = (List<Building>) buildingRepository.findByLocation("Mexico");
        assertThat(buildings.size() == 2).isTrue();
    }

    @Test
    void findByName() {
        List<Building> buildings = (List<Building>) buildingRepository.findByName("Reforma");
        assertThat(buildings.size() == 1).isTrue();
    }
}