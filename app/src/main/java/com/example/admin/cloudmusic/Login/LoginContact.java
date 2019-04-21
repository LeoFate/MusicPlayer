package com.example.admin.cloudmusic.Login;

import com.example.admin.cloudmusic.Data.LoginData;

public interface LoginContact {
    interface View {
        void setUniqueID();
        void setBoxListener();
        void setButtonListener();
        void saveMessage(int Code);
        void getMessage();
        void startMain(LoginData loginData);
        void startMain(String userName, String id, String avatar, String nickName);
    }

    interface Presenter {
        void login(String phone, String password);
    }
}
