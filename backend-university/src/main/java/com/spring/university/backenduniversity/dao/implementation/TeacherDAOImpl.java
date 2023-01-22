package com.spring.university.backenduniversity.dao.implementation;

import com.spring.university.backenduniversity.dao.TeacherDAO;
import com.spring.university.backenduniversity.persistence.entity.User;
import com.spring.university.backenduniversity.persistence.repository.TeacherRepository;
import com.spring.university.backenduniversity.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TeacherDAOImpl extends UserDAOImpl implements TeacherDAO {
    public TeacherDAOImpl(@Qualifier("teacherRepository") UserRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<User> findTeachersByCareer(String career) {
        return ((TeacherRepository)repository).findTeachersByCareer(career);
    }
}
