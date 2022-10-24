package com.spring.university.backenduniversity.domain.repository;

import com.spring.university.backenduniversity.persistence.entity.Career;

import java.util.Optional;

public interface CareerDomainRepository {
    Optional<Career> findById(Integer id);
    Career save(Career career);
    Iterable<Career> findAll();
    void deleteById(Integer id);
}
