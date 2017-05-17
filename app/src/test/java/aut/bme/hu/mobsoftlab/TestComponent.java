package aut.bme.hu.mobsoftlab;

import javax.inject.Singleton;

import aut.bme.hu.mobsoftlab.interactor.InteractorModule;
import aut.bme.hu.mobsoftlab.mock.MockNetworkModule;
import aut.bme.hu.mobsoftlab.network.NetworkModule;
import aut.bme.hu.mobsoftlab.repository.TestRepositoryModule;
import aut.bme.hu.mobsoftlab.ui.UIModule;
import dagger.Component;

/**
 * Created by mobsoft on 2017. 05. 12..
 */

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}