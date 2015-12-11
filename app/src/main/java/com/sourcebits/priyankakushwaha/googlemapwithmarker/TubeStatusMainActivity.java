package com.sourcebits.priyankakushwaha.googlemapwithmarker;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class TubeStatusMainActivity extends android.support.v4.app.Fragment {

    private final static String url = "http://cloud.tfl.gov.uk/TrackerNet/LineStatus";
    private ListView lineList;
    TubeAdapter tubeadapter;
    LineStatus obj;
    Button btn_refresh ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = (RelativeLayout) inflater.inflate(R.layout.tube_status_activity_main, container, false);
       // new GetTubeStatusTask(this, url).execute();

        CheckConnectivity check = new CheckConnectivity();
        Boolean conn = check.checkNow(getContext());
        if(conn == true){
            Toast.makeText(getContext(), "You have Internet Connection",Toast.LENGTH_LONG).show();
        }
        else{
            //Send a warning message to the user
            Toast.makeText(getContext(), "You Do not have Internet Connection",Toast.LENGTH_LONG).show();
        }
        btn_refresh = (Button)rootview.findViewById(R.id.btn_refresh);
        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetTubeStatusTask(TubeStatusMainActivity.this, url).execute();
            }
        });
        return rootview;
    }

  /*  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tube_status_activity_main);
        new GetTubeStatusTask(this, url).execute();
    }*/


    public void callBackData( List<LineStatus> resultValue) {

        lineList = (ListView)getActivity().findViewById(R.id.lv_listview); // tube_status_activity_mainctivity_main.xml list view is attached with java code
        tubeadapter= new TubeAdapter(getActivity(), R.layout.tube_status_single_row, (ArrayList<LineStatus>) resultValue);
        lineList.setAdapter(tubeadapter);


    }

}