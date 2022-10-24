package com.spring.university.backenduniversity.persistence;

import com.spring.university.backenduniversity.domain.repository.CareerDomainRepository;
import com.spring.university.backenduniversity.persistence.crud.CareerCrudRepository;
import com.spring.university.backenduniversity.persistence.entity.Career;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class CareerRepository implements CareerDomainRepository {
    @Autowired
    private CareerCrudRepository careerCrudRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Career> findById(Integer id) {
        return careerCrudRepository.findById(id);
    }

    @Override
    @Transactional
    public Career save(Career career) {
        return careerCrudRepository.save(career);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Career> findAll() {
        return careerCrudRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        careerCrudRepository.deleteById(id);
    }
}
