package de.hackathon.adidas.adidasproject;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Created by ankit on 1/20/18.
 */



public class TabsPagerAdapter extends FragmentPagerAdapter {
    private final String TAG = "TabsPagerAdapter";

    private Activity myActivity;

    public TabsPagerAdapter(FragmentManager fm, Activity activity) {
        super(fm);
        myActivity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LeaseFragment();
            case 1:
                return new BuyFragment();
            case 2:
                return new SustainFragment();
            case 3:
                return new FanclubFragment();
            default:
                Log.e(TAG, "should never get here - not a tab");
                return null;
        }

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return myActivity.getApplicationContext().getString(R.string.lease_tab);
            case 1:
                return myActivity.getApplicationContext().getString(R.string.buy_tab);
            case 2:
                return myActivity.getApplicationContext().getString(R.string.sustain_tab);
            case 3:
                return myActivity.getApplicationContext().getString(R.string.fanclub_tab);
            default:
                Log.e(TAG, "should never get here - not a tab");
                return null;
        }
    }
}
