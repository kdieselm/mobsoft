package aut.bme.hu.mobsoftlab.interactor.user;

import android.util.Log;

import javax.inject.Inject;

import aut.bme.hu.mobsoftlab.MobSoftApplication;
import aut.bme.hu.mobsoftlab.interactor.user.events.LoginEvent;
import aut.bme.hu.mobsoftlab.model.Credentials;
import aut.bme.hu.mobsoftlab.model.LoggedInProfile;
import aut.bme.hu.mobsoftlab.model.Profile;
import aut.bme.hu.mobsoftlab.network.movie.MovieApi;
import aut.bme.hu.mobsoftlab.repository.Repository;
import de.greenrobot.event.EventBus;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class UserInteractor {

    @Inject
    Repository repository;
    @Inject
    EventBus bus;
    @Inject
    MovieApi api;

    public UserInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void logIn(final Profile profile){
        Credentials cred = new Credentials();
        cred.setEmail(profile.getEmail());
        cred.setPassword(profile.getPassword());
        api.userLoginPost(cred).enqueue(new Callback<LoggedInProfile>() {
            @Override
            public void onResponse(Response<LoggedInProfile> response) {
                LoginEvent event = new LoginEvent();
                event.setProfile(profile);
                event.setSuccess(true);
                repository.loginUser(profile);
                bus.post(event);
            }

            @Override
            public void onFailure(Throwable t) {
                LoginEvent event = new LoginEvent();
                event.setThrowable(t);
                event.setSuccess(false);
                bus.post(event);
            }
        });
//        LoginEvent event = new LoginEvent();
//        try{
//            repository.loginUser(profile);
//            bus.post(event);
//        }
//        catch (Exception e){
//            event.setThrowable(e);
//            bus.post(event);
//        }
    }
}
