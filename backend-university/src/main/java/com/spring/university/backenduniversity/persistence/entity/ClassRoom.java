package com.spring.university.backenduniversity.persistence.entity;

import com.spring.university.backenduniversity.persistence.enums.Board;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class ClassRoom implements Serializable {
    private Integer id;
    private Integer roomNumber;
    private String measures;
    private Integer desks;
    private Board board;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ClassRoom() {
    }

    public ClassRoom(Integer id, Integer roomNumber, String measures, Integer desks, Board board) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.measures = measures;
        this.desks = desks;
        this.board = board;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getMeasures() {
        return measures;
    }

    public void setMeasures(String measures) {
        this.measures = measures;
    }

    public Integer getDesks() {
        return desks;
    }

    public void setDesks(Integer desks) {
        this.desks = desks;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
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
        return "ClassRoom{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", measures='" + measures + '\'' +
                ", desks=" + desks +
                ", board=" + board +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassRoom classRoom = (ClassRoom) o;
        return id.equals(classRoom.id) && roomNumber.equals(classRoom.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber);
    }
}
