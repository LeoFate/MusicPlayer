package com.example.admin.cloudmusic.Main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.cloudmusic.Base.BaseRVAdapter;
import com.example.admin.cloudmusic.Data.PlayListData;
import com.example.admin.cloudmusic.Playlist.PlaylistActivity;
import com.example.admin.cloudmusic.R;

import java.util.List;

public class MineAdapter extends BaseRVAdapter implements MainContact.MineAdapter {
    private final int CREATED_NAME_TYPE = 1;
    private final int SUBSCRIBED_NAME_TYPE = 2;
    private final int MAIN_TYPE = 3;
    private int createdPlaylistCount;
    private int subscribedPlayListCount;
    private List<PlayListData.PlaylistBean> playlistList;

    MineAdapter(Context context, PlayListData playListData) {
        super(context);
        createdPlaylistCount = 0;
        subscribedPlayListCount = 0;
        playlistList = playListData.getPlaylist();
        for (PlayListData.PlaylistBean p : playlistList) {
            if (p.isOrdered()) {
                subscribedPlayListCount++;
            } else {
                createdPlaylistCount++;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return CREATED_NAME_TYPE;
        else if (position == createdPlaylistCount + 1) return SUBSCRIBED_NAME_TYPE;
        else return MAIN_TYPE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case CREATED_NAME_TYPE:
                viewHolder = new NameHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_mine_name, viewGroup, false));
                break;
            case MAIN_TYPE:
                viewHolder = new MainHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_mine_main, viewGroup, false));
                break;
            case SUBSCRIBED_NAME_TYPE:
                viewHolder = new NameHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_mine_name, viewGroup, false));
                break;
        }
        assert viewHolder != null;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (getItemViewType(position)) {
            case CREATED_NAME_TYPE: {
                NameHolder nameHolder = (NameHolder) viewHolder;
                nameHolder.textView.setText("创建的歌单");
                break;
            }
            case MAIN_TYPE: {
                MainHolder mainHolder = (MainHolder) viewHolder;
                PlayListData.PlaylistBean playlistBean;
                String count;
                if (position <= createdPlaylistCount) {
                    playlistBean = playlistList.get(position - 1);
                    count = playlistBean.getTrackCount() + " 首";
                } else {
                    playlistBean = playlistList.get(position - 2);
                    count = playlistBean.getTrackCount() + " 首 by " + playlistBean.getCreator().getNickname();
                }
                Glide.with(getContext())
                        .load(playlistBean.getCoverImgUrl())
                        .into(mainHolder.coverImage);
                String name = playlistBean.getName();
                if (position == 1) {
                    name = name.replace(name.substring(0, name.length() - 5), "我");
                }
                mainHolder.title.setText(name);
                mainHolder.count.setText(count);
                mainHolder.itemView.setOnClickListener(v -> {
                    Intent intent = getIntent(getContext(), PlaylistActivity.class);
                    intent.putExtra("id", playlistBean.getId());
                    getContext().startActivity(intent);
                });
                break;
            }
            case SUBSCRIBED_NAME_TYPE: {
                NameHolder nameHolder = (NameHolder) viewHolder;
                nameHolder.textView.setText("收藏的歌单");
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return createdPlaylistCount + subscribedPlayListCount + 2;
    }

    class NameHolder extends RecyclerView.ViewHolder {
        TextView textView;

        NameHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_mine_name);
        }
    }

    class MainHolder extends RecyclerView.ViewHolder {
        ImageView coverImage;
        TextView title;
        TextView count;

        MainHolder(@NonNull View itemView) {
            super(itemView);
            coverImage = itemView.findViewById(R.id.playlist_image);
            title = itemView.findViewById(R.id.playlist_name);
            count = itemView.findViewById(R.id.playlist_count);
        }
    }
}
