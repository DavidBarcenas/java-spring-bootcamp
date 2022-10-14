package com.restapi.demo.dao.imp;

import com.restapi.demo.dao.RoleDao;
import com.restapi.demo.models.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class RoleDaoImp implements RoleDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Role> getAll() {
        String hql = "FROM Role as u ";
        return (List<Role>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Role getById(long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role create(Role role) {
        entityManager.merge(role);
        return role;
    }

    @Override
    public Role update(Role role) {
        entityManager.merge(role);
        return role;
    }

    @Override
    public void delete(long id) {
        Role role = getById(id);
        entityManager.remove(role);
    }
}
