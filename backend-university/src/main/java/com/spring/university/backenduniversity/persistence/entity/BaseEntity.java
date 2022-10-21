package com.spring.university.backenduniversity.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(name = "created_at", columnDefinition = "timestamp", updatable = false, nullable = false)
    protected LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "timestamp", updatable = false, nullable = false)
    protected LocalDateTime updatedAt;

    @PrePersist
    private void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    private void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
