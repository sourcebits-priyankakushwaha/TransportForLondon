package com.sourcebits.priyankakushwaha.googlemapwithmarker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class SecondActivity extends Activity implements View.OnClickListener {

    private Button bFrom;
    private Button bTo;
    private Button bDate;
    private Button bFindRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);

        bFrom = (Button) findViewById(R.id.btn_from);
        bTo = (Button) findViewById(R.id.btn_to);
        bDate = (Button) findViewById(R.id.btn_date);
        bFindRoute= (Button) findViewById(R.id.btn_find_route);

        bFrom.setOnClickListener(this);
        bTo.setOnClickListener(this);
        bDate.setOnClickListener(this);
        bFindRoute.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view == bFrom) {

            Intent fromIntent = new Intent(this,SelectLocationListview.class);
            startActivityForResult(fromIntent, 0);

        }

        if (view == bTo) {
            Intent toIntent = new Intent(this, SelectLocationListview.class);
            startActivityForResult(toIntent, 1);
        }
        if (view == bDate) {
            Intent dateIntent = new Intent(this,DatePickerActivity.class);
            startActivityForResult(dateIntent, 2);

        }
        if (view == bFindRoute) {
            Intent routeIntent = new Intent(this,RouteListActivity .class);
            startActivityForResult(routeIntent, 3);

        }

    }

}
