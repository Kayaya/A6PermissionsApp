package com.example.a1kayat34.a6permissionsapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements LocationListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_grant_permission = (Button)findViewById(R.id.grant_permission);
        Button btn_start_GPS = (Button)findViewById(R.id.start_gps);

        btn_grant_permission.setOnClickListener(this);
        btn_start_GPS.setOnClickListener(this);

        LocationManager locationMgr = (LocationManager) getSystemService(this.LOCATION_SERVICE);


    }

    public void onClick(View v){
        if(v.getId() == R.id.grant_permission){


        }
        else if(v.getId() == R.id.start_gps){
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {


                return;
            }
            else {
                locationMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

            }
        }

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
