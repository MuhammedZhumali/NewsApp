package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.newsapp.fragments.HomeFragment;
import com.example.newsapp.fragments.BusinessFragment;
import com.example.newsapp.fragments.ScienceFragment;
import com.example.newsapp.fragments.SportFragment;
import com.example.newsapp.fragments.TechnologyFragment;

public class PagerAdapter extends FragmentPagerAdapter {//если используется мало фрагментов Адаптер
    // PagerAdapter можно использовать в тех случаях, когда вам не нужны фрагменты.

    private static int tabCount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new TechnologyFragment();
            case 2:
                return new SportFragment();//"sport"
            case 3:
                return new ScienceFragment();
            case 4:
                return new BusinessFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
