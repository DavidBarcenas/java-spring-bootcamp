package com.spring.university.backenduniversity.persistence.entity;

public class Student extends Person {
    public Student() {}

    public Student(Integer id, String name, String lastName, String idDocument, Address address) {
        super(id, name, lastName, idDocument, address);
    }
}
