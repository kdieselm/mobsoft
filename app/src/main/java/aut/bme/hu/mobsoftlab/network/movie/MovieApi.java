package aut.bme.hu.mobsoftlab.network.movie;

import aut.bme.hu.mobsoftlab.model.Credentials;
import aut.bme.hu.mobsoftlab.model.DeleteMovie;
import aut.bme.hu.mobsoftlab.model.LoggedInProfile;
import aut.bme.hu.mobsoftlab.model.Movie;
import aut.bme.hu.mobsoftlab.model.NewMovie;
import aut.bme.hu.mobsoftlab.model.Rating;
import aut.bme.hu.mobsoftlab.model.Success;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MovieApi {

    /**
     * Mozifilm feltöltése
     * A belépést követően feltölthet egy új filmet.
     * @param body
     * @param token Belépés után kapott azonosító token
     * @return Call<Movie>
     */

    @POST("movies/add")
    Call<Movie> moviesAddPost(
            @Body NewMovie body, @Header("token") String token
    );


    /**
     * Mozifilm törlése
     * A belépést követően töröl egy filmet.
     * @param body
     * @param token Belépés után kapott azonosító token
     * @return Call<Success>
     */

    @POST("movies/delete")
    Call<Success> moviesDeletePost(
            @Body DeleteMovie body, @Header("token") String token
    );


    /**
     * Mozifilmek listázása
     * A belépést követően kilistázza az összes filmet.
     * @param token Belépés után kapott azonosító token
     * @return Call<List<Movie>>
     */

    @GET("movies/get")
    Call<List<Movie>> moviesGetGet(
            @Header("token") String token
    );


    /**
     * Film keresése ID alapján
     * -..
     * @param movieId Mozi ID
     * @return Call<Movie>
     */

    @GET("movies/get/{movieId}")
    Call<Movie> moviesGetMovieIdGet(
            @Path("movieId") Long movieId
    );


    /**
     * Mozifilm értékelése
     * A belépést követően értékelhet filmet.
     * @param body
     * @param token Belépés után kapott azonosító token
     * @return Call<Success>
     */

    @POST("movies/rate")
    Call<Success> moviesRatePost(
            @Body Rating body, @Header("token") String token
    );


    /**
     * Film értékelésének keresése
     * -..
     * @param movieId Mozi ID
     * @return Call<Rating>
     */

    @GET("movies/rate/{movieId}")
    Call<Rating> moviesRateMovieIdGet(
            @Path("movieId") Long movieId
    );


    /**
     * Bejelentkezés
     * Az alkalmazás elindítása után a felhasználónak be kell jelentkeznie egy telefonszámmal és jelszóval.
     * @param body
     * @return Call<LoggedInProfile>
     */

    @POST("user/login")
    Call<LoggedInProfile> userLoginPost(
            @Body Credentials body
    );


}
