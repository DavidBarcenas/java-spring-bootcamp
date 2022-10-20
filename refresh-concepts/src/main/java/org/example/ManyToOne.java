package org.example;

import org.example.hibernate.utils.HibernateUtil;
import org.example.manytoone.Person;
import org.example.manytoone.Phone;
import org.hibernate.Session;

import java.util.Arrays;

public class ManyToOne {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Person person = new Person(null, "Amauri");
        Person person2 = new Person(null, "Jorge");

        Phone phone = new Phone(null, "5544663377");
        Phone phone2 = new Phone(null, "5599887766");

        phone.setPerson(person);
        phone2.setPerson(person);
        person.setPhones(Arrays.asList(phone, phone2));

        /*session.saveOrUpdate(person);
        session.saveOrUpdate(person2);*/

        Person personData = session.get(Person.class, 8);
        personData.getPhones().forEach(t -> System.out.println(t.getPhoneNumber()));

        session.getTransaction().commit();
        session.close();
    }
}
