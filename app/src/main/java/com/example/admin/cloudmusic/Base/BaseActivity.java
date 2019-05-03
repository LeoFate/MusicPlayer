package com.example.admin.cloudmusic.Base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    private int layout = -1;
    protected String callClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layout != -1) {
            callClass = BaseIntent.getCallClass(getIntent());
            setContentView(layout);
        }
        initView();
    }

    public abstract void initView();

    public void setLayout(int layout) {
        this.layout = layout;
    }
}

