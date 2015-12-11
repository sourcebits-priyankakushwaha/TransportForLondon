package com.sourcebits.priyankakushwaha.googlemapwithmarker;


import android.app.ProgressDialog;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetRouteListInfoTask  extends AsyncTask<String[], Void, List<RouteListModelClass>> {
    private RouteListActivity activity;
    private String url;
    // private XmlPullParserFactory xmlFactoryObject;
    private ProgressDialog pDialog;

    public GetRouteListInfoTask(RouteListActivity activity, String url) {
        this.activity = activity;
        this.url = url;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(activity);
        pDialog.setTitle("Get route list from JSON");
        pDialog.setMessage("Loading...");
        pDialog.show();
    }

    @Override
    protected List<RouteListModelClass> doInBackground(String[]... params) {
        RouteListModelClass routeObj;
        List<RouteListModelClass> routeList;
        routeList = new ArrayList<RouteListModelClass>();
        try {
            URL url = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000 /* milliseconds */);
            connection.setConnectTimeout(15000 /* milliseconds */);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            connection.getInputStream()));

            // List<RouteListModelClass> routeListResult = parseJSON();
            String next ;
            routeObj = new RouteListModelClass();
            StringBuilder builder = new StringBuilder();
//            while ((next = bufferedReader.readLine()) != null){
//                builder.append(next).append("\n");
//            }
            while ((next = bufferedReader.readLine()) != null){
                builder.append(next).append("\n");
            }

            JSONObject jsonObj = new JSONObject(builder.toString());
            JSONObject rootObj = jsonObj.getJSONObject("journeys");
            JSONArray journeyArray  = rootObj.getJSONArray("journeys");
            for (int i = 0; i < journeyArray.length(); i++)
            {
                JSONObject jsonChildNode = journeyArray.getJSONObject(i);

                /******* Fetch node values **********/
                int durationInt = Integer.parseInt(jsonChildNode.optString("duration").toString());
                String 	duration= String.valueOf(durationInt);
                routeObj.setDuration(duration);
                //String start = jsonObj1.getString("startDateTime");
                //routeObj.setDuration(start);
                // String end = jsonObj1.getString("arrivalDateTime");
                routeList.add(routeObj);
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return routeList;
    }


    @Override
    protected void onPostExecute(List<RouteListModelClass> result) {
        //call back data to main thread
        pDialog.dismiss();
        activity.callBackDataForRoute(result);

    }
}
