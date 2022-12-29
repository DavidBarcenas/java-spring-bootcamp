package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.BuildingDAO;
import com.spring.university.backenduniversity.persistence.entity.Building;
import com.spring.university.backenduniversity.persistence.repository.BuildingRepository;
import org.springframework.stereotype.Service;

@Service
public class BuildingDAOImpl extends DAOImpl<Building, BuildingRepository> implements BuildingDAO {
    public BuildingDAOImpl(BuildingRepository repository) {
        super(repository);
    }
}
