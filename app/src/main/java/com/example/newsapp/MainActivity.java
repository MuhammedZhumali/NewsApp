package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout catalog;
    private TabItem ihome, itechnology,isport,iscience, ibusiness;
    public static String ctr = "ru";
    private PagerAdapter pagerAdapter;
    ViewPager viewPager;
    private String api = "5482b55591664ef088aa7e7548fd71c6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ihome = findViewById(R.id.home);
        itechnology = findViewById(R.id.technology);
        isport = findViewById(R.id.sport);
        iscience = findViewById(R.id.science);
        ibusiness = findViewById(R.id.business);

        viewPager = findViewById(R.id.fragContainer);
        catalog = findViewById(R.id.catalog);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 5);
        viewPager.setAdapter(pagerAdapter);

        catalog.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||
                        tab.getPosition()==3||tab.getPosition()==4){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(catalog));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.news, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.usCtr:
                ctr = "us";
                pagerAdapter.notifyDataSetChanged();
                return true;
            case R.id.ruCtr:
                ctr = "ru";
                pagerAdapter.notifyDataSetChanged();
                return true;
            case R.id.itCtr:
                ctr = "it";
                pagerAdapter.notifyDataSetChanged();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}