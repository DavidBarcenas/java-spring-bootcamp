package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "partners")
public class Partner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer code;
    @Column(length = 40)
    private String name;
    @Column(unique = true, length = 60)
    private String email;

    @OneToOne(mappedBy = "partner", cascade = CascadeType.ALL)
    private Club club;

    public Partner() {
    }

    public Partner(Integer code, String name, String email) {
        this.code = code;
        this.name = name;
        this.email = email;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
