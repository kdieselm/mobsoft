package aut.bme.hu.mobsoftlab.ui.main;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import aut.bme.hu.mobsoftlab.interactor.movie.MoviesInteractor;
import aut.bme.hu.mobsoftlab.interactor.movie.events.GetAllMoviesEvent;
import aut.bme.hu.mobsoftlab.model.Movie;
import aut.bme.hu.mobsoftlab.ui.Presenter;
import de.greenrobot.event.EventBus;

import static aut.bme.hu.mobsoftlab.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    MoviesInteractor moviesInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public MainPresenter() {
    }


    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getMovies() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                moviesInteractor.getMovies();
            }
        });
    }


    public void onEventMainThread(GetAllMoviesEvent event) {
        Log.d("test","test");
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.showList(event.getMovies());
            }
        }
    }
}
