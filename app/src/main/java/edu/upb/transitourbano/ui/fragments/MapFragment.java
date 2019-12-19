package edu.upb.transitourbano.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import edu.upb.transitourbano.R;
import edu.upb.transitourbano.models.MyClusterItem;
import edu.upb.transitourbano.models.RoadBlock;
import edu.upb.transitourbano.ui.activities.AddRoadBlockActivity;
import edu.upb.transitourbano.utils.Constants;

public class MapFragment extends BaseFragment implements OnMapReadyCallback {

    private GoogleMap map;
    private MapView mapView;
    private Context context;
    private RoadBlock roadBlock;
    private FloatingActionButton floatingActionButton;

    public MapFragment(Context context) {
        super();
        this.context = context;
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

        final ClusterManager<ClusterItem> clusterManager = new ClusterManager<>(context, map);

        if(false){
            map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    //map.addMarker(new MarkerOptions().position(latLng));
                    clusterManager.addItem(new RoadBlock(1, "hello", "world", "hugo", latLng));
                    clusterManager.cluster();
                }
            });
        }else{
            map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    //map.addMarker(new MarkerOptions().position(latLng));
                    if (roadBlock == null){
                        roadBlock = new RoadBlock(1, "Hello :D", "Possible roadblock", "hugo", latLng);

                        Geocoder geocoder = new Geocoder(context, Locale.getDefault());


                        List<Address> addresses = null;
                        try {
                            addresses = geocoder.getFromLocation(roadBlock.getLatLng().latitude, roadBlock.getLatLng().longitude, 1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        roadBlock.setAdress(addresses.get(0).getAddressLine(0));
                            Log.e("Map","pressed: " + roadBlock.getAdress());
                            clusterManager.addItem(roadBlock);


                    }else{
                        clusterManager.removeItem(roadBlock);
                        roadBlock = null;
                    }
                    clusterManager.cluster();
                }
            });
        }

        map.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
            @Override
            public void onCameraMove() {
                clusterManager.cluster();
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(roadBlock == null){
                    Log.e("Map","pressed: null");
                    Toast.makeText(context,"put a marker first",Toast.LENGTH_SHORT).show();
                }else{
                    Log.e("Map","pressed: " + roadBlock.getLatLng().latitude + ", "+ roadBlock.getLatLng().longitude);
                    double lat = roadBlock.getLatLng().latitude;
                    double lng = roadBlock.getLatLng().longitude;
                    Intent intent = new Intent(context, AddRoadBlockActivity.class);
                    intent.putExtra("lat",lat);
                    intent.putExtra("lng",lng);
                    intent.putExtra("address",roadBlock.getAdress());
                    getActivity().startActivity(intent);

                }
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initUI(View view) {
        mapView = view.findViewById(R.id.map);
        floatingActionButton = view.findViewById(R.id.fab);

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
