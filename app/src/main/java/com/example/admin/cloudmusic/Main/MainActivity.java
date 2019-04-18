package com.example.admin.cloudmusic.Main;

import android.os.Bundle;
import android.util.Log;

import com.example.admin.cloudmusic.Base.BaseActivity;
import com.example.admin.cloudmusic.R;


public class MainActivity extends BaseActivity implements MainContact.View{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayout(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getBundleExtra("bundle");
        Log.e("Main", bundle.getString("id"));
    }

    @Override
    public void initView() {
    }
}
