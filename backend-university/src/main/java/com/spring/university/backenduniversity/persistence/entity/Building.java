package com.spring.university.backenduniversity.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "buildings")
public class Building extends BaseEntity implements Serializable {
    private Double measures;
    @Column(unique = true, nullable = false)
    private String name;
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
    private Set<ClassRoom> classRooms;

    public Building() {
    }

    public Building(Integer id, Double mts2, String name, Address address) {
        this.setId(id);
        this.measures = mts2;
        this.name = name;
        this.address = address;
    }

    public Double getMeasures() {
        return measures;
    }

    public void setMeasures(Double measures) {
        this.measures = measures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<ClassRoom> getClassRooms() {
        return classRooms;
    }

    public void setClassRooms(Set<ClassRoom> classRooms) {
        this.classRooms = classRooms;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + this.getId() +
                ", mts2=" + measures +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return this.getId().equals(building.getId()) && name.equals(building.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), name);
    }
}
