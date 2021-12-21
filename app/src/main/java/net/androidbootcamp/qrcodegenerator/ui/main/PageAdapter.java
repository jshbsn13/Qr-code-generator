package net.androidbootcamp.qrcodegenerator.ui.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

/*
This class will return a fragment based on getItem() and its passed position parameter
 */

public class PageAdapter extends FragmentStatePagerAdapter {


    private int numTabs;

    //constructor is required
    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Tab1Fragment();

            case 1:
                return new Tab2Fragment();

            case 2:
                return new Tab3Fragment();
            case 3:
                return new Tab4Fragment();
            case 4:
                return new Tab5Fragment();
            case 5:
                return new Tab6Fragment();
            case 6:
                return new Tab7Fragment();

            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
