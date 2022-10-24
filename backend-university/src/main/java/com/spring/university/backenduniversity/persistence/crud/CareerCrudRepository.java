package com.spring.university.backenduniversity.persistence.crud;

import com.spring.university.backenduniversity.persistence.entity.Career;
import org.springframework.data.repository.CrudRepository;

public interface CareerCrudRepository extends CrudRepository<Career, Integer> {
    
}
