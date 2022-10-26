package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.Career;
import org.springframework.data.repository.CrudRepository;

public interface CareerRepository extends CrudRepository<Career, Integer> {
}
