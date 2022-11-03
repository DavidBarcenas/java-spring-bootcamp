package com.spring.university.backenduniversity.dao;

import com.spring.university.backenduniversity.persistence.entity.Career;

public interface CareerDAO extends DAO<Career> {
    Iterable<Career> findByNameContains(String careerName);
    Iterable<Career> findByNameContainsIgnoreCase(String careerName);
    Iterable<Career> findByTotalYearsAfter(Integer years);
}
