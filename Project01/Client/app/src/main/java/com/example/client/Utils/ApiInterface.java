package com.example.client.Utils;


import com.example.client.User;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {
    String CONTENT_TYPE = "Content-Type: application/json";
    String ACCEPT = "Accept: application/json";

    @Headers({CONTENT_TYPE, ACCEPT})
    @POST("/public/signUp")
    retrofit2.Call<User> saveUser(@Body User body);


}
