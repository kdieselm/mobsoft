package aut.bme.hu.mobsoftlab.ui;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

import android.content.Context;

import javax.inject.Singleton;

import aut.bme.hu.mobsoftlab.ui.main.MainPresenter;
import dagger.Module;
import dagger.Provides;

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

}