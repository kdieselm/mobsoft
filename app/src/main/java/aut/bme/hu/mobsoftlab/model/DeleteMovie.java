package aut.bme.hu.mobsoftlab.model;

import java.util.Objects;


import com.google.gson.annotations.SerializedName;





public class DeleteMovie   {
  
  @SerializedName("movie_id")
  private Integer movieId = null;
  

  
  /**
   * Esemény neve
   **/

  public Integer getMovieId() {
    return movieId;
  }
  public void setMovieId(Integer movieId) {
    this.movieId = movieId;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteMovie deleteMovie = (DeleteMovie) o;
    return Objects.equals(movieId, deleteMovie.movieId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(movieId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteMovie {\n");
    
    sb.append("    movieId: ").append(toIndentedString(movieId)).append("\n");
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
