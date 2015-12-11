package com.sourcebits.priyankakushwaha.googlemapwithmarker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RouteListActivity extends Activity {
    String LOG_TAG = "RouteListActivity";
    TextView tv;

    private final static String url = "https://api.tfl.gov.uk/journey/journeyresults/1000266/to/1000013";
    private ListView routeList;
    RouteListAdapter routeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.route_list);

        new GetRouteListInfoTask(this, url).execute();
        Intent intent = getIntent();

        //fetching all the data in order to find the route list

        //String from = intent.getStringExtra("From");
        // String to = intent.getStringExtra("To");
        //String date = intent.getStringExtra("Date");
        //String time = intent.getStringExtra("Time");
        //String travelPref = intent.getStringExtra("TavelPref");
        //TextView tv = (TextView)findViewById(R.id.textView1);
        //tv.setText(from);


    }

    public void callBackDataForRoute(List<RouteListModelClass> resultValue) {

        routeList = (ListView) findViewById(R.id.route_listView); // activity_main.xml list view is attached with java code
        routeAdapter = new RouteListAdapter(this, R.layout.journey_planner_route_list_single_row, (ArrayList<RouteListModelClass>) resultValue);
        routeList.setAdapter(routeAdapter);


    }


}
