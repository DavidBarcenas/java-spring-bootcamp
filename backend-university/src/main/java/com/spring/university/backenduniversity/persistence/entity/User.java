package com.spring.university.backenduniversity.persistence.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Student.class, name = "student"),
        @JsonSubTypes.Type(value = Teacher.class, name = "teacher"),
        @JsonSubTypes.Type(value = Employee.class, name = "employee"),
})
public abstract class User extends BaseEntity implements Serializable {
    @Column(nullable = false, length = 60)
    private String name;

    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;

    @Column(name = "id_document", unique = true, nullable = false, length = 10)
    private String idDocument;

    @Embedded
    private Address address;

    public User() {
    }

    public User(Integer id, String name, String lastName, String idDocument, Address address) {
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
        return "User{" +
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
        User user = (User) o;
        return this.getId().equals(user.getId()) && idDocument.equals(user.idDocument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), idDocument);
    }
}
