package com.example.roomdatabasedemo.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "http://www.codingwithjks.tech/";
    //private static final String BASE_URL = "http://newambs.ambitioussoftwares.com/";
    private static RetrofitClient retrofitClient;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //.client(okHttpClient)
                .build();
    }
    public static synchronized RetrofitClient getInstance() {
        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }
}
