package com.yx.player.musicdemo2.utils;

/**
 * URL工厂，用于生成URL字符串
 * Created by ${Dota.Wang} on 2017/12/26.
 */
public class UrlFactory {
    /**
     * 获取新音乐榜url地址
     *
     */
    public static String getNewMusicListUrl(int offset, int size) {
        String url = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=qianqian&version=2.1.0&method=baidu.ting.billboard.billList&format=xml&type=1&offset="+offset+"&size="+size;
        return url;
    }
}