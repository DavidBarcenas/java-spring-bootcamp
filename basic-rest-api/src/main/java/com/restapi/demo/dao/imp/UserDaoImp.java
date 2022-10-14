package com.restapi.demo.dao.imp;

import com.restapi.demo.dao.UserDao;
import com.restapi.demo.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

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

    @Override
    public User login(User dto) {
        boolean isAuthenticated = false;

        String hql = "FROM User as u WHERE u.password is not null and u.email = :email";

        List<User> result = entityManager
                .createQuery(hql.toString())
                .setParameter("email", dto.getEmail())
                .getResultList();
        if(result.size() == 0) { return null; }

        User user = result.get(0);
        isAuthenticated = true;

        if (!StringUtils.isEmpty(dto.getPassword())) {
            Argon2 argon = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            isAuthenticated = argon.verify(user.getPassword(), dto.getPassword());
        }

        if(isAuthenticated) {
            return user;
        }

        return null;
    }
}
