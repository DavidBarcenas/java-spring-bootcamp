package org.example;

import org.example.entities.User;
import org.example.hibernate.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;


public class MainJPQL {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("select u from User u where u.id = ?1");
        query.setParameter(1, Integer.parseInt("1"));

        User user = (User) query.getSingleResult();
        System.out.println(user.getName());

        session.close();
    }
}
