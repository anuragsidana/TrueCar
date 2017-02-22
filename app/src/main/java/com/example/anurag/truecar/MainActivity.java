package com.example.anurag.truecar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    MyTabPager pagerAdapter;
    Toolbar toolbar;
    TabLayout mTabs;
    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
        mTabs = (TabLayout) findViewById(R.id.tab_layout);
        mPager = (ViewPager) findViewById(R.id.view_pager);
        pagerAdapter = new MyTabPager(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
        mTabs.setupWithViewPager(mPager);
        mPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        FragmentVisible listerner;

        if(position==1){
            listerner=new FragmentBody();
            listerner.fragmentBecomeVisible(position);
        }
        if(position==2){
            listerner=new FragmentBrands();
            listerner.fragmentBecomeVisible(position);
        }


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    class MyTabPager extends FragmentPagerAdapter {
        public MyTabPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new FragmentBudget();

            } else if (position == 1) {
                return new FragmentBody();
            } else if (position == 2) {
                return new FragmentBrands();
            }
            return  null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String[] tabs = getResources().getStringArray(R.array.tabs);
            return tabs[position];
        }
    }


}
