package com.spring.university.backenduniversity.persistence.entity;

import com.spring.university.backenduniversity.persistence.enums.EmployeeType;

import java.math.BigDecimal;

public class Employee extends Person {
    private BigDecimal salary;
    private EmployeeType employeeType;

    public Employee() {
    }

    public Employee(
            Integer id,
            String name,
            String lastName,
            String idDocument,
            Address address,
            BigDecimal salary,
            EmployeeType employeeType
    ) {
        super(id, name, lastName, idDocument, address);
        this.salary = salary;
        this.employeeType = employeeType;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }
}
