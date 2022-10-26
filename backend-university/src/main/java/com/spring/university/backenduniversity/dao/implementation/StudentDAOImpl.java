package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.StudentDAO;
import com.spring.university.backenduniversity.persistence.entity.User;
import com.spring.university.backenduniversity.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentDAOImpl implements StudentDAO {
    @Qualifier("studentRepository")
    private final UserRepository repository;

    public StudentDAOImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<User> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
