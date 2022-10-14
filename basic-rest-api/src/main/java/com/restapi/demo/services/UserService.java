package com.restapi.demo.services;

import com.restapi.demo.dao.UserDao;
import com.restapi.demo.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
        user.setPassword(hashPassword(user.getPassword()));
        return userDao.create(user);
    }

    public User update(User user) {
        return userDao.update(user);
    }

    public void delete(long id) {
        userDao.delete(id);
    }

    public User login(User user) {
        return userDao.login(user);
    }

    private String hashPassword(String password) {
        Argon2 argon = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon.hash(1, 1024, 1, password);
    }
}
