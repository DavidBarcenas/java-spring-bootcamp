package com.restapi.demo.models;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(columnDefinition = "timestamp", updatable = false, nullable = false)
    protected Date createdDate;

    @Column(columnDefinition = "timestamp", updatable = false, nullable = false)
    protected Date updatedDate;

    @PrePersist
    protected void onCreate() {
        updatedDate = new java.sql.Date(new Date().getTime());
        if (createdDate == null) {
            createdDate = new java.sql.Date(new Date().getTime());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
