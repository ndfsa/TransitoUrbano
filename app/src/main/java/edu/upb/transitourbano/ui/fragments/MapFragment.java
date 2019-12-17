package edu.upb.transitourbano.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import edu.upb.transitourbano.R;
import edu.upb.transitourbano.utils.Constants;

public class MapFragment extends BaseFragment implements OnMapReadyCallback {

    private GoogleMap map;
    private MapView mapView;

    public MapFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        initUI(view);
        initMap(savedInstanceState);
        return view;
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setZoomControlsEnabled(true);
        //map.getUiSettings().isMyLocationButtonEnabled();
        //map.setMyLocationEnabled(true);
        //map.getUiSettings().setZoomGesturesEnabled(true);
        //map.setPadding(0, 0, 0, mapView.getHeight());

        LatLng maker = new LatLng(Constants.DEFAULT_LAT, Constants.DEFAULT_LNG);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(maker, Constants.DEFAULT_ZOOM));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initUI(View view) {
        mapView = view.findViewById(R.id.map);

    }

    private void initMap(Bundle savedInstanceState) {
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        try {
            MapsInitializer.initialize(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mapView.getMapAsync(this);
    }



}
