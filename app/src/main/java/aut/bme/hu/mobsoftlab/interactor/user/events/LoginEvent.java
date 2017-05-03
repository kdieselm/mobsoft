package aut.bme.hu.mobsoftlab.interactor.user.events;

import aut.bme.hu.mobsoftlab.model.Profile;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class LoginEvent {
    private Profile profile;
    private Throwable throwable;


    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}
