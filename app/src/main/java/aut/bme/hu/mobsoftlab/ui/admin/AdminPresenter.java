package aut.bme.hu.mobsoftlab.ui.admin;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import aut.bme.hu.mobsoftlab.interactor.movie.MoviesInteractor;
import aut.bme.hu.mobsoftlab.interactor.movie.events.AddMovieEvent;
import aut.bme.hu.mobsoftlab.interactor.user.UserInteractor;
import aut.bme.hu.mobsoftlab.interactor.user.events.LoginEvent;
import aut.bme.hu.mobsoftlab.model.Movie;
import aut.bme.hu.mobsoftlab.model.Profile;
import aut.bme.hu.mobsoftlab.ui.Presenter;
import de.greenrobot.event.EventBus;

import static aut.bme.hu.mobsoftlab.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class AdminPresenter extends Presenter<AdminScreen> {

    @Inject
    MoviesInteractor moviesInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public AdminPresenter() {
    }

    @Override
    public void attachScreen(AdminScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void addMovie(final Movie movie) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                moviesInteractor.addMovie(movie);
            }
        });
    }


    public void onEventMainThread(AddMovieEvent event) {
        Log.d("test","test");
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showError("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.showModel(event.getMovie().getMovieTitle());
            }
        }
    }
}
