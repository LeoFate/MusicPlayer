package com.example.admin.cloudmusic.Base;

import android.content.Context;
import android.content.Intent;

public class BaseIntent {
    private static final String KEY = "ClassName";

    public static Intent get(Context packageContext, Class<?> cls) {
        Intent intent = new Intent(packageContext, cls);
        intent.putExtra(KEY, packageContext.getClass().getName());
        return intent;
    }

    static String getCallClass(Intent intent) {
        return intent.getStringExtra(KEY);
    }
}
