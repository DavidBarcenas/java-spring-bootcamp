package com.spring.university.backenduniversity.persistence.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Building implements Serializable {
    private Integer id;
    private Double mts2;
    private String name;
    private Address address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Building() {
    }

    public Building(Integer id, Double mts2, String name, Address address) {
        this.id = id;
        this.mts2 = mts2;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMts2() {
        return mts2;
    }

    public void setMts2(Double mts2) {
        this.mts2 = mts2;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", mts2=" + mts2 +
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
        return id.equals(building.id) && name.equals(building.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
