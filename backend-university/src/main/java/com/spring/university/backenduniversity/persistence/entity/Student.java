package com.spring.university.backenduniversity.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User {
    @ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "career_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "students"})
    private Career career;

    public Student() {}

    public Student(Integer id, String name, String lastName, String idDocument, Address address) {
        super(id, name, lastName, idDocument, address);
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    @Override
    public String toString() {
        return super.toString() + "Student{}";
    }
}
