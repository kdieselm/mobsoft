package aut.bme.hu.mobsoftlab.model;

import com.orm.dsl.Table;

import java.util.List;

@Table
public class Profile {
  private Long id = null;
  private String email;
  private String password;


  public Profile() {
  }

  public Profile(Long id, String email, String password) {
    this.id = id;
    this.email = email;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }



}