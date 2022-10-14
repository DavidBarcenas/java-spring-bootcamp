package com.restapi.demo.services;

import com.restapi.demo.dao.UserDao;
import com.restapi.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User getById(long id) {
        return userDao.getById(id);
    }

    public User create(User user) {
        return userDao.create(user);
    }

    public User update(User user) {
        return userDao.update(user);
    }

    public void delete(long id) {
        userDao.delete(id);
    }
}
