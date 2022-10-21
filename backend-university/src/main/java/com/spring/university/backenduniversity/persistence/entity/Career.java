package com.spring.university.backenduniversity.persistence.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Career implements Serializable {
    private Integer id;
    private String name;
    private Integer totalSubjects;
    private Integer totalYears;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Career() {
    }

    public Career(Integer id, String name, Integer totalSubjects, Integer totalYears) {
        this.id = id;
        this.name = name;
        this.totalSubjects = totalSubjects;
        this.totalYears = totalYears;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalSubjects() {
        return totalSubjects;
    }

    public void setTotalSubjects(Integer totalSubjects) {
        this.totalSubjects = totalSubjects;
    }

    public Integer getTotalYears() {
        return totalYears;
    }

    public void setTotalYears(Integer totalYears) {
        this.totalYears = totalYears;
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
        return "Career{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalSubjects=" + totalSubjects +
                ", totalYears=" + totalYears +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Career career = (Career) o;
        return id.equals(career.id) && name.equals(career.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
