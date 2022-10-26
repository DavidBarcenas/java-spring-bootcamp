package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.StudentDAO;
import com.spring.university.backenduniversity.persistence.entity.Person;
import com.spring.university.backenduniversity.persistence.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentDAOImpl implements StudentDAO {
    @Qualifier("studentRepository")
    private final PersonRepository repository;

    public StudentDAOImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Person> findById(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Person> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
