package com.example.admin.cloudmusic.Base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    int layout;
    String className = getClass().getName();
    String callClass;
    public final String KEY = "ClassName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getIntent().getExtras() != null && getIntent().getExtras().getString(KEY) != null) {
            callClass = getIntent().getExtras().getString(KEY);
        }
        super.onCreate(savedInstanceState);
        if (layout != 0) {
            setContentView(layout);
        }
        initView();
    }

    public abstract void initView();

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public String getClassName() {
        return className;
    }

    public String getCallClass() {
        return callClass;
    }

    public Intent getIntent(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        intent.putExtra(KEY, getClassName());
        return intent;
    }
}

