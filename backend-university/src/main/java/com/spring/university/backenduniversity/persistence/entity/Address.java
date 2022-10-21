package com.spring.university.backenduniversity.persistence.entity;

import java.io.Serializable;

public class Address implements Serializable {
    private String street;
    private String houseNumber;
    private String zip;
    private String department;
    private String floor;
    private String location;

    public Address() {
    }

    public Address(String street, String houseNumber, String zip, String department, String floor, String location) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zip = zip;
        this.department = department;
        this.floor = floor;
        this.location = location;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", zip='" + zip + '\'' +
                ", department='" + department + '\'' +
                ", floor='" + floor + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
