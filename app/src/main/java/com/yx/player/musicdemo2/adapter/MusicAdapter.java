package com.yx.player.musicdemo2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yx.player.musicdemo2.R;
import com.yx.player.musicdemo2.bean.Music;

import java.util.List;

/**
 * NewMusicListFragment类的adapter
 * Created by ${Dota.Wang} on 2017/12/26.
 */
public class MusicAdapter extends BaseAdapter {
    private Context context;
    private List<Music> musics;
    private LayoutInflater inflater;

    public MusicAdapter(Context context, List<Music> musics) {
        super();
        this.context = context;
        this.musics = musics;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return musics.size();
    }

    @Override
    public Object getItem(int position) {
        return musics.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_lv_music, null);
            holder = new ViewHolder();
            holder.ivAlbum = (ImageView) convertView.findViewById(R.id.ivAlbum);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            holder.tvSinger = (TextView) convertView.findViewById(R.id.tvSinger);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();

        //控件的赋值
        Music music = (Music) getItem(position);

        holder.tvTitle.setText(music.getTitle());
        holder.tvSinger.setText(music.getAuthor());

        return convertView;
    }

    class ViewHolder {
        ImageView ivAlbum;
        TextView tvTitle;
        TextView tvSinger;
    }
}