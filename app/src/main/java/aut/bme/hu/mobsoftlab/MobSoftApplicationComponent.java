package aut.bme.hu.mobsoftlab;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

import javax.inject.Singleton;

import aut.bme.hu.mobsoftlab.ui.UIModule;
import aut.bme.hu.mobsoftlab.ui.admin.AdminActivity;
import aut.bme.hu.mobsoftlab.ui.details.DetailsActivity;
import aut.bme.hu.mobsoftlab.ui.login.LoginActivity;
import aut.bme.hu.mobsoftlab.ui.main.MainActivity;
import dagger.Component;


@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);
    void inject(AdminActivity adminActivity);
    void inject(DetailsActivity detailsActivity);
}
