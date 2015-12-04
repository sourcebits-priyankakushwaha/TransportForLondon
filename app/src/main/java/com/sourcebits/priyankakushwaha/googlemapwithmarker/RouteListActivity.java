package com.sourcebits.priyankakushwaha.googlemapwithmarker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class RouteListActivity
        extends Activity {
    String LOG_TAG = "RouteListActivity";
    TextView tv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.route_list);
        Intent intent = getIntent();

        //fetching all the data in order to find the route list

        String from = intent.getStringExtra("From");
       // String to = intent.getStringExtra("To");
        //String date = intent.getStringExtra("Date");
        //String time = intent.getStringExtra("Time");
        //String travelPref = intent.getStringExtra("TavelPref");
        TextView tv = (TextView)findViewById(R.id.textView1);
        tv.setText(from);

          }



}
