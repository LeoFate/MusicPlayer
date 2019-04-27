package com.example.admin.cloudmusic.Main;

import com.example.admin.cloudmusic.Data.PlayListData;
import com.example.admin.cloudmusic.Data.SubcountData;

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
        MineAdapter initRv(SubcountData subcountData, PlayListData playListData);
    }

    interface MinePresenter {
        void getData(String uid);
    }

    interface MineAdapter {

    }
}
