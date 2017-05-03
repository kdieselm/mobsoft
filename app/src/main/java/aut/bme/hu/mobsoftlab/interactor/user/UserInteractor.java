package aut.bme.hu.mobsoftlab.interactor.user;

import android.util.Log;

import javax.inject.Inject;

import aut.bme.hu.mobsoftlab.MobSoftApplication;
import aut.bme.hu.mobsoftlab.interactor.user.events.LoginEvent;
import aut.bme.hu.mobsoftlab.model.Profile;
import aut.bme.hu.mobsoftlab.repository.Repository;
import de.greenrobot.event.EventBus;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class UserInteractor {

    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public UserInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void logIn(Profile profile){
        LoginEvent event = new LoginEvent();
        try{
            repository.loginUser(profile);
            bus.post(event);
        }
        catch (Exception e){
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
