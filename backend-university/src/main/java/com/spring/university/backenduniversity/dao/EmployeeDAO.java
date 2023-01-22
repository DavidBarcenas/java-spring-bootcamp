package com.spring.university.backenduniversity.dao;

import com.spring.university.backenduniversity.persistence.entity.EmployeeType;
import com.spring.university.backenduniversity.persistence.entity.User;

public interface EmployeeDAO extends UserDAO{
    Iterable<User> findEmployeeByType(EmployeeType employeeType);
}
