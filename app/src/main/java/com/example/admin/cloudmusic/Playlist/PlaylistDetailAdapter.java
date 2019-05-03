package com.example.admin.cloudmusic.Playlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.cloudmusic.Base.BaseRVAdapter;
import com.example.admin.cloudmusic.Data.PlaylistDetailData;
import com.example.admin.cloudmusic.R;

import java.util.List;

public class PlaylistDetailAdapter extends BaseRVAdapter implements PlaylistContact.PlaylistDetailAdapter {
    private final int HEAD_TYPE = 0;
    private final int MAIN_TYPE = 1;
    private List<PlaylistDetailData.PlaylistBean.TracksBean> tracksList;
    private PlaylistDetailData playlistDetailData;

    PlaylistDetailAdapter(Context context, PlaylistDetailData playlistDetailData) {
        super(context);
        this.playlistDetailData = playlistDetailData;
        tracksList = playlistDetailData.getPlaylist().getTracks();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return HEAD_TYPE;
        else return MAIN_TYPE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (i) {
            case HEAD_TYPE:
                viewHolder = new HeadHolder(layoutInflater.inflate(R.layout.item_playlist_head, viewGroup, false));
                break;
            case MAIN_TYPE:
                viewHolder = new MainHolder(layoutInflater.inflate(R.layout.item_playlist_main, viewGroup, false));
                break;
        }
        assert viewHolder != null;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case HEAD_TYPE:
                HeadHolder headHolder = (HeadHolder) viewHolder;
                PlaylistDetailData.PlaylistBean.CreatorBean creatorBean = playlistDetailData.getPlaylist().getCreator();
                headHolder.author.setText(creatorBean.getNickname());
                Glide.with(viewHolder.itemView)
                        .load(creatorBean.getAvatarUrl())
                        .into(headHolder.avatar);
                headHolder.name.setText(playlistDetailData.getPlaylist().getName());
                break;
            case MAIN_TYPE:
                MainHolder mainHolder = (MainHolder) viewHolder;
                PlaylistDetailData.PlaylistBean.TracksBean tracksBean = tracksList.get(i - 1);
                mainHolder.serialNumber.setText(String.valueOf(i - 1));
                mainHolder.name.setText(tracksBean.getName());
                String author = tracksBean.getAr().get(0).getName() + tracksBean.getAl().getName();
                mainHolder.author.setText(author);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return tracksList.size() + 1;
    }

    class HeadHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView name;
        TextView author;

        HeadHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.head_avatar);
            name = itemView.findViewById(R.id.head_name);
            author = itemView.findViewById(R.id.head_author);
        }
    }

    class MainHolder extends RecyclerView.ViewHolder {
        TextView serialNumber;
        TextView name;
        TextView author;

        MainHolder(@NonNull View itemView) {
            super(itemView);
            serialNumber = itemView.findViewById(R.id.serial_number);
            name = itemView.findViewById(R.id.song_name);
            author = itemView.findViewById(R.id.song_author);
        }
    }
}
