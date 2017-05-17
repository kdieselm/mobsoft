package aut.bme.hu.mobsoftlab;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

import javax.inject.Singleton;

import aut.bme.hu.mobsoftlab.interactor.InteractorModule;
import aut.bme.hu.mobsoftlab.interactor.movie.MoviesInteractor;
import aut.bme.hu.mobsoftlab.interactor.user.UserInteractor;
import aut.bme.hu.mobsoftlab.mock.MockNetworkModule;
import aut.bme.hu.mobsoftlab.network.NetworkModule;
import aut.bme.hu.mobsoftlab.network.movie.MovieApi;
import aut.bme.hu.mobsoftlab.repository.RepositoryModule;
import aut.bme.hu.mobsoftlab.ui.UIModule;
import aut.bme.hu.mobsoftlab.ui.admin.AdminActivity;
import aut.bme.hu.mobsoftlab.ui.admin.AdminPresenter;
import aut.bme.hu.mobsoftlab.ui.details.DetailsActivity;
import aut.bme.hu.mobsoftlab.ui.details.DetailsPresenter;
import aut.bme.hu.mobsoftlab.ui.login.LoginActivity;
import aut.bme.hu.mobsoftlab.ui.login.LoginPresenter;
import aut.bme.hu.mobsoftlab.ui.main.MainActivity;
import aut.bme.hu.mobsoftlab.ui.main.MainPresenter;
import dagger.Component;


@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class, MockNetworkModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);
    void inject(AdminActivity adminActivity);
    void inject(DetailsActivity detailsActivity);
    void inject(MoviesInteractor moviesInteractor);
    void inject(UserInteractor userInteractor);
    void inject(MobSoftApplication mobSoftApplication);
    void inject(MainPresenter mainPresenter);
    void inject(LoginPresenter loginPresenter);
    void inject(DetailsPresenter detailsPresenter);
    void inject(AdminPresenter adminPresenter);
}
