package aut.bme.hu.mobsoftlab.interactor;

import aut.bme.hu.mobsoftlab.interactor.movie.MoviesInteractor;
import aut.bme.hu.mobsoftlab.interactor.user.UserInteractor;
import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {


    @Provides
    public MoviesInteractor provideMovies() {
        return new MoviesInteractor();
    }

    @Provides
    public UserInteractor provideUsers() {
        return new UserInteractor();
    }


}