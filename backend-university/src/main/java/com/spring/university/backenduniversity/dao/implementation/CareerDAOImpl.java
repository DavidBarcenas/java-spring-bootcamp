package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.CareerDAO;
import com.spring.university.backenduniversity.persistence.entity.Career;
import com.spring.university.backenduniversity.persistence.repository.CareerRepository;
import org.springframework.stereotype.Service;

@Service
public class CareerDAOImpl extends DAOImpl<Career, CareerRepository> implements CareerDAO {

    public CareerDAOImpl(CareerRepository repository) {
        super(repository);
    }
}
