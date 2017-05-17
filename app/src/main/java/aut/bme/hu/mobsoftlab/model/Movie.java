package aut.bme.hu.mobsoftlab.model;

import com.orm.dsl.Table;

import java.util.List;
import java.util.Objects;

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

  public Long getMovieId() {
    return id;
  }

  public void setMovieId(Long id) {
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


  private Integer movieid = null;

  private String movieTitle = null;


  private String movieYear = null;


  private String movieDirector = null;


  private String movieGenre = null;


  private String movieActors = null;


  private String movieImage = null;



  /**
   * Ticket azonosítója
   **/

  public Integer getId() {
    return movieid;
  }
  public void setId(Integer id) {
    this.movieid = id;
  }


  /**
   * Esemény neve
   **/

  public String getMovieTitle() {
    return movieTitle;
  }
  public void setMovieTitle(String movieTitle) {
    this.movieTitle = movieTitle;
  }


  /**
   * Esemény ideje
   **/

  public String getMovieYear() {
    return movieYear;
  }
  public void setMovieYear(String movieYear) {
    this.movieYear = movieYear;
  }


  /**
   * Esemény helyszíne
   **/

  public String getMovieDirector() {
    return movieDirector;
  }
  public void setMovieDirector(String movieDirector) {
    this.movieDirector = movieDirector;
  }


  /**
   * Jegyek darabszáma
   **/

  public String getMovieGenre() {
    return movieGenre;
  }
  public void setMovieGenre(String movieGenre) {
    this.movieGenre = movieGenre;
  }


  /**
   * Színészek
   **/

  public String getMovieActors() {
    return movieActors;
  }
  public void setMovieActors(String movieActors) {
    this.movieActors = movieActors;
  }


  /**
   * Kép URL
   **/

  public String getMovieImage() {
    return movieImage;
  }
  public void setMovieImage(String movieImage) {
    this.movieImage = movieImage;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Movie movie = (Movie) o;
    return Objects.equals(movieid, movie.movieid) &&
            Objects.equals(movieTitle, movie.movieTitle) &&
            Objects.equals(movieYear, movie.movieYear) &&
            Objects.equals(movieDirector, movie.movieDirector) &&
            Objects.equals(movieGenre, movie.movieGenre) &&
            Objects.equals(movieActors, movie.movieActors) &&
            Objects.equals(movieImage, movie.movieImage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(movieid, movieTitle, movieYear, movieDirector, movieGenre, movieActors, movieImage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Movie {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    movieTitle: ").append(toIndentedString(movieTitle)).append("\n");
    sb.append("    movieYear: ").append(toIndentedString(movieYear)).append("\n");
    sb.append("    movieDirector: ").append(toIndentedString(movieDirector)).append("\n");
    sb.append("    movieGenre: ").append(toIndentedString(movieGenre)).append("\n");
    sb.append("    movieActors: ").append(toIndentedString(movieActors)).append("\n");
    sb.append("    movieImage: ").append(toIndentedString(movieImage)).append("\n");
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