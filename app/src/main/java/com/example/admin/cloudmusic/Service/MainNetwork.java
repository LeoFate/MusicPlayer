package com.example.admin.cloudmusic.Service;

import com.example.admin.cloudmusic.Data.PlayListData;
import com.example.admin.cloudmusic.Data.SubcountData;

import retrofit2.Call;

public class MainNetwork extends BasedNetwork {
    private Api.Main main;
    private static MainNetwork mainNetwork;

    private MainNetwork() {
        super();
        main = retrofit.create(Api.Main.class);
    }

    public static MainNetwork getInstance() {
        if (mainNetwork == null) {
            mainNetwork = new MainNetwork();
        }
        return mainNetwork;
    }

    public Call<SubcountData> getSubCount() {
        return main.getSubCount();
    }

    public Call<PlayListData> getPlayList(String uid) {
        return main.getPlayList(uid);
    }
}
