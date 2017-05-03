package aut.bme.hu.mobsoftlab.ui;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import aut.bme.hu.mobsoftlab.ui.admin.AdminPresenter;
import aut.bme.hu.mobsoftlab.ui.details.DetailsPresenter;
import aut.bme.hu.mobsoftlab.ui.login.LoginPresenter;
import aut.bme.hu.mobsoftlab.ui.main.MainPresenter;
import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }

    @Provides
    @Singleton
    public AdminPresenter provideAdminPresenter() {
        return new AdminPresenter();
    }

    @Provides
    @Singleton
    public DetailsPresenter provideDetailsPresenter() {
        return new DetailsPresenter();
    }

    @Provides
    @Singleton
    EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}