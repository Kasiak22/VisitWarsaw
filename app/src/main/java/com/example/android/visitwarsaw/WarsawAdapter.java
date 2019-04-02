package com.example.android.visitwarsaw;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import Fragment.ExtraFragment;
import Fragment.LeisureFragment;
import Fragment.MuseumFragment;
import Fragment.MustFragment;

public class WarsawAdapter extends FragmentPagerAdapter

{
    private String tabTitles[] = new String[]{"MustSee", "Museums", "Leisure", "Extras"};

    public WarsawAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 4;
    }

    //getting right item for each case
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MustFragment();
            case 1:
                return new MuseumFragment();
            case 2:
                return new LeisureFragment();
            case 3:
                return new ExtraFragment();
            default:
                return null;
        }
    }

    //assigning title tabs
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}

