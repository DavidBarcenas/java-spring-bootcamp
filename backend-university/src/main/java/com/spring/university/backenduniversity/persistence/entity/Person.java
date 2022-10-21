package com.spring.university.backenduniversity.persistence.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Person extends BaseEntity implements Serializable {
    private String name;
    private String lastName;
    private String idDocument;
    private Address address;

    public Person() {
    }

    public Person(Integer id, String name, String lastName, String idDocument, Address address) {
        this.setId(id);
        this.name = name;
        this.lastName = lastName;
        this.idDocument = idDocument;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + this.getId() +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idDocument='" + idDocument + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return this.getId().equals(person.getId()) && idDocument.equals(person.idDocument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), idDocument);
    }
}
