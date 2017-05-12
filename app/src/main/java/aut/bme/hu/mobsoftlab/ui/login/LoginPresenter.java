package aut.bme.hu.mobsoftlab.ui.login;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import aut.bme.hu.mobsoftlab.interactor.movie.MoviesInteractor;
import aut.bme.hu.mobsoftlab.interactor.movie.events.GetAllMoviesEvent;
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

public class LoginPresenter extends Presenter<LoginScreen> {

    @Inject
    UserInteractor userInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public LoginPresenter() {
    }

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void loginUser(final Profile profile) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userInteractor.logIn(profile);
            }
        });
    }


    public void onEventMainThread(LoginEvent event) {
        Log.d("test","test");
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                Profile prof = event.getProfile();
                screen.showMessage(prof.getEmail());
            }
        }
    }
}
