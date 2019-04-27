package com.example.admin.cloudmusic.Main;

public class MainPresenter implements MainContact.Presenter {
    MainContact.View view;

    public MainPresenter(MainContact.View view) {
        this.view = view;
    }
}
