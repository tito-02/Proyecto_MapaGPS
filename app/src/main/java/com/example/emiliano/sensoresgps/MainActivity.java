package com.example.emiliano.sensoresgps;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.UUID;

import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_SATELLITE;

public class MainActivity extends FragmentActivity {

    static final LatLng SANLUIS = new LatLng(-33.280576, -66.332482);
    static final LatLng ULP = new LatLng(-33.150720, -66.306864);
    private GoogleMap map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map =((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(MapaActual);
        map.setMapStyle(GoogleMap.MAP_TYPE_SATELLITE);

        Marker sanluis = map.addMarker(new MarkerOptions().position(SANLUIS).title("San Luis"));
        Marker ulp = map.addMarker(new MarkerOptions().position(ULP).title("Univerdidad de la punta").snippet("ULP La Mejor").icon(BitmapDescriptorFactory.fromResource(R.drawable.ULP)));

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(ULP,15));
        map.animateCamera(CameraUpdateFactory.zoomTo(15),2000,null);


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
