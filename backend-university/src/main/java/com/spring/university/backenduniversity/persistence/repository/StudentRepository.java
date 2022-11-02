package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.User;

public interface StudentRepository extends UserRepository {
    Iterable<User> findByCareer(String careerName);
}
