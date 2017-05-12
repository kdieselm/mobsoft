package aut.bme.hu.mobsoftlab;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import aut.bme.hu.mobsoftlab.ui.UIModule;
import aut.bme.hu.mobsoftlab.ui.admin.AdminPresenter;
import aut.bme.hu.mobsoftlab.ui.admin.AdminScreen;
import aut.bme.hu.mobsoftlab.ui.details.DetailsPresenter;
import aut.bme.hu.mobsoftlab.ui.login.LoginPresenter;
import aut.bme.hu.mobsoftlab.ui.main.MainPresenter;
import aut.bme.hu.mobsoftlab.utils.UiExecutor;
import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

/**
 * Created by mobsoft on 2017. 05. 12..
 */
@Module
public class TestModule {
    private final aut.bme.hu.mobsoftlab.ui.UIModule UIModule;

    public TestModule(Context context) {
        this.UIModule = new UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }


    @Provides
    public MainPresenter provideMainPresenter() {
        return UIModule.provideMainPresenter();
    }

    @Provides
    public LoginPresenter provideLoginPresenter() {
        return UIModule.provideLoginPresenter();
    }

    @Provides
    public AdminPresenter provideAdminPresenter() {
        return UIModule.provideAdminPresenter();
    }

    @Provides
    public DetailsPresenter provideDetailsPresenter() {
        return UIModule.provideDetailsPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }
}
