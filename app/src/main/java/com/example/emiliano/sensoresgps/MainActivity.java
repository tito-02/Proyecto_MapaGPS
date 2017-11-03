package com.example.emiliano.sensoresgps;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {

    static final LatLng SANLUIS = new LatLng(-33.280576, -66.332482);
    static final LatLng ULP = new LatLng(-33.150720, -66.306864);
    private GoogleMap map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GoogleMap mapa = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(MapaActual);

    }

        private class MapaActual implements OnMapReadyCallback {
            @Override
            public void onMapReady(GoogleMap mapa) {
                map = mapa;
                CameraPosition camPos = new CameraPosition.Builder().target(SANLUIS).zoom(19).bearing(45).tilt(70).build();
                CameraUpdate camUpICT = CameraUpdateFactory.newCameraPosition(camPos);
                map.animateCamera(camUpICT);
                mapa.addMarker(new MarkerOptions().position(SANLUIS)).setTitle("San Luis");
                mapa.addMarker(new MarkerOptions().position(ULP)).setTitle("ULP");

            }
        }

    }
