package aut.bme.hu.mobsoftlab.mock;

import aut.bme.hu.mobsoftlab.mock.interceptor.MockInterceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mobsoft on 2017. 05. 12..
 */

public class MockHttpServer {
    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }
}
