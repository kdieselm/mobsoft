package aut.bme.hu.mobsoftlab;

import android.app.Application;

import com.orm.SugarContext;

import javax.inject.Inject;

import aut.bme.hu.mobsoftlab.repository.Repository;
import aut.bme.hu.mobsoftlab.ui.UIModule;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class MobSoftApplication extends Application {

    @Inject
    Repository repository;

    public static MobSoftApplicationComponent injector;

    public void setInjector(MobSoftApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerMobSoftApplicationComponent.builder().uIModule(new UIModule(this)).build();
        injector.inject(this);
        repository.open(getApplicationContext());
    }

}
