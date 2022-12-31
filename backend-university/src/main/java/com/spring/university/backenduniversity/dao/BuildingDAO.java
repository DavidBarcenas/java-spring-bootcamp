package com.spring.university.backenduniversity.dao;

import com.spring.university.backenduniversity.persistence.entity.Building;

public interface BuildingDAO extends DAO<Building>{
    Iterable<Building> findByLocation(String location);
    Iterable<Building> findByName(String name);
}
