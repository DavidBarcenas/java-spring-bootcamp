package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.Building;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Integer> {
    @Query("select b from Building b where b.address.location = ?1")
    Iterable<Building> findByLocation(String location);

    @Query("select b from Building b where b.name like %?1%")
    Iterable<Building> findByName(String name);
}
