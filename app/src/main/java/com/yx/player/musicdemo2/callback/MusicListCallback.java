package com.yx.player.musicdemo2.callback;

import com.yx.player.musicdemo2.bean.Music;

import java.util.List;

/**
 * Created by ${Dota.Wang} on 2017/12/26.
 */
public interface MusicListCallback {
    /**
     * 当列表加载完毕后将会调用的回掉方法
     * @param musics
     */
    void onMusicListLoaded(List<Music> musics);
}
