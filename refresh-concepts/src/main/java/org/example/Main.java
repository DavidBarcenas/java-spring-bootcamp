package org.example;

import org.example.entities.AnimalEntity;
import org.example.hibernate.utils.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Insert
        AnimalEntity entity = new AnimalEntity();
        entity.setName("Kong");
        // session.save(entity);

        // Update
        AnimalEntity entityUpdate = new AnimalEntity();
        entityUpdate.setId(2);
        entityUpdate.setName("Snake");
        // session.update(entityUpdate);

        // Delete
        /*AnimalEntity entityDelete = new AnimalEntity();
        entityDelete.setId(1);
        session.delete(entityDelete);*/

        /*AnimalEntity entityRead = session.get(AnimalEntity.class, 2);
        System.out.println(entityRead.getName());*/


        session.saveOrUpdate(entity);
        session.saveOrUpdate(entityUpdate);

        session.getTransaction().commit();
        session.close();
    }
}