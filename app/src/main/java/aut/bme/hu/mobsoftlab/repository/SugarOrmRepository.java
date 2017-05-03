package aut.bme.hu.mobsoftlab.repository;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import aut.bme.hu.mobsoftlab.model.Movie;
import aut.bme.hu.mobsoftlab.model.Profile;
import aut.bme.hu.mobsoftlab.model.Rating;


public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Movie> getMovies() {
        return SugarRecord.listAll(Movie.class);
    }

    @Override
    public void addMovie(Movie movie) {
        SugarRecord.saveInTx(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        SugarRecord.deleteInTx(movie);
    }

    @Override
    public void rateMovie(Rating rating) {
        SugarRecord.saveInTx(rating);
    }

    @Override
    public boolean loginUser(Profile profile) {
        Profile prof = SugarRecord.findById(Profile.class, profile.getId());
        if(prof.getEmail() == profile.getEmail() && prof.getPassword() == profile.getPassword()){
            return true;
        }
        return false;
    }

    @Override
    public Movie getMovie(Long id) {
        return SugarRecord.findById(Movie.class, id);
    }

    @Override
    public List<Rating> getRatingForMovie(Movie movie) {
        List<Rating> ratings = SugarRecord.listAll(Rating.class);
        List<Rating> ratingsForMovie = new ArrayList<>();
        for(int i=0; i<ratings.size(); i++){
            if(ratings.get(i).getMovie_id() == movie.getId()){
                ratingsForMovie.add(ratings.get(i));
            }
        }
        return ratingsForMovie;
    }


}
