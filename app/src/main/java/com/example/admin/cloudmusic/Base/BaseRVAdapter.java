package com.example.admin.cloudmusic.Base;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

public abstract class BaseRVAdapter extends RecyclerView.Adapter {
    private Context context;
    private final String KEY = "ClassName";

    public BaseRVAdapter(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public Intent getIntent(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        intent.putExtra(KEY, getClass().getName());
        return intent;
    }
}
