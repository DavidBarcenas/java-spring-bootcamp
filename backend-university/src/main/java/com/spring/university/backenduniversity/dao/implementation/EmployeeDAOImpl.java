package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.EmployeeDAO;
import com.spring.university.backenduniversity.persistence.entity.EmployeeType;
import com.spring.university.backenduniversity.persistence.entity.User;
import com.spring.university.backenduniversity.persistence.repository.EmployeeRepository;
import com.spring.university.backenduniversity.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDAOImpl extends UserDAOImpl implements EmployeeDAO {
    public EmployeeDAOImpl(@Qualifier("employeeRepository") UserRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<User> findEmployeeByType(EmployeeType employeeType) {
        return ((EmployeeRepository)repository).findEmployeeByType(employeeType);
    }
}
