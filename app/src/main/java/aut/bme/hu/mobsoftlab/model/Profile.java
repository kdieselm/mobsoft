package aut.bme.hu.mobsoftlab.model;

import com.orm.dsl.Table;

import java.util.List;
import java.util.Objects;

@Table
public class Profile {
  private Long id = null;
  private String userEmail;
  private String password;


  public Profile() {
  }

  public Profile(Long id, String email, String password) {
    this.id = id;
    this.userEmail = email;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserEmail() {
    return email;
  }

  public void setUserEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  private Integer userId = null;


  private String email = null;



  /**
   * Felhasználó azonosítója
   **/

  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  /**
   * Felhasználó telefonszáma, amit a belépéshez használ
   **/

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Profile profile = (Profile) o;
    return Objects.equals(userId, profile.userId) &&
            Objects.equals(email, profile.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Profile {\n");

    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}