package com.spring.university.backenduniversity.persistence.repository;

import com.spring.university.backenduniversity.persistence.entity.Board;
import com.spring.university.backenduniversity.persistence.entity.ClassRoom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRoomRepository extends CrudRepository<ClassRoom, Integer> {
    @Query("select c from ClassRoom c where c.board = ?1")
    Iterable<ClassRoom> findByBoardType(Board boardType);

    @Query("select c from ClassRoom c join fetch c.building b where b.name = ?1")
    Iterable<ClassRoom> findByBuildingName(String buildingName);

    @Query("select c from ClassRoom c where c.roomNumber = ?1")
    Optional<ClassRoom> findByRoomNumber(Number roomNumber);
}
