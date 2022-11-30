package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("studentRepository")
public interface StudentRepository extends UserRepository {
    @Query("select u from User u join fetch u.career c where c.name = ?1")
    Iterable<User> findByCareerName(String careerName);
}
