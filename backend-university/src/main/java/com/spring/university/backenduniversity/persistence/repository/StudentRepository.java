package com.spring.university.backenduniversity.persistence.repository;


import com.spring.university.backenduniversity.persistence.entity.User;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends UserRepository {
    @Query("select u from User u where u.career = ?1")
    Iterable<User> findByCareer(String careerName);
}
