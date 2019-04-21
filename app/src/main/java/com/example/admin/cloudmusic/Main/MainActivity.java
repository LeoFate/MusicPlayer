package com.example.admin.cloudmusic.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.cloudmusic.Base.BaseActivity;
import com.example.admin.cloudmusic.Login.LoginActivity;
import com.example.admin.cloudmusic.R;

public class MainActivity extends BaseActivity implements MainContact.View {
    DrawerLayout mDrawer;
    Toolbar mToolBar;
    ImageView avatar;
    TextView nickName;
    TextView logout;
    String userName;
    String id;
    String mAvatar;
    String mNickName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getLoginMessage();
        setLayout(R.layout.activity_main);
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void initView() {
        mDrawer = findViewById(R.id.main_drawer);
        mToolBar = findViewById(R.id.main_toolBar);
        avatar = findViewById(R.id.avatar);
        nickName = findViewById(R.id.nick_name);
        logout = findViewById(R.id.logout);
        initDrawer(mAvatar, mNickName);
        initToolBar();
    }

    @Override
    public void getLoginMessage() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            userName = bundle.getString("userName");
            id = bundle.getString("id");
            mAvatar = bundle.getString("avatar");
            mNickName = bundle.getString("nickName");
        }
    }

    @Override
    public void initDrawer(String avatar, String nickName) {
        Glide.with(this)
                .load(avatar)
                .into(this.avatar);
        this.nickName.setText(nickName);
        logout.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("UniqueID", "MainActivity");
            startActivity(intent);
        });
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(mToolBar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
