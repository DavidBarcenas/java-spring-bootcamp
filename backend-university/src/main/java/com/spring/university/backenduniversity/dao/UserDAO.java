package com.spring.university.backenduniversity.dao;

import com.spring.university.backenduniversity.persistence.entity.User;

import java.util.Optional;

public interface UserDAO {
    Optional<User> findById(Integer id);
    User save(User user);
    Iterable<User> findAll();
    void deleteById(Integer id);
}
