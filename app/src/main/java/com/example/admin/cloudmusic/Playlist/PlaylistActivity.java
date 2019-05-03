package com.example.admin.cloudmusic.Playlist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.cloudmusic.Base.BaseActivity;
import com.example.admin.cloudmusic.Data.PlaylistDetailData;
import com.example.admin.cloudmusic.R;

public class PlaylistActivity extends BaseActivity implements PlaylistContact.View {
    String id;
    RecyclerView recyclerView;
    PlaylistPresenter playlistPresenter = new PlaylistPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayout(R.layout.activity_playlist);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        assert getIntent().getExtras() != null;
        id = getIntent().getExtras().getString("id");
        recyclerView = findViewById(R.id.playlist_recyclerView);
        playlistPresenter.getData(id);
    }

    @Override
    public void initRV(PlaylistDetailData playlistDetailData) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PlaylistDetailAdapter(this, playlistDetailData));
    }
}
