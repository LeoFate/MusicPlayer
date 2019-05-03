package com.example.admin.cloudmusic.Main;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.admin.cloudmusic.Base.BaseActivity;
import com.example.admin.cloudmusic.Base.BaseIntent;
import com.example.admin.cloudmusic.Login.LoginActivity;
import com.example.admin.cloudmusic.R;

import java.util.ArrayList;
import java.util.List;

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
    ActionBarDrawerToggle mToggle;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        viewPager = findViewById(R.id.main_viewPager);
        getLoginMessage();
        initToolBar();
        initDrawer(mAvatar, mNickName);
        initViewPager(id);
    }

    @Override
    public void getLoginMessage() {
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        if (callClass.equals(LoginActivity.class.getName())) {
            Toast.makeText(this, "Login successfully.", Toast.LENGTH_SHORT).show();
            userName = bundle.getString("userName");
            id = bundle.getString("id");
            mAvatar = bundle.getString("avatar");
            mNickName = bundle.getString("nickName");
        }
    }

    @Override
    public void initToolBar() {
        setSupportActionBar(mToolBar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public void initDrawer(String avatar, String nickName) {
        Glide.with(this)
                .load(avatar)
                .into(this.avatar);
        this.nickName.setText(nickName);
        logout.setOnClickListener(v -> {
            startActivity(BaseIntent.get(this, LoginActivity.class));
            finish();
        });
        mToggle = new ActionBarDrawerToggle(this, mDrawer, mToolBar, R.string.drawer_open, R.string.drawer_close);
        mToggle.setDrawerArrowDrawable(new DrawerArrowDrawable(this));
        mDrawer.setDrawerListener(mToggle);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void initViewPager(String uid) {
        List<Fragment> fragmentList = new ArrayList<>();
        MineFragment mineFragment = new MineFragment();
        Bundle bundle = new Bundle();
        bundle.putString("uid", uid);
        mineFragment.setArguments(bundle);
        fragmentList.add(mineFragment);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragmentList));
    }
}
