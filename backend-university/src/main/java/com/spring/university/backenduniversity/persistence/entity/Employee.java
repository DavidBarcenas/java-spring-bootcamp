package com.spring.university.backenduniversity.persistence.entity;

import com.spring.university.backenduniversity.persistence.enums.EmployeeType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "employees")
@PrimaryKeyJoinColumn(name = "person_id")
public class Employee extends Person {
    private BigDecimal salary;

    @Column(name = "employee_type")
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "building_id", foreignKey = @ForeignKey(name = "FK_BUILDING_ID"))
    private Building building;

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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tEmployee{" +
                "salary=" + salary +
                ", employeeType=" + employeeType +
                '}';
    }
}
