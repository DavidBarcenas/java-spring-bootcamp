package com.restapi.demo.dao.imp;

import com.restapi.demo.dao.PermissionDao;
import com.restapi.demo.models.Permission;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class PermissionDaoImp implements PermissionDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Permission> getAll() {
        String hql = "FROM Permission as u ";
        return (List<Permission>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Permission getById(long id) {
        return entityManager.find(Permission.class, id);
    }

    @Override
    public Permission create(Permission permission) {
        entityManager.merge(permission);
        return permission;
    }

    @Override
    public Permission update(Permission permission) {
        entityManager.merge(permission);
        return permission;
    }

    @Override
    public void delete(long id) {
        Permission permission = getById(id);
        entityManager.remove(permission);
    }
}
