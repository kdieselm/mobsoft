package aut.bme.hu.mobsoftlab;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

import javax.inject.Singleton;

import aut.bme.hu.mobsoftlab.ui.UIModule;
import aut.bme.hu.mobsoftlab.ui.main.MainActivity;
import dagger.Component;


@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

}
