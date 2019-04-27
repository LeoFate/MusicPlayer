package com.example.admin.cloudmusic.Main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.cloudmusic.Data.PlayListData;
import com.example.admin.cloudmusic.Data.SubcountData;
import com.example.admin.cloudmusic.R;

import java.util.List;

public class MineAdapter extends RecyclerView.Adapter implements MainContact.MineAdapter {
    private final int CREATED_NAME_TYPE = 1;
    private final int CREATED_MAIN_TYPE = 2;
    private final int SUBSCRIBED_NAME_TYPE = 3;
    private final int SUBSCRIBED_MAIN_TYPE = 4;
    private Context context;
    private int createdPlaylistCount;
    private int subscribedPlayListCount;
    private List<PlayListData.PlaylistBean> playlistList;

    MineAdapter(Context context, SubcountData subcountData, PlayListData playListData) {
        this.context = context;
        if (subcountData.getCode() == 200 && playListData.getCode() == 200) {
            createdPlaylistCount = subcountData.getCreatedPlaylistCount();
            subscribedPlayListCount = subcountData.getSubPlaylistCount();
            playlistList = playListData.getPlaylist();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return CREATED_NAME_TYPE;
        else if (position <= createdPlaylistCount) return CREATED_MAIN_TYPE;
        else if (position == createdPlaylistCount + 1) return SUBSCRIBED_NAME_TYPE;
        else return SUBSCRIBED_MAIN_TYPE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (i) {
            case CREATED_NAME_TYPE:
                viewHolder = new NameHolder(LayoutInflater.from(context).inflate(R.layout.item_mine_name, viewGroup, false));
                break;
            case CREATED_MAIN_TYPE:
                viewHolder = new MainHolder(LayoutInflater.from(context).inflate(R.layout.item_mine_main, viewGroup, false));
                break;
            case SUBSCRIBED_NAME_TYPE:
                viewHolder = new NameHolder(LayoutInflater.from(context).inflate(R.layout.item_mine_name, viewGroup, false));
                break;
            case SUBSCRIBED_MAIN_TYPE:
                viewHolder = new MainHolder(LayoutInflater.from(context).inflate(R.layout.item_mine_main, viewGroup, false));
                break;
        }
        assert viewHolder != null;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case CREATED_NAME_TYPE: {
                NameHolder nameHolder = (NameHolder) viewHolder;
                nameHolder.textView.setText("创建的歌单");
                break;
            }
            case CREATED_MAIN_TYPE: {
                MainHolder mainHolder = (MainHolder) viewHolder;
                PlayListData.PlaylistBean playlistBean = playlistList.get(i - 1);
                Glide.with(context)
                        .load(playlistBean.getCoverImgUrl())
                        .into(mainHolder.coverImage);
                mainHolder.title.setText(playlistBean.getName());
                mainHolder.count.setText(playlistBean.getTrackCount());
                break;
            }
            case SUBSCRIBED_NAME_TYPE: {
                NameHolder nameHolder = (NameHolder) viewHolder;
                nameHolder.textView.setText("收藏的歌单");
                break;
            }
            case SUBSCRIBED_MAIN_TYPE: {
                MainHolder mainHolder = (MainHolder) viewHolder;
                PlayListData.PlaylistBean playlistBean = playlistList.get(i - 1);
                Glide.with(context)
                        .load(playlistBean.getCoverImgUrl())
                        .into(mainHolder.coverImage);
                mainHolder.title.setText(playlistBean.getName());
                String count = playlistBean.getTrackCount() + " by " + playlistBean.getCreator().getNickname();
                mainHolder.count.setText(count);
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
