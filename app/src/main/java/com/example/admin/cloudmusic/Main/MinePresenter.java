package com.example.admin.cloudmusic.Main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.cloudmusic.Data.PlayListData;
import com.example.admin.cloudmusic.Data.SubcountData;
import com.example.admin.cloudmusic.Service.MainNetwork;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MinePresenter implements MainContact.MinePresenter {
    private MainContact.MineFragment fragment;
    private SubcountData subcountData;
    private PlayListData playListData;

    public MinePresenter(MainContact.MineFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void getData(String uid) {
        Fragment fragment = (Fragment) this.fragment;
        Context context = fragment.getContext();
        MainNetwork.getInstance().getSubCount().enqueue(new Callback<SubcountData>() {
            @Override
            public void onResponse(@NonNull Call<SubcountData> call, @NonNull Response<SubcountData> response) {
                subcountData = response.body();
            }

            @Override
            public void onFailure(@NonNull Call<SubcountData> call, @NonNull Throwable t) {
                Toast.makeText(context, "Network Failure.", Toast.LENGTH_SHORT).show();
                Log.e(getClass().getName(), "Fail to get subcount", t);
            }
        });
        MainNetwork.getInstance().getPlayList(uid).enqueue(new Callback<PlayListData>() {
            @Override
            public void onResponse(@NonNull Call<PlayListData> call, @NonNull Response<PlayListData> response) {
                playListData = response.body();
            }

            @Override
            public void onFailure(@NonNull Call<PlayListData> call, @NonNull Throwable t) {
                Toast.makeText(context, "Network Failure.", Toast.LENGTH_SHORT).show();
                Log.e(getClass().getName(), "Fail to get playlist", t);
            }
        });
        this.fragment.initRv(subcountData, playListData);
    }
}
