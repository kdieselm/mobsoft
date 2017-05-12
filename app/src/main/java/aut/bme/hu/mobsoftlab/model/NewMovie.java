package aut.bme.hu.mobsoftlab.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;





public class NewMovie   {
  
  @SerializedName("movie_title")
  private String movieTitle = null;
  
  @SerializedName("movie_year")
  private String movieYear = null;
  
  @SerializedName("movie_director")
  private String movieDirector = null;
  
  @SerializedName("movie_genre")
  private String movieGenre = null;
  
  @SerializedName("movie_image")
  private String movieImage = null;
  

  
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
    NewMovie newMovie = (NewMovie) o;
    return Objects.equals(movieTitle, newMovie.movieTitle) &&
        Objects.equals(movieYear, newMovie.movieYear) &&
        Objects.equals(movieDirector, newMovie.movieDirector) &&
        Objects.equals(movieGenre, newMovie.movieGenre) &&
        Objects.equals(movieImage, newMovie.movieImage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(movieTitle, movieYear, movieDirector, movieGenre, movieImage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewMovie {\n");
    
    sb.append("    movieTitle: ").append(toIndentedString(movieTitle)).append("\n");
    sb.append("    movieYear: ").append(toIndentedString(movieYear)).append("\n");
    sb.append("    movieDirector: ").append(toIndentedString(movieDirector)).append("\n");
    sb.append("    movieGenre: ").append(toIndentedString(movieGenre)).append("\n");
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
