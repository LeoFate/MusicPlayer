package com.example.admin.cloudmusic.Service;

import com.example.admin.cloudmusic.Data.PlaylistDetailData;

import retrofit2.Call;

public class PlaylistNetwork extends BasedNetwork {
    private Api.playlist playlist;
    private static PlaylistNetwork playlistNetwork;

    private PlaylistNetwork() {
        super();
        playlist = retrofit.create(Api.playlist.class);
    }

    public static PlaylistNetwork getInstance() {
        if (playlistNetwork == null) {
            playlistNetwork = new PlaylistNetwork();
        }
        return playlistNetwork;
    }

    public Call<PlaylistDetailData> getDetail(String id) {
        return playlist.getPlayListDetail(id);
    }
}
