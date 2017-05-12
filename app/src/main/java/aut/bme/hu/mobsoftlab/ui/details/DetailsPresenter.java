package aut.bme.hu.mobsoftlab.ui.details;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import aut.bme.hu.mobsoftlab.interactor.movie.MoviesInteractor;
import aut.bme.hu.mobsoftlab.interactor.movie.events.GetAllRatingForMovieEvent;
import aut.bme.hu.mobsoftlab.interactor.movie.events.GetMovieEvent;
import aut.bme.hu.mobsoftlab.interactor.user.UserInteractor;
import aut.bme.hu.mobsoftlab.interactor.user.events.LoginEvent;
import aut.bme.hu.mobsoftlab.model.Movie;
import aut.bme.hu.mobsoftlab.model.Profile;
import aut.bme.hu.mobsoftlab.model.Rating;
import aut.bme.hu.mobsoftlab.ui.Presenter;
import de.greenrobot.event.EventBus;

import static aut.bme.hu.mobsoftlab.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class DetailsPresenter extends Presenter<DetailsScreen> {

    @Inject
    MoviesInteractor moviesInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;


    public DetailsPresenter() {
    }

    @Override
    public void attachScreen(DetailsScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void movieDetails(final Long id) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                moviesInteractor.getMovie(id);
            }
        });
    }


    public void onEventMainThread(GetMovieEvent event) {
        Log.d("test","test");
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showModel("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                Movie movie = event.getMovie();
                screen.showModel(movie.getTitle() + " " + movie.getDirector() + " " + movie.getGenre() + " " + movie.getYear());
                screen.showActorList(movie.getActors());
            }
        }
    }
}
