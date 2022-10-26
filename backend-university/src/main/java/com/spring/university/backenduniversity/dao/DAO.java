package com.spring.university.backenduniversity.dao;

import java.util.Optional;

public interface DAO<T> {
    Optional<T> findById(Integer id);
    T save(T entity);
    Iterable<T> findAll();
    void deleteById(Integer id);
}
