package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.EmployeeType;
import com.spring.university.backenduniversity.persistence.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static com.spring.university.backenduniversity.data.DummyData.employee1;
import static com.spring.university.backenduniversity.data.DummyData.employee2;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void findEmployeeByType() {
        employeeRepository.save(employee1());
        employeeRepository.save(employee2());

        List<User> maintenanceUsers = (List<User>) employeeRepository.findEmployeeByType(EmployeeType.MAINTENANCE);
        assertThat(maintenanceUsers.size() == 1).isTrue();

        List<User> adminUsers = (List<User>) employeeRepository.findEmployeeByType(EmployeeType.ADMINISTRATIVE);
        assertThat(adminUsers.size() == 1).isTrue();
    }
}