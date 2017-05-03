package aut.bme.hu.mobsoftlab.model;

import com.orm.dsl.Table;

import java.util.List;

@Table
public class Movie {
  private Long id = null;
  private String title;
  private int year;
  private String director;
  private String genre;
  private List<String> actors;
  private String imgURL;


  public Movie() {
  }

  public Movie(Long id, String name, int year, String director, String genre, List<String> actors, String imgURL) {
    this.id = id;
    this.title = name;
    this.year = year;
    this.director = director;
    this.genre = genre;
    this.actors = actors;
    this.imgURL = imgURL;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public List<String> getActors() {
    return actors;
  }

  public void setActors(List<String> actors) {
    this.actors = actors;
  }

  public String getImgURL() {
    return imgURL;
  }

  public void setImgURL(String imgURL) {
    this.imgURL = imgURL;
  }

}