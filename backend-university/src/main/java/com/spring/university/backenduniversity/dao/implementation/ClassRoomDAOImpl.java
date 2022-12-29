package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.ClassRoomDAO;
import com.spring.university.backenduniversity.persistence.entity.ClassRoom;
import com.spring.university.backenduniversity.persistence.repository.ClassRoomRepository;
import org.springframework.stereotype.Service;

@Service
public class ClassRoomDAOImpl extends DAOImpl<ClassRoom, ClassRoomRepository> implements ClassRoomDAO {
    public ClassRoomDAOImpl(ClassRoomRepository repository) {
        super(repository);
    }
}
