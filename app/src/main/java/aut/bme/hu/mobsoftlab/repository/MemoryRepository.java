package aut.bme.hu.mobsoftlab.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import aut.bme.hu.mobsoftlab.model.Movie;
import aut.bme.hu.mobsoftlab.model.Profile;
import aut.bme.hu.mobsoftlab.model.Rating;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class MemoryRepository implements Repository {

    private static final long MINUTE = 60 * 1000;

    public static List<Movie> movies;
    public static List<Rating> ratings;
    public static List<Profile> profiles;


    @Override
    public void open(Context context) {
        Movie flight1 = new Movie(1L, "movie1", 2016, "director1", "genre1", new ArrayList<String>() {{
            add("A");
            add("B");
            add("C");
        }}, "noimage");
        Movie flight2 = new Movie(2L,"movie2", 2017, "director2", "genre2", new ArrayList<String>() {{
            add("A");
            add("B");
            add("C");
        }}, "noimage");

        movies = new ArrayList<>();
        movies.add(flight1);
        movies.add(flight2);

        Profile profile1 = new Profile(1L, "email@email.com", "pass");
        profiles = new ArrayList<>();
        profiles.add(profile1);

        Rating rating1 = new Rating(1L,1L,1L,1);
        ratings = new ArrayList<>();
        ratings.add(rating1);
    }

    @Override
    public void close() {

    }

    @Override
    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        movies.remove(movie);
    }

    @Override
    public void rateMovie(Rating rating) {
        ratings.add(rating);
    }

    @Override
    public boolean loginUser(Profile profile) {
        for(int i=0; i<profiles.size(); i++){
            if(profiles.get(i).getEmail() == profile.getUserEmail()){
                return true;
            }
        }
        return false;
    }

    @Override
    public Movie getMovie(Long id) {
        for(int i=0; i<movies.size(); i++){
            if(movies.get(i).getId() == Integer.parseInt(id.toString())){
                return movies.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Rating> getRatingForMovie(Movie movie) {
        List<Rating> ratingsForMovie = new ArrayList<>();
        for(int i=0; i<ratings.size(); i++){
            if(ratings.get(i).getMovie_id() == movie.getMovieId()){
                ratingsForMovie.add(ratings.get(i));
            }
        }
        return ratingsForMovie;
    }
}

