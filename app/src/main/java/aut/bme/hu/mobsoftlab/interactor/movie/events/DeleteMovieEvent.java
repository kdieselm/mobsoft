package aut.bme.hu.mobsoftlab.interactor.movie.events;

import aut.bme.hu.mobsoftlab.model.Movie;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class DeleteMovieEvent {
    private Movie movie;
    private Throwable throwable;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}
