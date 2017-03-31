package aut.bme.hu.mobsoftlab.ui.main;

import java.util.List;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface MainScreen {
    void showMessage(String text);
    void showList(List<String> movies);
}