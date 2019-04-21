package com.example.admin.cloudmusic.Launch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.cloudmusic.Login.LoginActivity;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("UniqueID", "LaunchActivity");
        startActivity(intent);
        finish();
    }
}
