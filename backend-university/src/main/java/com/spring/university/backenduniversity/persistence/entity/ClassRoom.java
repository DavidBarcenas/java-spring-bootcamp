package com.spring.university.backenduniversity.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "class_rooms")
public class ClassRoom extends BaseEntity implements Serializable {
    @Column(name = "room_number", nullable = false)
    private Integer roomNumber;
    private String measures;
    private Integer desks;
    @Enumerated(EnumType.STRING)
    private Board board;
    @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "building_id", foreignKey = @ForeignKey(name = "FK_BUILDING_ID"))
    private Building building;

    public ClassRoom() {
    }

    public ClassRoom(Integer id, Integer roomNumber, String measures, Integer desks, Board board) {
        this.setId(id);
        this.roomNumber = roomNumber;
        this.measures = measures;
        this.desks = desks;
        this.board = board;
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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "id=" + this.getId() +
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
        return this.getId().equals(classRoom.getId()) && roomNumber.equals(classRoom.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), roomNumber);
    }
}
