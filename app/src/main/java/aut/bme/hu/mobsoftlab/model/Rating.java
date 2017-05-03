package aut.bme.hu.mobsoftlab.model;

import com.orm.dsl.Table;

@Table
public class Rating {
  private Long id = null;
  private Long user_id = null;
  private Long movie_id = null;
  private int rating;


  public Rating() {
  }

  public Rating(Long id, Long uid, Long mid, int rating) {
    this.id = id;
    user_id = uid;
    movie_id = mid;
    this.rating = rating;
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

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }



}