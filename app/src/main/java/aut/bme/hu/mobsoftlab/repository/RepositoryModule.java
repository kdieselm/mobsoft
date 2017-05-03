package aut.bme.hu.mobsoftlab.repository;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    public Repository provideRepository() {
        return new SugarOrmRepository();
    }
}