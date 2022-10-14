package com.restapi.demo.dao;

import com.restapi.demo.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    List<User> getAll();
    User getById(long id);
    User create(User user);
    User update(User user);
    void delete(long id);

    User login(User user);
}
