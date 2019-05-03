package com.example.admin.cloudmusic.Playlist;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.cloudmusic.Data.PlaylistDetailData;
import com.example.admin.cloudmusic.Service.PlaylistNetwork;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class PlaylistPresenter implements PlaylistContact.Presenter {
    private PlaylistContact.View view;

    PlaylistPresenter(PlaylistContact.View view) {
        this.view = view;
    }

    void getData(String id) {
        PlaylistNetwork.getInstance().getDetail(id).enqueue(new Callback<PlaylistDetailData>() {
            @Override
            public void onResponse(@NonNull Call<PlaylistDetailData> call, @NonNull Response<PlaylistDetailData> response) {
                view.initRV(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<PlaylistDetailData> call, @NonNull Throwable t) {
                Toast.makeText((Activity) view, "Network Failure.", Toast.LENGTH_SHORT).show();
                Log.e(getClass().getName(), "Fail to get playlist", t);
            }
        });
    }
}
