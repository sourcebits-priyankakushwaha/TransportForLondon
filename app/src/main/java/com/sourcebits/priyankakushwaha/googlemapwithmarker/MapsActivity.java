package com.sourcebits.priyankakushwaha.googlemapwithmarker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

@SuppressWarnings("ALL")
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    @SuppressWarnings("FieldCanBeLocal")
    private GoogleMap map;
    public LocationDB database = new LocationDB(this);
    private static String LOG_TAG = "MapsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        /**
         * CRUD Operations
         * */
        // Inserting Locations
        Log.d(LOG_TAG, "Insert: Inserting .. STARTED");
        database.insertLocation(new LatLongPlaces("SW1A 2AX", 51.504981, -0.127262, "Horseguard Parade, Whitehall, London, SW1A 2AX", "HORSE GUARDS PARADE (SW1)", "1"));
        database.insertLocation(new LatLongPlaces("SE10 0DX", 51.501571, 0.005532, "The O2, Peninsula Square, London, SE10 0DX", "The O2", "1"));
        database.insertLocation(new LatLongPlaces("W1B 1JA", 51.51772625174497, -0.14411509037017822, "The Langham Hotel, 1C Portland Pl, Westminster, London, W1B 1JA", "GRANGE LANGHAM COURT HOTEL", "1"));
        database.insertLocation(new LatLongPlaces("E16 1XL", 51.50816, 0.02712, "ExCel, One Western Gateway, Royal Victoria Dock, London, E16 1XL", "BRITANNIA COLLEGE OF EXCELLENCE", "1"));
        database.insertLocation(new LatLongPlaces("E20 2ST", 51.53854140853689, -0.016543865203857422, "Olympic Park, Stratford, London, E20 2ST", "OLYMPIC CAFE", "1"));
        database.insertLocation(new LatLongPlaces("WC1B 3DG", 51.51897, -0.1265, "BRITISH MUSEUM, Great Russell Street, London, WC1B 3DG", "BRITISH MUSEUM", "2"));
        database.insertLocation(new LatLongPlaces("EC4M 8", 51.513897256014594, -0.0986623764038086, "ST.PAULS CATHEDRAL, Saint Pauls Church Yard, City of London, London,EC4M 8", "ST PAULS CATHEDRAL SCHOOL", "2"));
        database.insertLocation(new LatLongPlaces("'EC3N 4AB", 51.508602, -0.076013, "TOWER OF LONDON / CROWN JEWELS, Tower Hill, London, EC3N 4AB", "BANNATYNES HEALTH CLUB TOWER 42, CITY OF LONDON", "2"));
        Log.d(LOG_TAG, "Insert: Inserting .. END");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
//        Marker m1 = map.addMarker(new MarkerOptions()
//                .position(new LatLng(51.504981,-0.127262))
//                .title("HORSE GUARDS PARADE (SW1)"));
//
//        Marker m2 = map.addMarker(new MarkerOptions()
//                .position(new LatLng(51.501571,0.005532))
//                .title("The O2"));
//
//        Marker m3 = map.addMarker(new MarkerOptions()
//                .position(new LatLng(51.51772625174497, -0.14411509037017822))
//                .title("GRANGE LANGHAM COURT HOTEL"));
//
//        Marker m4 = map.addMarker(new MarkerOptions()
//                .position(new LatLng(51.50816, 0.02712))
//                .title("BRITANNIA COLLEGE OF EXCELLENCE"));
//
//        Marker m5 = map.addMarker(new MarkerOptions()
//                .position(new LatLng(51.53854140853689, -0.016543865203857422))
//                .title("OLYMPIC CAFE"));
//
//        Marker m6 = map.addMarker(new MarkerOptions()
//                .position(new LatLng(51.51897, -0.1265))
//                .title( "BRITISH MUSEUM"));
//
//        Marker m7 = map.addMarker(new MarkerOptions()
//                .position(new LatLng(51.513897256014594, -0.0986623764038086))
//                .title("ST PAULS CATHEDRAL SCHOOL"));
//
//        Marker m8 = map.addMarker(new MarkerOptions()
//                .position(new LatLng(51.508602, -0.076013))
            //    .title("BANNATYNES HEALTH CLUB TOWER 42, CITY OF LONDON"));


        // find the count of the latitude and longitude
         int count = database.getLocationCount();
        // Reading all locations
        Log.d(LOG_TAG, "Reading: Reading all Locations.. :: " + count);
        List<LatLongPlaces> placesList = database.getAllLocations();

        double latitude[] = new double[count];
        double longitude[] = new double[count];
        String titleName[] = new String[count];

        for (LatLongPlaces latlng : placesList) {
            for (int i = 0; i < count; i++) {
                latitude[i] = latlng.get_lat();
                longitude[i] = latlng.get_lng();
                titleName[i] = latlng.get_title();

                Log.d(LOG_TAG,titleName[i] );
                //customizing the marker using bitmapdescriptorfactory
               View marker = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custom_marker,null);
                TextView Loaction = (TextView) marker.findViewById(R.id.loc_tv);
                Loaction.setText(titleName[i]);

//                map.addMarker(new MarkerOptions()
//                        .position(new LatLng(latitude[i], longitude[i]))//we are giving static lat long
//                        .icon(BitmapDescriptorFactory.fromBitmap(createDrawableFromView(this, marker))));
             map.addMarker(new MarkerOptions()
                        .position(new LatLng(latitude[i], longitude[i])));
            }
        }
    }

    // Convert a view to bitmap
  public static Bitmap createDrawableFromView(Context context, View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);

        //left, top , right , bottom
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ALPHA_8);

        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        return bitmap;
    }
        }
