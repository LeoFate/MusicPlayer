package com.example.admin.cloudmusic.Service;

import com.example.admin.cloudmusic.Data.LoginData;
import com.example.admin.cloudmusic.Data.PlaylistData;
import com.example.admin.cloudmusic.Data.PlaylistDetailData;

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
        Call<PlaylistData> getPlayList(@Query("uid") String uid);
    }

    interface playlist {
        @GET("/playlist/detail")
        Call<PlaylistDetailData> getPlayListDetail(@Query("id") String id);
    }
}
