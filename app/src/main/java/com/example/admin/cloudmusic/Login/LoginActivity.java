package com.example.admin.cloudmusic.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.cloudmusic.Base.BaseActivity;
import com.example.admin.cloudmusic.Launch.LaunchActivity;
import com.example.admin.cloudmusic.Main.MainActivity;
import com.example.admin.cloudmusic.Data.LoginData;
import com.example.admin.cloudmusic.R;

public class LoginActivity extends BaseActivity implements LoginContact.View {
    private EditText editText1;
    private EditText editText2;
    private Button button;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private boolean box1;
    private boolean box2;
    private String phoneNum;
    private String password;
    private LoginPresenter loginPresenter = new LoginPresenter(this);
    private final String NULL_PHONE = "Your phone number can't be Null.";
    private final String NULL_PASSWORD = "Your password can't be Null.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLayout(R.layout.activity_login);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        editText1 = findViewById(R.id.login_et1);
        editText2 = findViewById(R.id.login_et2);
        button = findViewById(R.id.login_b);
        checkBox1 = findViewById(R.id.login_cb1);
        checkBox2 = findViewById(R.id.login_cb2);
        setBoxListener();
        getMessage();
        setButtonListener();
    }

    @Override
    public void setBoxListener() {
        checkBox1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = getSharedPreferences("login", 0).edit();
            box1 = isChecked;
            editor.putBoolean("box1", box1);
            if (isChecked) {
                checkBox2.setClickable(true);
            } else {
                editor.remove("password");
                editor.remove("userName");
                editor.remove("id");
                editor.remove("avatar");
                editor.remove("nickName");
                checkBox2.setClickable(false);
                checkBox2.setChecked(false);
                editor.putBoolean("box2", box2);
            }
            editor.apply();
        });
        checkBox2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = getSharedPreferences("login", 0).edit();
            box2 = isChecked;
            editor.putBoolean("box2", box2);
            editor.apply();
        });
    }

    @Override
    public void setButtonListener() {
        button.setOnClickListener(v -> {
            phoneNum = editText1.getText().toString();
            password = editText2.getText().toString();
            if (phoneNum.equals("")) {
                Toast.makeText(this, NULL_PHONE, Toast.LENGTH_SHORT).show();
            } else if (password.equals("")) {
                Toast.makeText(this, NULL_PASSWORD, Toast.LENGTH_SHORT).show();
            } else {
                loginPresenter.login(phoneNum, password);
            }
        });
    }

    @Override
    public void saveMessage(int Code) {
        SharedPreferences.Editor editor = getSharedPreferences("login", 0).edit();
        if (Code == 200 || Code == 502 || Code == 509) {
            editor.putString("phone", phoneNum);
        }
        if (box1 && Code == 200) {
            editor.putString("password", password);
        }
        editor.apply();
    }

    @Override
    public void getMessage() {
        SharedPreferences sharedPreferences = getSharedPreferences("login", 0);
        box1 = sharedPreferences.getBoolean("box1", false);
        box2 = sharedPreferences.getBoolean("box2", false);
        phoneNum = sharedPreferences.getString("phone", null);
        editText1.setText(phoneNum);
        if (box1) {
            checkBox1.setChecked(true);
            password = sharedPreferences.getString("password", null);
            editText2.setText(password);
        }
        if (box2) {
            checkBox2.setChecked(true);
            if (getCallClass().equals(LaunchActivity.class.getName())) {
                loginPresenter.login(phoneNum, password);
            } else if (getCallClass().equals(MainActivity.class.getName())) {
                Toast.makeText(this, "Log out successfully.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void startMain(LoginData loginData) {
        Intent intent = getIntent(this, MainActivity.class);
        intent.putExtra("userName", loginData.getAccount().getUserName());
        intent.putExtra("id", loginData.getAccount().getId());
        intent.putExtra("avatar", loginData.getProfile().getAvatarUrl());
        intent.putExtra("nickName", loginData.getProfile().getNickname());
        startActivity(intent);
        finish();
    }

    @Override
    public void startMain(String userName, String id, String avatar, String nickName) {
        Intent intent = getIntent(this, MainActivity.class);
        intent.putExtra("userName", userName);
        intent.putExtra("id", id);
        intent.putExtra("avatar", avatar);
        intent.putExtra("nickName", nickName);
        startActivity(intent);
        finish();
    }
}
