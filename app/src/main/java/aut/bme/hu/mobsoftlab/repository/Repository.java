package aut.bme.hu.mobsoftlab.repository;

import android.content.Context;

import java.util.List;

import aut.bme.hu.mobsoftlab.model.Movie;
import aut.bme.hu.mobsoftlab.model.Profile;
import aut.bme.hu.mobsoftlab.model.Rating;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public interface Repository {

    void open(Context context);

    void close();

    List<Movie> getMovies();

    void addMovie(Movie movie);

    void deleteMovie(Movie movie);

    void rateMovie(Rating rating);

    boolean loginUser(Profile profile);

    Movie getMovie(Long id);

    List<Rating> getRatingForMovie(Movie movie);
}
