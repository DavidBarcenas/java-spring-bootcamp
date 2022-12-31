package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.ClassRoomDAO;
import com.spring.university.backenduniversity.persistence.entity.Board;
import com.spring.university.backenduniversity.persistence.entity.ClassRoom;
import com.spring.university.backenduniversity.persistence.repository.ClassRoomRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassRoomDAOImpl extends DAOImpl<ClassRoom, ClassRoomRepository> implements ClassRoomDAO {
    public ClassRoomDAOImpl(ClassRoomRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<ClassRoom> findByBoardType(Board boardType) {
        return repository.findByBoardType(boardType);
    }

    @Override
    public Iterable<ClassRoom> findByBuildingName(String buildingName) {
        return repository.findByBuildingName(buildingName);
    }

    @Override
    public Optional<ClassRoom> findByRoomNumber(Number roomNumber) {
        return repository.findByRoomNumber(roomNumber);
    }
}
