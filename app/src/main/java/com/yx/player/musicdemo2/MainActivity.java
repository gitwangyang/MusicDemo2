package com.yx.player.musicdemo2;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yx.player.musicdemo2.fragment.HotMusicListFragment;
import com.yx.player.musicdemo2.fragment.NewMusicListFragment;

/**
 * 参考地址：http://blog.csdn.net/yuanxindev/article/details/59055514
 */
public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private RadioButton rbNew;
    private RadioButton rbHot;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        setView();

        //初始化viewpager的适配器
        setPagerAdapter();

        //监听
        setListeners();
    }
    private void setListeners() {
        //viewPager控制radioGroup
        viewPager.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        //选择了第一页
                        rbNew.setChecked(true);
                        break;
                    case 1:
                        //选择了第二页
                        rbHot.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

        //radioGroup控制viewpager
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioNew:
                        //选中了新歌列表
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.radioHot:
                        //选中了热歌列表
                        viewPager.setCurrentItem(1);
                        break;
                }
            }
        });
    }

    /**
     * 初始化viewpager的适配器
     */
    private void setPagerAdapter() {
        //准备两个Fragment作为数据源
        fragments = new ArrayList<Fragment>();
        fragments.add(new NewMusicListFragment());
        fragments.add(new HotMusicListFragment());
        PagerAdapter pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

    /**
     * 初始化控件
     */
    private void setView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rbNew = (RadioButton) findViewById(R.id.radioNew);
        rbHot = (RadioButton) findViewById(R.id.radioHot);
    }

    /**
     * 声明ViewPager的适配器
     * @author YX
     */
    class MainPagerAdapter extends FragmentPagerAdapter {

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

}