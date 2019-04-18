package com.example.admin.cloudmusic.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class BasedNetwork {
    private static final String BASE_URL = "http://192.168.43.10:3000";
    static Retrofit retrofit;

    BasedNetwork() {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }
}
