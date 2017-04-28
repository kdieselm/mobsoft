package aut.bme.hu.mobsoftlab.interactor.movie;

import java.util.List;

import javax.inject.Inject;

import aut.bme.hu.mobsoftlab.MobSoftApplication;
import aut.bme.hu.mobsoftlab.interactor.movie.events.GetAllMoviesEvent;
import aut.bme.hu.mobsoftlab.model.Movie;
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
            ///TODO GetAllMoviesEvent megcsinálása + összes többi
            //event.setMovies(movies);
            //bus.post(event);
        } catch (Exception e) {
            //event.setThrowable(e);
            //bus.post(event);
        }
    }


}
