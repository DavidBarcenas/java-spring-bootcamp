package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.CareerDAO;
import com.spring.university.backenduniversity.persistence.entity.Career;
import com.spring.university.backenduniversity.persistence.repository.CareerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CareerDAOImpl implements CareerDAO {
    private final CareerRepository repository;

    public CareerDAOImpl(CareerRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Career> findById(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Career save(Career career) {
        return repository.save(career);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Career> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
