package com.yx.player.musicdemo2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yx.player.musicdemo2.R;

/**
 * 热歌列表
 * Created by ${Dota.Wang} on 2017/12/26.
 */
public class HotMusicListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_list, null);

        return view;
    }
}
