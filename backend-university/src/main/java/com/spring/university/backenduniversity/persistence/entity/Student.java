package com.spring.university.backenduniversity.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User {
    @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "career_id")
    private Career career;

    public Student() {}

    public Student(Integer id, String name, String lastName, String idDocument, Address address) {
        super(id, name, lastName, idDocument, address);
    }

    @Override
    public String toString() {
        return super.toString() + "Student{}";
    }
}
