package com.yx.player.musicdemo2.utils;

import android.util.Xml;

import com.yx.player.musicdemo2.bean.Music;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * xml解析器
 * Created by ${Dota.Wang} on 2017/12/26.
 */
public class XmlParser {
    /**
     * 解析音乐列表数据
     * @throws Exception
     */
    public static List<Music> parseMusicList(InputStream is) throws Exception {
        //1. XmlPullParser
        XmlPullParser parser = Xml.newPullParser();
        //2. parser.setInput()
        parser.setInput(is, "utf-8");
        //3. eventType
        int eventType = parser.getEventType();
        //4. while(){}
        List<Music> musics = new ArrayList<Music>();
        Music music = null;

        while(eventType != XmlPullParser.END_DOCUMENT) {
            switch(eventType) {
                case XmlPullParser.START_TAG://开始标签
                    String tag = parser.getName();
                    //开始一首新歌
                    if(tag.equals("song")) {
                        music = new Music();
                        musics.add(music);
                    } else if(tag.equals("artist_id")) {
                        music.setArtist_id(parser.nextText());
                    } else if (tag.equals("language")) {
                        music.setLanguage(parser.nextText());
                    } else if (tag.equals("pic_big")) {
                        music.setPic_big(parser.nextText());
                    } else if (tag.equals("pic_small")) {
                        music.setPic_small(parser.nextText());
                    } else if (tag.equals("lrclink")) {
                        music.setLrclink(parser.nextText());
                    } else if (tag.equals("hot")) {
                        music.setHot(parser.nextText());
                    } else if (tag.equals("all_artist_id")) {
                        music.setAll_artist_id(parser.nextText());
                    } else if (tag.equals("style")) {
                        music.setStyle(parser.nextText());
                    } else if (tag.equals("song_id")) {
                        music.setSong_id(parser.nextText());
                    } else if (tag.equals("title")) {
                        music.setTitle(parser.nextText());
                    } else if (tag.equals("ting_uid")) {
                        music.setTing_uid(parser.nextText());
                    } else if (tag.equals("author")) {
                        music.setAuthor(parser.nextText());
                    } else if (tag.equals("album_id")) {
                        music.setAlbum_id(parser.nextText());
                    } else if (tag.equals("album_title")) {
                        music.setAlbum_title(parser.nextText());
                    } else if (tag.equals("artist_name")) {
                        music.setArtist_name(parser.nextText());
                    }
                    break;
            }
            //向后驱动事件
            eventType = parser.next();
        }

        return musics;
    }
}
