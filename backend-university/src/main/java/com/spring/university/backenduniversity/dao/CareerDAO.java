package com.spring.university.backenduniversity.dao;

import com.spring.university.backenduniversity.persistence.entity.Career;

import java.util.Optional;

public interface CareerDAO {
    Optional<Career> findById(Integer id);
    Career save(Career career);
    Iterable<Career> findAll();
    void deleteById(Integer id);
}
