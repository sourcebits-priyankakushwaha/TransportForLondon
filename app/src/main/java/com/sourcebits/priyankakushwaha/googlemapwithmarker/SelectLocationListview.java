package com.sourcebits.priyankakushwaha.googlemapwithmarker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class SelectLocationListview extends Activity {

    ListView locationList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_screen);
        locationList = (ListView)findViewById(R.id.location_list);
    }
}
