package aut.bme.hu.mobsoftlab.mock.interceptor;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;

import javax.inject.Singleton;

import aut.bme.hu.mobsoftlab.mock.MockHttpServer;
import aut.bme.hu.mobsoftlab.network.NetworkConfig;
import aut.bme.hu.mobsoftlab.network.NetworkModule;
import aut.bme.hu.mobsoftlab.network.movie.MovieApi;
import dagger.Provides;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

import static aut.bme.hu.mobsoftlab.mock.interceptor.MockHelper.makeResponse;

/**
 * Created by mobsoft on 2017. 05. 12..
 */

public class MockInterceptor implements Interceptor{
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        return process(chain.request());
    }

    public Response process(Request request) {

        Uri uri = Uri.parse(request.url().toString());

        Log.d("Test Http Client", "URL call: " + uri.toString());
        Headers headers = request.headers();


        if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "movie")) {
            return MovieMock.process(request);
        }

        return makeResponse(request, headers, 404, "Unknown");

    }
}
