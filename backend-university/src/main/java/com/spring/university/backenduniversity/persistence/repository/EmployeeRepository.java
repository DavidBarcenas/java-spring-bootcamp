package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.EmployeeType;
import com.spring.university.backenduniversity.persistence.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("employeeRepository")
public interface EmployeeRepository extends UserRepository {
    @Query("select u from User u join fetch u.employeeType e where e.employee_type = ?1")
    Iterable<User> findEmployeeByType(EmployeeType employeeType);
}
