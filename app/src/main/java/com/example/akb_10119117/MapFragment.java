package com.example.akb_10119117;
// nim : 10119117
// nama : fikri muhamad fauzi
// kelas : if-3

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initialize view
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        // Initialize map fragment
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map);

        // Async map
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                LatLng Lokasi1 = new LatLng(-6.819520821344144, 107.1443854062338);
                LatLng Lokasi2 = new LatLng(-6.819595391851955, 107.14385969330124);
                LatLng Lokasi3 = new LatLng(-6.821203981408995, 107.14241666494549);
                LatLng Lokasi4 = new LatLng(-6.821715320011747, 107.14614493525437);
                LatLng Lokasi5 = new LatLng(-6.822397103970509, 107.14189095195294);
                LatLng Rumah = new LatLng(-6.820245220071647, 107.14374704052997);
                googleMap.setMapType(googleMap.MAP_TYPE_HYBRID);
                googleMap.addMarker(new MarkerOptions().position(Lokasi1).title("Burger Bangor"));
                googleMap.addMarker(new MarkerOptions().position(Lokasi2).title("De Baksoku Cianjur"));
                googleMap.addMarker(new MarkerOptions().position(Lokasi3).title("Bubur Ayam Sampurna Cianjur"));
                googleMap.addMarker(new MarkerOptions().position(Lokasi4).title("Pecel Mas TekTek"));
                googleMap.addMarker(new MarkerOptions().position(Lokasi5).title("Rumah Makan Sederhana"));
                googleMap.addMarker(new MarkerOptions().position(Rumah).title("Rumah"));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Rumah, 17));

                // when map is loaded
                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {
                        // when clicked on map
                        // Initialize marker options
                        MarkerOptions markerOptions = new MarkerOptions();

                        // Set position of marker
                        markerOptions.position(latLng);

                        // Set title of marker
                        markerOptions.title(latLng.latitude + " : " + latLng.longitude);

                        // Remove all marker
                        googleMap.clear();

                        // Animating to zoom the marker
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));

                        // Add marker on map
                        googleMap.addMarker(markerOptions);
                    }
                });
            }
        });

        // Return view
        return view;
    }
}