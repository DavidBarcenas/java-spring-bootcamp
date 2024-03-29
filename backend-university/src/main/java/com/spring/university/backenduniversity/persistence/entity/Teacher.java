package com.spring.university.backenduniversity.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Teacher extends User {
    private BigDecimal salary;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "teacher_career",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name ="career_id")
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "teachers"})
    private Set<Career> careers;

    public Teacher() {}

    public Teacher(Integer id, String name, String lastName, String idDocument, Address address, BigDecimal salary) {
        super(id, name, lastName, idDocument, address);
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Set<Career> getCareers() {
        return careers;
    }

    public void setCareers(Set<Career> careers) {
        this.careers = careers;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tTeacher{" +
                "salary=" + salary +
                '}';
    }
}
