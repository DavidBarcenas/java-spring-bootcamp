package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "clubs")
public class Club implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 60)
    private String name;

    @OneToOne()
    @JoinColumn(name = "id_partner")
    private Partner partner;

    public Club() {
    }

    public Club(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}
