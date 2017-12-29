package com.yx.player.musicdemo2.model;

import android.os.AsyncTask;
import android.util.Log;

import com.yx.player.musicdemo2.bean.Music;
import com.yx.player.musicdemo2.callback.MusicListCallback;
import com.yx.player.musicdemo2.utils.HttpUtils;
import com.yx.player.musicdemo2.utils.UrlFactory;
import com.yx.player.musicdemo2.utils.XmlParser;

import java.io.InputStream;
import java.util.List;

/**
 * 音乐相关的业务类
 * Created by ${Dota.Wang} on 2017/12/26.
 */
public class MusicModel {
    /**
     * 添加新歌榜列表，需要发送http请求
     * 必须在工作线程中发送请求
     * @param offset 音乐的起始位置
     * @param 向后查询的条目数
     */
    public void loadNewMusicList(final int offset, final int size,final MusicListCallback callback) {
        AsyncTask<String, String, List<Music>> task = new AsyncTask<String, String, List<Music>>() {

            @Override
            protected List<Music> doInBackground(String... params) {
                try {
                    //发送http请求
                    String url = UrlFactory.getNewMusicListUrl(offset, size);
                    InputStream is = HttpUtils.getInputStream(url);
                    //解析is中的xml文档，获取List<Music>
                    List<Music> musics = XmlParser.parseMusicList(is);
                    return musics;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(List<Music> result) {
//                Log.i("info", "音乐列表：" + result.toString());
                callback.onMusicListLoaded(result);//采用回调的方式加载音乐列表
                super.onPostExecute(result);
            }
        };
        task.execute();
    }
}