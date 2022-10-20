package org.example;

import org.example.entities.Post;
import org.example.entities.User;
import org.example.hibernate.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.Arrays;

public class ManyToMany {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User admin = new User(null, "Admin");
        User user = new User(null, "User");

        Post post1 = new Post(null, "This is a post 1");
        Post post2 = new Post(null, "This is a post 2");
        Post post3 = new Post(null, "This is a post 3");
        Post post4 = new Post(null, "This is a post 4");

        /*session.saveOrUpdate(post1);
        session.saveOrUpdate(post2);
        session.saveOrUpdate(post3);
        session.saveOrUpdate(post4);

        admin.setPosts(Arrays.asList(post1, post2));
        user.setPosts(Arrays.asList(post3, post4, post2));

        session.saveOrUpdate(admin);
        session.saveOrUpdate(user);*/

        User userData = session.get(User.class, 2);
        userData.getPosts().forEach(p -> System.out.println(p.getText()));

        session.getTransaction().commit();
        session.close();
    }
}
