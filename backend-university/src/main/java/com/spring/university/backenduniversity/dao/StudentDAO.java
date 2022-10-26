package com.spring.university.backenduniversity.dao;

import com.spring.university.backenduniversity.persistence.entity.Person;

import java.util.Optional;

public interface StudentDAO {
    Optional<Person> findById(Integer id);
    Person save(Person person);
    Iterable<Person> findAll();
    void deleteById(Integer id);
}
