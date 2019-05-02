package com.example.admin.cloudmusic.Service;

import com.example.admin.cloudmusic.Data.LoginData;
import com.example.admin.cloudmusic.Data.PlayListData;
import com.example.admin.cloudmusic.Data.PlayListDetailData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    interface Login {
        @GET("/login/cellphone")
        Call<LoginData> login(@Query("phone") String phone, @Query("password") String password);
    }

    interface Main {
        @GET("/user/playlist")
        Call<PlayListData> getPlayList(@Query("uid") String uid);
    }

    interface PlayList {
        @GET("/playlist/detail")
        Call<PlayListDetailData> getPlayListDetail(@Query("id") String id);
    }
}
