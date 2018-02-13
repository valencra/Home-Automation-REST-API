package com.valencra.homeautomation.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.valencra.homeautomation.core.BaseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {
  public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
  private String name;
  private String username;
  @JsonIgnore
  private String password;
  @JsonIgnore
  private String[] roles;

  protected User() {
    super();
  }

  public User(String name, String password, String[] roles) {
    this();
    this.name = name;
    this.username = username;
    setPassword(password);
    this.roles = roles;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = PASSWORD_ENCODER.encode(password);
  }

  public String[] getRoles() {
    return roles;
  }

  public void setRoles(String[] roles) {
    this.roles = roles;
  }
}
