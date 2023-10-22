package com.databit.semana09_googlemapapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap myMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        SupportMapFragment mapFragment1 = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment1.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        myMap= googleMap;

        LatLng ubicacion=new LatLng(-30.6045845, -71.2073349);
        myMap.addMarker(new MarkerOptions().position(ubicacion).title("IP Santo Tomas"));
        myMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));
        myMap.moveCamera(CameraUpdateFactory.zoomTo(15));

        myMap.getUiSettings().setZoomControlsEnabled(true);
        myMap.getUiSettings().setCompassEnabled(true);

        myMap.getUiSettings().setZoomGesturesEnabled(false);
        myMap.getUiSettings().setScrollGesturesEnabled(false);
    }
}