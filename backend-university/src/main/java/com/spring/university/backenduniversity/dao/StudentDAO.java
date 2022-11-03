package com.spring.university.backenduniversity.dao;

import com.spring.university.backenduniversity.persistence.entity.User;

public interface StudentDAO extends UserDAO {
    Iterable<User> findByName(String name);
}
