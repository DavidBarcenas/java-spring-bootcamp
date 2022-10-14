package com.restapi.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "users")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

  @JsonIgnore
  @Getter @Setter
  private String password;

  @Getter @Setter
  private String name;

  @Getter @Setter
  private String lastname;
  @Getter @Setter
  private String email;

  @Getter @Setter
  private String phone;
  @Getter @Setter
  @Column(name = "birth_date")
  private Date birthDate;

  @Getter @Setter
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @ManyToOne(fetch=FetchType.EAGER)
  @JoinColumn(name = "role_id")
  private Role role;

  public User(Long id, String name, String lastname, String email, String phone, Date birthDate) {
    setId(id);
    this.name = name;
    this.lastname = lastname;
    this.email = email;
    this.phone = phone;
    this.birthDate = birthDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    User user = (User) o;
    return getId() != null && Objects.equals(getId(), user.getId());
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}