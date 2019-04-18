package com.example.admin.cloudmusic.Service;

import com.example.admin.cloudmusic.Data.LoginData;

import retrofit2.Call;

public class LoginNetwork extends BasedNetwork {
    private Api.Login login;
    private static LoginNetwork loginNetwork;

    private LoginNetwork() {
        super();
        login = retrofit.create(Api.Login.class);
    }

    public static LoginNetwork getInstance() {
        if (loginNetwork == null) {
            loginNetwork = new LoginNetwork();
        }
        return loginNetwork;
    }

    public Call<LoginData> loginCall(String phone, String password) {
        return login.login(phone, password);
    }
}
