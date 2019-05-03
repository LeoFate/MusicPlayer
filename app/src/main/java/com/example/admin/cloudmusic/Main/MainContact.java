package com.example.admin.cloudmusic.Main;

import com.example.admin.cloudmusic.Data.PlaylistData;

public interface MainContact {
    interface View {
        void getLoginMessage();
        void initDrawer(String avatar, String nickName);
        void initToolBar();
        void initViewPager(String uid);
    }

    interface Presenter {

    }

    interface MineFragment {
        void initRv(PlaylistData playlistData);
    }

    interface MinePresenter {
        void getData(String uid);
    }

    interface MineAdapter {

    }
}
