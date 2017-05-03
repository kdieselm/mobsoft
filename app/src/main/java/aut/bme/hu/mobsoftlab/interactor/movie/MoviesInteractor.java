package aut.bme.hu.mobsoftlab.interactor.movie;

import java.util.List;

import javax.inject.Inject;

import aut.bme.hu.mobsoftlab.MobSoftApplication;
import aut.bme.hu.mobsoftlab.interactor.movie.events.AddMovieEvent;
import aut.bme.hu.mobsoftlab.interactor.movie.events.DeleteMovieEvent;
import aut.bme.hu.mobsoftlab.interactor.movie.events.GetAllMoviesEvent;
import aut.bme.hu.mobsoftlab.interactor.movie.events.GetAllRatingForMovieEvent;
import aut.bme.hu.mobsoftlab.interactor.movie.events.GetMovieEvent;
import aut.bme.hu.mobsoftlab.interactor.movie.events.RateMovieEvent;
import aut.bme.hu.mobsoftlab.model.Movie;
import aut.bme.hu.mobsoftlab.model.Rating;
import aut.bme.hu.mobsoftlab.repository.Repository;
import de.greenrobot.event.EventBus;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class MoviesInteractor {

    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public MoviesInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getMovies() {
        GetAllMoviesEvent event = new GetAllMoviesEvent();
        try {
            List<Movie> movies = repository.getMovies();
            event.setMovies(movies);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void addMovie(Movie movie){
        AddMovieEvent event = new AddMovieEvent();
        try{
            repository.addMovie(movie);
            //event.setMovie(movie);
            bus.post(event);
        }
        catch(Exception e){
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void deleteMovie(Movie movie){
        DeleteMovieEvent event = new DeleteMovieEvent();
        try{
            repository.deleteMovie(movie);
            //event.setMovie(movie);
            bus.post(event);
        }
        catch(Exception e){
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getAllRating(Movie movie){
        GetAllRatingForMovieEvent event = new GetAllRatingForMovieEvent();
        try{
            List<Rating> ratings = repository.getRatingForMovie(movie);
            event.setRatings(ratings);
            bus.post(event);
        }
        catch(Exception e){
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getMovie(Long id){
        GetMovieEvent event = new GetMovieEvent();
        try{
            Movie movie = repository.getMovie(id);
            event.setMovie(movie);
            bus.post(event);
        }
        catch(Exception e){
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void rateMovie(Rating rating){
        RateMovieEvent event = new RateMovieEvent();
        try{
            repository.rateMovie(rating);
            //event.setRating(rating);
            bus.post(event);
        }
        catch(Exception e){
            event.setThrowable(e);
            bus.post(event);
        }
    }

}
