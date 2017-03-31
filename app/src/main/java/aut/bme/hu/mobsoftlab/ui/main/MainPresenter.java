package aut.bme.hu.mobsoftlab.ui.main;

import aut.bme.hu.mobsoftlab.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class MainPresenter extends Presenter<MainScreen> {

    private static MainPresenter instance = null;

    private MainPresenter() {
    }

    public static MainPresenter getInstance() {
        if (instance == null) {
            instance = new MainPresenter();
        }
        return instance;
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
