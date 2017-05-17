package aut.bme.hu.mobsoftlab.ui.admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import aut.bme.hu.mobsoftlab.MobSoftApplication;
import aut.bme.hu.mobsoftlab.R;
import aut.bme.hu.mobsoftlab.model.Movie;
import aut.bme.hu.mobsoftlab.ui.main.MainActivity;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class AdminActivity extends AppCompatActivity implements AdminScreen {

    @Inject
    AdminPresenter adminPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adminPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        adminPresenter.detachScreen();
    }

    @Override
    public void showModel(String model) {

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void addMovieClicked(View view){
        EditText title = (EditText)findViewById(R.id.title);
        EditText genre = (EditText)findViewById(R.id.genre);
        EditText year = (EditText)findViewById(R.id.year);
        EditText actors = (EditText)findViewById(R.id.actors);
        EditText director = (EditText)findViewById(R.id.director);

        ArrayList<String> actorsList = new ArrayList<String>();
        actorsList.add(actors.getText().toString());

        Movie movie = new Movie();
        movie.setDirector(director.getText().toString());
        movie.setGenre(genre.getText().toString());
        movie.setTitle(title.getText().toString());
        movie.setActors(actorsList);
        movie.setYear(Integer.parseInt(year.getText().toString()));

        adminPresenter.addMovie(movie);
    }
}
