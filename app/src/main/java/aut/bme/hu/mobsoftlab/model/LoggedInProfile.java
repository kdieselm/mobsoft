package aut.bme.hu.mobsoftlab.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;




public class LoggedInProfile   {
  
  @SerializedName("profile")
  private Profile profile = null;
  
  @SerializedName("token")
  private String token = null;
  

  
  /**
   **/

  public Profile getProfile() {
    return profile;
  }
  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  
  /**
   * Azonosító token a későbbi hívásokhoz
   **/

  public String getToken() {
    return token;
  }
  public void setToken(String token) {
    this.token = token;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoggedInProfile loggedInProfile = (LoggedInProfile) o;
    return Objects.equals(profile, loggedInProfile.profile) &&
        Objects.equals(token, loggedInProfile.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(profile, token);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoggedInProfile {\n");
    
    sb.append("    profile: ").append(toIndentedString(profile)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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
