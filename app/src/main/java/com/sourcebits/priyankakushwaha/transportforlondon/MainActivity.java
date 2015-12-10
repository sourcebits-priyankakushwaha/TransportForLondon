package com.sourcebits.priyankakushwaha.transportforlondon;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class MainActivity extends TabActivity implements TabHost.OnTabChangeListener {

    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get TabHost Refference
        tabHost = getTabHost();

        // Set TabChangeListener called when tab changed
        tabHost.setOnTabChangedListener(this);

        TabHost.TabSpec spec;
        Intent intent;

        /************* TAB1 ************/
        // Create  Intents to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, JourneyPlanner.class);
        spec = tabHost.newTabSpec("First").setIndicator("")
                .setContent(intent);

        //Add intent to tab
        tabHost.addTab(spec);

        /************* TAB2 ************/
        intent = new Intent().setClass(this, TubeStatus.class);
        spec = tabHost.newTabSpec("Second").setIndicator("")
                .setContent(intent);
        tabHost.addTab(spec);

        /************* TAB3 ************/
        intent = new Intent().setClass(this,Departures.class);
        spec = tabHost.newTabSpec("Third").setIndicator("")
                .setContent(intent);
        tabHost.addTab(spec);

        // Set drawable images to tab
      /*  tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.tab2);
        tabHost.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.tab3);

        // Set Tab1 as Default tab and change image
        tabHost.getTabWidget().setCurrentTab(0);
        tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.tab1_over); */


    }

    @Override
    public void onTabChanged(String tabId) {

        /************ Called when tab changed *************/

        //********* Check current selected tab and change according images *******/

      /*  for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
        {
            if(i==0)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab1);
            else if(i==1)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab2);
            else if(i==2)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab3);
        }


        Log.i("tabs", "CurrentTab: " + tabHost.getCurrentTab());

        if(tabHost.getCurrentTab()==0)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.tab1_over);
        else if(tabHost.getCurrentTab()==1)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.tab2_over);
        else if(tabHost.getCurrentTab()==2)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.tab3_over);

    }*/




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.switchView) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
