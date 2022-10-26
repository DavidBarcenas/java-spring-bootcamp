package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserRepository extends CrudRepository<User, Integer> {
}
