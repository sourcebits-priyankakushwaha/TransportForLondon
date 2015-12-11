package com.sourcebits.priyankakushwaha.googlemapwithmarker;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private SupportMapFragment mSupportMapFragment;
    private OnMapReadyCallback mOnMapReadyCallback ;

    public TabsPagerAdapter(FragmentManager fm, OnMapReadyCallback onMapReadyCallback) {
        super(fm);
        mOnMapReadyCallback = onMapReadyCallback;
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                //Maps fragment activity
                return new TubeStatusMainActivity();

            case 1:
                // Tube fragment activity
                mSupportMapFragment =  SupportMapFragment.newInstance();
                mSupportMapFragment.getMapAsync(mOnMapReadyCallback);
                return mSupportMapFragment;
            case 2:
                // Departure fragment activity
              return new Departure();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
