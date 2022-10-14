package com.restapi.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

  @JsonIgnore
  private String password;
  private String name;
  private String lastname;
  private String email;
  private String phone;

  @Column(name = "birth_date")
  private Date birthDate;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @ManyToOne(fetch=FetchType.EAGER)
  @JoinColumn(name = "role_id")
  private Role role;

  public User() {
  }

  public User(Long id, String name, String lastname, String email, String phone, Date birthDate) {
    setId(id);
    this.name = name;
    this.lastname = lastname;
    this.email = email;
    this.phone = phone;
    this.birthDate = birthDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}