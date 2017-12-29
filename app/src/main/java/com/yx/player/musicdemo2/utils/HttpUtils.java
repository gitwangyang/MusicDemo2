package com.yx.player.musicdemo2.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 发送Http请求的工具类
 * Created by ${Dota.Wang} on 2017/12/26.
 */
public class HttpUtils {
    /**
     * 发送get请求，返回接收到的响应输入流
     * @param path 请求资源路径
     * @throws Exception
     */
    public static InputStream getInputStream(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        InputStream is = connection.getInputStream();
        return is;
    }

}
