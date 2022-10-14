package com.restapi.demo.models;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(columnDefinition = "DATETIME", updatable = false, nullable = false)
    protected Date createdDate;

    @Column(columnDefinition = "DATETIME", updatable = false, nullable = false)
    protected Date updatedDate;

    @PrePersist
    protected void onCreate() {
        updatedDate = new Date();
        if (createdDate == null) {
            createdDate = new Date();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
