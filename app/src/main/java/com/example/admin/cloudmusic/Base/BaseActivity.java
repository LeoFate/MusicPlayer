package com.example.admin.cloudmusic.Base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    int layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout);
        initView();
    }

    public abstract void initView();

    public void setLayout(int layout) {
        this.layout = layout;
    }


}

