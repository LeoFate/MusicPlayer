package com.example.admin.cloudmusic.Main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.cloudmusic.Base.BaseFragment;
import com.example.admin.cloudmusic.Data.PlaylistData;
import com.example.admin.cloudmusic.R;

public class MineFragment extends BaseFragment implements MainContact.MineFragment {
    RecyclerView recyclerView;
    MinePresenter presenter = new MinePresenter(this);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setLayout(R.layout.fragment_mine);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.mine_RecyclerView);
        assert getArguments() != null;
        presenter.getData(getArguments().getString("uid"));
    }

    @Override
    public void initRv(PlaylistData playlistData) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MineAdapter(getContext(), playlistData));
    }
}
