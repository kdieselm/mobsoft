package aut.bme.hu.mobsoftlab.ui.details;

import java.util.List;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface DetailsScreen {
    void showModel(String model);
    void showRating(int rating);
    void showActorList(List<String> actors);
}
