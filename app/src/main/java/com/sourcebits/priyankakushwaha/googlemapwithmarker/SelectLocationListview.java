package com.sourcebits.priyankakushwaha.googlemapwithmarker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SelectLocationListview extends Activity {

    ListView locationList;
    String Title[] = {"London Eye", "Westminister", "Bank", "Big Ben", "Chelsea", "Black Pool", "Wembley Stadium", "Emirates Stadium", "Tottenham"};
    TravelData travelData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_screen);
        locationList = (ListView) findViewById(R.id.location_list);
        myAdapter adapter = new myAdapter(this, Title);// pass the array of the locations
        locationList.setAdapter(adapter);
        locationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent returnIntent = getIntent();
                returnIntent.putExtra("position", position);
                String itemValue = (String) locationList.getItemAtPosition(position);
                returnIntent.putExtra("resultValue", itemValue);
                // returnIntent.putExtra("Loaction", );
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }

        });
    }

    class myAdapter extends BaseAdapter {
        Context context;
        public String titleArray[];


        public myAdapter(Context c, String titles[]) //taking title as a parameter
        {
            this.context = c;
            this.titleArray = titles;

        }

        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //Layout inflater is used for convert xml object to java object
        //row is a object which contains Relative layout (parent of the image and text view)
        // by using row object we are fetching textview
        //getview method is called each time for each row
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflater.inflate(R.layout.third_screen_single_row, parent, false);
            }

            TextView myTitle = (TextView) v.findViewById(R.id.tv_place_name);
            myTitle.setText(titleArray[position]);
            return v;// this is the final view we want
        }

    }


}