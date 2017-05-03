package aut.bme.hu.mobsoftlab.interactor.movie.events;

import aut.bme.hu.mobsoftlab.model.Rating;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class RateMovieEvent {
    private Rating rating;
    private Throwable throwable;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
