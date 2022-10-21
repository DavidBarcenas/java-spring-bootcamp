package com.spring.university.backenduniversity.persistence.entity;

import java.math.BigDecimal;

public class Teacher extends Person {
    private BigDecimal salary;

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
}
