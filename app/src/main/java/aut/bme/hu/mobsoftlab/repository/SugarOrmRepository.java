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
        long users = SugarRecord.count(Profile.class);
        System.out.println("USERS!" + users);
        if(users != 1) {

            Profile prof = new Profile();
            prof.setPassword("admin");
            prof.setId(1L);
            prof.setEmail("email@email.com");
            prof.setUserEmail("email@email.com");
            prof.setUserId(1);
            SugarRecord.saveInTx(prof);
        }

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
        long movieCount = SugarRecord.count(Movie.class);
        movie.setId((int)(movieCount+1));
        SugarRecord.saveInTx(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        SugarRecord.deleteInTx(movie);
    }

    @Override
    public void rateMovie(Rating rating) {
        List<Rating> ratings = SugarRecord.listAll(Rating.class);
        rating.setId((long) (ratings.size()+1));
        SugarRecord.saveInTx(rating);
    }

    @Override
    public boolean loginUser(Profile profile) {
        List<Profile> profiles = SugarRecord.listAll(Profile.class);
        for(int i=0; i<profiles.size(); i++){
            if(profiles.get(i).getEmail().equals(profile.getEmail())){
                if(profiles.get(i).getPassword().equals(profile.getPassword()))
                return true;
            }
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
            System.out.println("getid:" + movie.getId() + " getmovieid:" + movie.getMovieId() + " ratingsgetmovieid:" + ratings.get(i).getMovieId() + " ratingsgetmovie_id:" + ratings.get(i).getMovie_id());
            if(ratings.get(i).getMovie_id() == movie.getMovieId()){
                ratingsForMovie.add(ratings.get(i));
                System.out.println("added");
            }
        }
        return ratingsForMovie;
    }


}
