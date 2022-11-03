package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.CareerDAO;
import com.spring.university.backenduniversity.persistence.entity.Career;
import com.spring.university.backenduniversity.persistence.repository.CareerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CareerDAOImpl extends DAOImpl<Career, CareerRepository> implements CareerDAO {

    public CareerDAOImpl(CareerRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Career> findByNameContains(String careerName) {
        return repository.findByNameContains(careerName);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Career> findByNameContainsIgnoreCase(String careerName) {
        return repository.findByNameContainsIgnoreCase(careerName);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Career> findByTotalYearsAfter(Integer years) {
        return repository.findByTotalYearsAfter(years);
    }
}
