package com.yx.player.musicdemo2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yx.player.musicdemo2.R;
import com.yx.player.musicdemo2.adapter.MusicAdapter;
import com.yx.player.musicdemo2.bean.Music;
import com.yx.player.musicdemo2.callback.MusicListCallback;
import com.yx.player.musicdemo2.model.MusicModel;

import java.util.List;

/**
 * 新歌列表
 * Created by ${Dota.Wang} on 2017/12/26.
 */
public class NewMusicListFragment extends Fragment {

    private ListView listView;
    private MusicModel model;
    private List<Music> musics;
    private MusicAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_list, null);

        //初始化控件
        setView(view);

        //调用业务层的方法，加载新歌榜列表
        model = new MusicModel();
        model.loadNewMusicList(0, 30, new MusicListCallback() {
            //当列表加载完毕后将会调用的回调方法
            @Override
            public void onMusicListLoaded(List<Music> musics) {
                NewMusicListFragment.this.musics = musics;
                setAdapter();
            }
        });
        return view;
    }

    /**
     * 更新适配器
     */
    private void setAdapter() {
        adapter = new MusicAdapter(getActivity(), musics);
        listView.setAdapter(adapter);

    }
    private void setView(View view) {
        listView = (ListView) view.findViewById(R.id.listView);
    }
}