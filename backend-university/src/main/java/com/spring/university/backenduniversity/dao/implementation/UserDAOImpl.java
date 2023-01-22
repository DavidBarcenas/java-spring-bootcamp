package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.UserDAO;
import com.spring.university.backenduniversity.persistence.entity.User;
import com.spring.university.backenduniversity.persistence.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class UserDAOImpl extends DAOImpl<User, UserRepository> implements UserDAO {
    public UserDAOImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByNameAndLastName(String name, String lastname) {
        return repository.findByNameAndLastName(name, lastname);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByIdDocument(String idDocument) {
        return repository.findByIdDocument(idDocument);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<User> findByLastName(String lastname) {
        return repository.findByLastName(lastname);
    }
}
