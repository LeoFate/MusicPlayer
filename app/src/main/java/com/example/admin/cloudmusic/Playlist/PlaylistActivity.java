package com.example.admin.cloudmusic.Playlist;

import android.os.Bundle;

import com.example.admin.cloudmusic.Base.BaseActivity;
import com.example.admin.cloudmusic.R;

public class PlaylistActivity extends BaseActivity {
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayout(R.layout.activity_playlist);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        id = getIntent().getExtras().getString("id");
    }
}
