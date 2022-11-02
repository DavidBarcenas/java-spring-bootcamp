package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByNameAndLastname(String name, String lastname);

    Optional<User> findByIdDocument(String idDocument);

    Iterable<User> findByLastname(String lastname);
}
