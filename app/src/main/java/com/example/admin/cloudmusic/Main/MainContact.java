package com.example.admin.cloudmusic.Main;

import com.example.admin.cloudmusic.Data.PlayListData;

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
        void initRv(PlayListData playListData);
    }

    interface MinePresenter {
        void getData(String uid);
    }

    interface MineAdapter {

    }
}
