package com.sourcebits.priyankakushwaha.googlemapwithmarker;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class TabLayoutActivity extends FragmentActivity implements  ActionBar.TabListener, OnMapReadyCallback , GoogleMap.OnMarkerClickListener {

    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;

    private GoogleMap map;
    private static String LOG_TAG = "map";

    // intialize marker variable
    private Marker m1, m2, m3, m4, m5, m6, m7, m8;
    // Tab titles
    private String[] tabs = { "Tube Status", "Planner", "Departures"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager(),this);

        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }


        /**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
                Log.i("tag", String.valueOf(position));

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
        int i = tab.getPosition();
        if(i != viewPager.getCurrentItem()) {
           viewPager.setCurrentItem(i);
        }
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (googleMap != null) {

            map = googleMap;
           // map.setMyLocationEnabled(true);
            m1 = map.addMarker(new MarkerOptions()
                    .position(new LatLng(51.504981, -0.127262))
                    .title("HORSE GUARDS PARADE (SW1)"));

            m2 = map.addMarker(new MarkerOptions()
                    .position(new LatLng(51.501571, 0.005532))
                    .title("The O2"));

            m3 = map.addMarker(new MarkerOptions()
                    .position(new LatLng(51.51772625174497, -0.14411509037017822))
                    .title("GRANGE LANGHAM COURT HOTEL"));

            m4 = map.addMarker(new MarkerOptions()
                    .position(new LatLng(51.50816, 0.02712))
                    .title("BRITANNIA COLLEGE OF EXCELLENCE"));

            m5 = map.addMarker(new MarkerOptions()
                    .position(new LatLng(51.53854140853689, -0.016543865203857422))
                    .title("OLYMPIC CAFE"));

            m6 = map.addMarker(new MarkerOptions()
                    .position(new LatLng(51.51897, -0.1265))
                    .title("BRITISH MUSEUM"));

            m7 = map.addMarker(new MarkerOptions()
                    .position(new LatLng(51.513897256014594, -0.0986623764038086))
                    .title("ST PAULS CATHEDRAL SCHOOL"));

            m8 = map.addMarker(new MarkerOptions()
                    .position(new LatLng(51.508602, -0.076013))
                    .title("BANNATYNES HEALTH CLUB TOWER 42, CITY OF LONDON"));
            map.setOnMarkerClickListener(TabLayoutActivity.this);
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.equals(m1)) {
            Intent nextIntent = new Intent(this, SecondActivity.class);
            nextIntent.putExtra("Location Name", m1.getTitle());//on click of marker value of title should pass to the next screen
            startActivity(nextIntent);
        }
        if (marker.equals(m2)) {
            Intent nextIntent = new Intent(this, SecondActivity.class);
            nextIntent.putExtra("Location Name", m2.getTitle());//on click of marker value of title should pass to the next screen
            startActivity(nextIntent);
        }
        if (marker.equals(m3)) {
            Intent nextIntent = new Intent(this, SecondActivity.class);
            nextIntent.putExtra("Location Name", m3.getTitle());//on click of marker value of title should pass to the next screen
            startActivity(nextIntent);
        }
        if (marker.equals(m4)) {
            Intent nextIntent = new Intent(this, SecondActivity.class);
            nextIntent.putExtra("Location Name", m4.getTitle());//on click of marker value of title should pass to the next screen
            startActivity(nextIntent);
        }
        if (marker.equals(m5)) {
            Intent nextIntent = new Intent(this, SecondActivity.class);
            nextIntent.putExtra("Location Name", m5.getTitle());//on click of marker value of title should pass to the next screen
            startActivity(nextIntent);
        }
        if (marker.equals(m6)) {
            Intent nextIntent = new Intent(this, SecondActivity.class);
            nextIntent.putExtra("Location Name", m6.getTitle());//on click of marker value of title should pass to the next screen
            startActivity(nextIntent);
        }
        if (marker.equals(m7)) {
            Intent nextIntent = new Intent(this, SecondActivity.class);
            nextIntent.putExtra("Location Name", m7.getTitle());//on click of marker value of title should pass to the next screen
            startActivity(nextIntent);
        }
        if (marker.equals(m8)) {
            Intent nextIntent = new Intent(this, SecondActivity.class);
            nextIntent.putExtra("Location Name", m8.getTitle());//on click of marker value of title should pass to the next screen
            startActivity(nextIntent);
        }

        return false;
    }
}