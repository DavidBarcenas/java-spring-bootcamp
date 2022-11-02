package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("select u from User u where u.name = ?1 and u.lastname = ?2")
    Optional<User> findByNameAndLastname(String name, String lastname);

    @Query("select u from User u where u.id_document = ?1")
    Optional<User> findByIdDocument(String idDocument);

    @Query("select u from User u where u.lastname like %?1%")
    Iterable<User> findByLastname(String lastname);
}
