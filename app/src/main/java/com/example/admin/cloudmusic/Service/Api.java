package com.example.admin.cloudmusic.Service;

import com.example.admin.cloudmusic.Data.LoginData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    interface Login {
        @GET("/login/cellphone")
        Call<LoginData> login(@Query("phone") String phone, @Query("password") String password);
    }
}
