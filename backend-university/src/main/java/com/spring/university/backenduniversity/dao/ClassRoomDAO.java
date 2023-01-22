package com.spring.university.backenduniversity.dao;

import com.spring.university.backenduniversity.persistence.entity.Board;
import com.spring.university.backenduniversity.persistence.entity.ClassRoom;

import java.util.Optional;

public interface ClassRoomDAO extends DAO<ClassRoom> {
    Iterable<ClassRoom> findByBoardType(Board boardType);
    Iterable<ClassRoom> findByBuildingName(String buildingName);
    Optional<ClassRoom> findByRoomNumber(Number roomNumber);
}
