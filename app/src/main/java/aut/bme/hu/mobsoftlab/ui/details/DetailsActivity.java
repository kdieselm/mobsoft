package aut.bme.hu.mobsoftlab.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import aut.bme.hu.mobsoftlab.MobSoftApplication;
import aut.bme.hu.mobsoftlab.R;
import aut.bme.hu.mobsoftlab.model.Movie;
import aut.bme.hu.mobsoftlab.model.Profile;
import aut.bme.hu.mobsoftlab.model.Rating;
import aut.bme.hu.mobsoftlab.ui.login.LoginActivity;
import aut.bme.hu.mobsoftlab.ui.main.MainActivity;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {

    @Inject
    DetailsPresenter detailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailsPresenter.attachScreen(this);
        Integer id = getIntent().getExtras().getInt("id");
        detailsPresenter.movieDetails(id.longValue());
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailsPresenter.detachScreen();
    }

    public void navigateClicked(View view){
        navigateToMain();
    }

    public void rateClicked(View view){
        Rating rating = new Rating();
        Integer id = getIntent().getExtras().getInt("id");
        rating.setMovie_id(id.longValue());
        RatingBar bar = (RatingBar) findViewById(R.id.ratingBar);
        rating.setRating((int)bar.getRating());
        detailsPresenter.rateMovie(rating);
    }

    @Override
    public void showModel(Movie model) {
        TextView title = (TextView)findViewById(R.id.detTitle);
        TextView genre = (TextView)findViewById(R.id.detGenre);
        TextView year = (TextView)findViewById(R.id.detYear);
        TextView director = (TextView)findViewById(R.id.detDir);
        //TextView actor = (TextView)findViewById(R.id.detAct);
        title.setText(model.getTitle());
        genre.setText(model.getGenre());
        year.setText(Integer.toString(model.getYear()));
        director.setText(model.getDirector());
        //actor.setText(model.getActors().get(0));
        detailsPresenter.allMovieRatings(model);
    }

    @Override
    public void showRating(List<Rating> ratings) {
        if(ratings.size() == 0){
            TextView rating = (TextView)findViewById(R.id.detRating);
            rating.setText(0);
        }
        System.out.println("SIZEEEEEEEEEEEEEEEE" + ratings.size());
        float count = 0;
        if(ratings.size() > 0) {
            for (int i = 0; i < ratings.size(); i++) {
                count += ratings.get(i).getRating();
            }
            count = count / ratings.size();
        }

        TextView rating = (TextView)findViewById(R.id.detRating);
        rating.setText(Float.toString(count));
    }

    @Override
    public void showActorList(List<String> actors) {
    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void navigateBack() {
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("id", getIntent().getExtras().getInt("id"));
        startActivity(intent);
        finish();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
