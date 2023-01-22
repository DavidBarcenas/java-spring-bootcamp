package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.data.DummyData;
import com.spring.university.backenduniversity.persistence.entity.Career;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class CareerRepositoryTest {
    @Autowired
    CareerRepository careerRepository;

    @BeforeEach
    void setup() {
        careerRepository.save(DummyData.career1());
        careerRepository.save(DummyData.career2());
        careerRepository.save(DummyData.career3());
    }

    @AfterEach
    void tearDown() {
        careerRepository.deleteAll();
    }

    @Test
    void findByNameContains() {
        List<Career> careers = (List<Career>) careerRepository.findByNameContains("Systems");
        assertThat(careers.size() == 1).isTrue();
    }

    @Test
    void findByNameContainsIgnoreCase() {
        Iterable<Career> careers = careerRepository.findByNameContainsIgnoreCase("travel");
        assertThat(((List<Career>)careers).size() == 1).isTrue();
    }

    @Test
    void findByTotalYearsAfter() {
        Iterable<Career> careers = careerRepository.findByTotalYearsAfter(3);
        assertThat(((List<Career>)careers).size() == 2).isTrue();
    }
}