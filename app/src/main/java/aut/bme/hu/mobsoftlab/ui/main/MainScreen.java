package aut.bme.hu.mobsoftlab.ui.main;

import java.util.List;

import aut.bme.hu.mobsoftlab.model.Movie;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface MainScreen {
    void showMessage(String text);
    void showList(List<Movie> movies);
    void navigateToAdmin();
}