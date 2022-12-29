package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.Career;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CareerRepository extends CrudRepository<Career, Integer> {
    Iterable<Career> findByNameContains(String careerName);
    Iterable<Career> findByNameContainsIgnoreCase(String careerName);
    Iterable<Career> findByTotalYearsAfter(Integer years);

    @Query("select c from Career c join fetch c.teachers t where t.name = ?1 and t.lastName = ?2")
    Iterable<Career> findCareersByTeacherNameAndLastname(String name, String lastname);
}
