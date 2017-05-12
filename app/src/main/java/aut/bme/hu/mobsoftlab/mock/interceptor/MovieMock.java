package aut.bme.hu.mobsoftlab.mock.interceptor;

import android.net.Uri;

import aut.bme.hu.mobsoftlab.network.NetworkConfig;
import aut.bme.hu.mobsoftlab.repository.MemoryRepository;
import aut.bme.hu.mobsoftlab.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static aut.bme.hu.mobsoftlab.mock.interceptor.MockHelper.makeResponse;

/**
 * Created by mobsoft on 2017. 05. 12..
 */

public class MovieMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "movies") && request.method().equals("POST")) {
            responseString = "";
            responseCode = 200;

            /**
             * Simple Get Example
             */

		}else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "movies") && request.method().equals("Get")) {
			MemoryRepository memoryRepository = new MemoryRepository();
			memoryRepository.open(null);
			responseString = GsonHelper.getGson().toJson(memoryRepository.getMovies());
			responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
