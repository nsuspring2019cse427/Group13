package com.example.client.Utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkManagerInstance {
    private static final String BASE_URL = "http://10.0.2.2:4001";

    static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(300, TimeUnit.SECONDS)
            .connectTimeout(300, TimeUnit.SECONDS)
            .build();

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        okHttpClient.dispatcher().setMaxRequestsPerHost(80);
        okHttpClient.dispatcher().setMaxRequests(100);
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
