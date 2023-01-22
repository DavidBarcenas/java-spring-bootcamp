package com.spring.university.backenduniversity.dao;

import com.spring.university.backenduniversity.persistence.entity.User;

import java.util.Optional;

public interface UserDAO extends DAO<User>{
    Optional<User> findByNameAndLastName(String name, String lastname);
    Optional<User> findByIdDocument(String idDocument);
    Iterable<User> findByLastName(String lastname);
}
