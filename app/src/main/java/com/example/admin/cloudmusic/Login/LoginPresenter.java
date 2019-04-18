package com.example.admin.cloudmusic.Login;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.cloudmusic.Data.LoginData;
import com.example.admin.cloudmusic.Service.LoginNetwork;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContact.Presenter {
    private LoginContact.View loginView;
    private final String TAG = getClass().getName();
    //    private final String CODE_200 = "Code 200: Login successfully.";
    private final String CODE_400 = "Code 400: Invalid phone number.";
    private final String CODE_415 = "Code 415: ip high frequency.";
    private final String CODE_501 = "Code 501: Invalid user name.";
    private final String CODE_502 = "Code 502: Incorrect password.";
    private final String CODE_509 = "Code 509: Too many incorrect password.";
    private final String OTHER_ERROR = "Unknown mistake occurred.";

    LoginPresenter(LoginContact.View loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(String phone, String password) {
        LoginNetwork.getInstance().loginCall(phone, password).enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(@NonNull Call<LoginData> call, @NonNull Response<LoginData> response) {
                int code = response.body() != null ? response.body().getCode() : 0;
                loginView.saveMessage(code);
                if (code == 200) {
                    loginView.startMain(response.body());
                } else if (code == 400) {
                    Toast.makeText((Context) loginView, CODE_400, Toast.LENGTH_SHORT).show();
                } else if (code == 415) {
                    Toast.makeText((Context) loginView, CODE_415, Toast.LENGTH_SHORT).show();
                } else if (code == 501) {
                    Toast.makeText((Context) loginView, CODE_501, Toast.LENGTH_SHORT).show();
                } else if (code == 502) {
                    Toast.makeText((Context) loginView, CODE_502, Toast.LENGTH_SHORT).show();
                } else if (code == 509) {
                    Toast.makeText((Context) loginView, CODE_509, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText((Context) loginView, OTHER_ERROR, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginData> call, @NonNull Throwable t) {
                Log.e(TAG, "Login network failure", t);
            }
        });
    }
}
