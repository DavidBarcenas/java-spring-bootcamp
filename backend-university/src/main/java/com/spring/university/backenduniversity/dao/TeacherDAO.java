package com.spring.university.backenduniversity.dao;

import com.spring.university.backenduniversity.persistence.entity.User;

public interface TeacherDAO extends UserDAO {
    Iterable<User> findTeachersByCareer(String career);
}
