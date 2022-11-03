package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.User;
import org.springframework.stereotype.Repository;

@Repository("studentRepository")
public interface StudentRepository extends UserRepository {
    Iterable<User> findByName(String name);
}
