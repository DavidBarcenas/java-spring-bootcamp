package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.CareerDAO;
import com.spring.university.backenduniversity.persistence.entity.Career;
import com.spring.university.backenduniversity.persistence.repository.CareerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.spring.university.backenduniversity.data.DummyData.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class CareerDAOImplTest {
    CareerDAO careerDAO;
    CareerRepository careerRepository;

    @BeforeEach
    void setUp() {
        careerRepository = mock(CareerRepository.class);
        careerDAO = new CareerDAOImpl(careerRepository);
    }

    @Test
    void findByNameContains() {
        String careerName = "Engineering";
        Career career1 = career1();
        Career career2 = career2();

        career1.setId(1);
        career2.setId(2);

        when(careerRepository.findByNameContains(careerName))
                .thenReturn(Arrays.asList(career1, career2));

        List<Career> careers = (List<Career>) careerDAO.findByNameContains(careerName);

        assertThat(careers.get(0)).isEqualTo(career1);
        assertThat(careers.get(1)).isEqualTo(career2);

        verify(careerRepository).findByNameContains(careerName);
    }

    @Test
    void findByNameContainsIgnoreCase() {
        String careerName = "systems";
        Career career1 = career1();
        Career career2 = career2();

        career1.setId(1);
        career2.setId(2);

        when(careerRepository.findByNameContainsIgnoreCase(careerName))
                .thenReturn(Arrays.asList(career1, career2));

        List<Career> careers = (List<Career>) careerDAO.findByNameContainsIgnoreCase(careerName);

        assertThat(careers.get(0)).isEqualTo(career1);
        assertThat(careers.get(1)).isEqualTo(career2);

        verify(careerRepository).findByNameContainsIgnoreCase(careerName);
    }

    @Test
    void findByTotalYearsAfter() {
        Integer years = 3;
        Career career1 = career1();
        Career career2 = career2();

        career1.setId(1);
        career2.setId(2);

        when(careerRepository.findByTotalYearsAfter(years))
                .thenReturn(Arrays.asList(career1, career2));

        List<Career> careers = (List<Career>) careerDAO.findByTotalYearsAfter(years);

        assertThat(careers.size() == 2).isTrue();
        assertThat(careers.get(0)).isEqualTo(career1);

        verify(careerRepository).findByTotalYearsAfter(years);
    }
}