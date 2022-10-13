package com.restapi.demo.dao.imp;

import com.restapi.demo.dao.UserDao;
import com.restapi.demo.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAll() {
        String hql = "FROM User as u ";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User create(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public User update(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public void delete(long id) {
        User user = getById(id);
        entityManager.remove(user);
    }
}
