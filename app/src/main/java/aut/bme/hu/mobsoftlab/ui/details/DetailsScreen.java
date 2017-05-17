package aut.bme.hu.mobsoftlab.ui.details;

import java.util.List;

import aut.bme.hu.mobsoftlab.model.Movie;
import aut.bme.hu.mobsoftlab.model.Rating;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface DetailsScreen {
    void showModel(Movie model);
    void showRating(List<Rating> ratings);
    void showActorList(List<String> actors);
    void navigateToMain();
    void navigateBack();
    void showError(String error);
}
