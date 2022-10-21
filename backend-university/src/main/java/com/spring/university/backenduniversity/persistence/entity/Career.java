package com.spring.university.backenduniversity.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "careers")
public class Career extends BaseEntity implements Serializable {
    @Column(nullable = false, unique = true, length = 80)
    private String name;
    @Column(name = "total_subjects")
    private Integer totalSubjects;

    @Column(name = "total_years")
    private Integer totalYears;

    public Career() {
    }

    public Career(Integer id, String name, Integer totalSubjects, Integer totalYears) {
        this.setId(id);
        this.name = name;
        this.totalSubjects = totalSubjects;
        this.totalYears = totalYears;
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

    @Override
    public String toString() {
        return "Career{" +
                "id=" + this.getId() +
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
        return this.getId().equals(career.getId()) && name.equals(career.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), name);
    }
}
