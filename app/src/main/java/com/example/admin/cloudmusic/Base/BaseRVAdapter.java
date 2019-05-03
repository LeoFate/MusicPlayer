package com.example.admin.cloudmusic.Base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

public abstract class BaseRVAdapter extends RecyclerView.Adapter {
    protected Context context;
    protected LayoutInflater layoutInflater;

    public BaseRVAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
}
