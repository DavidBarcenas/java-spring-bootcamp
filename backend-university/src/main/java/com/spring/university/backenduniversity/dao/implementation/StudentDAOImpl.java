package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.StudentDAO;
import com.spring.university.backenduniversity.persistence.entity.User;
import com.spring.university.backenduniversity.persistence.repository.StudentRepository;
import com.spring.university.backenduniversity.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class StudentDAOImpl extends UserDAOImpl implements StudentDAO {
    public StudentDAOImpl(@Qualifier("studentRepository") UserRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<User> findByName(String name) {
        return ((StudentRepository)repository).findByName(name);
    }
}
