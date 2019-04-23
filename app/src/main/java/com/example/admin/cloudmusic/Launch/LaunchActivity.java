package com.example.admin.cloudmusic.Launch;

import android.content.Intent;
import android.os.Bundle;

import com.example.admin.cloudmusic.Base.BaseActivity;
import com.example.admin.cloudmusic.Login.LoginActivity;

public class LaunchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void initView() {
    }

}
