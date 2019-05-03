package com.example.admin.cloudmusic.Main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.cloudmusic.Data.PlaylistData;
import com.example.admin.cloudmusic.Service.MainNetwork;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MinePresenter implements MainContact.MinePresenter {
    private MainContact.MineFragment fragment;

    MinePresenter(MainContact.MineFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void getData(String uid) {
        Fragment frag = (Fragment) fragment;
        Context context = frag.getContext();
        MainNetwork.getInstance().getPlayList(uid).enqueue(new Callback<PlaylistData>() {
            @Override
            public void onResponse(@NonNull Call<PlaylistData> call, @NonNull Response<PlaylistData> response) {
                fragment.initRv(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<PlaylistData> call, @NonNull Throwable t) {
                Toast.makeText(context, "Network Failure.", Toast.LENGTH_SHORT).show();
                Log.e(getClass().getName(), "Fail to get playlist", t);
            }
        });
    }
}
