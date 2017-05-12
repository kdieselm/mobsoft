package aut.bme.hu.mobsoftlab.model;

import com.google.gson.annotations.SerializedName;
import com.orm.dsl.Table;

import java.util.Objects;

@Table
public class Rating {
  private Long id = null;
  private Long user_id = null;
  private Long movie_id = null;


  private int movierating;


  public Rating() {
  }

  public Rating(Long id, Long uid, Long mid, int rating) {
    this.id = id;
    user_id = uid;
    movie_id = mid;
    this.movierating = rating;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }

  public Long getMovie_id() {
    return movie_id;
  }

  public void setMovie_id(Long movie_id) {
    this.movie_id = movie_id;
  }

  public int getMovieRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  @SerializedName("user_id")
  private Integer userId = null;

  @SerializedName("movie_id")
  private Integer movieId = null;

  @SerializedName("rating")
  private Integer rating = null;



  /**
   * Felhasználó azonosító
   **/

  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  /**
   * Film azon
   **/

  public Integer getMovieId() {
    return movieId;
  }
  public void setMovieId(Integer movieId) {
    this.movieId = movieId;
  }


  /**
   * Rating
   **/

  public Integer getRating() {
    return rating;
  }
  public void setRating(Integer rating) {
    this.rating = rating;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rating rating = (Rating) o;
    return Objects.equals(userId, rating.userId) &&
            Objects.equals(movieId, rating.movieId) &&
            Objects.equals(rating, rating.rating);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, movieId, rating);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Rating {\n");

    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    movieId: ").append(toIndentedString(movieId)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
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