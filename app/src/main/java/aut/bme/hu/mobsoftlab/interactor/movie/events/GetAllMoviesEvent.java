package aut.bme.hu.mobsoftlab.interactor.movie.events;

import java.util.List;

import aut.bme.hu.mobsoftlab.model.Movie;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class GetAllMoviesEvent {
    private List<Movie> movies;
    private Throwable throwable;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movie) {
        this.movies = movie;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}
