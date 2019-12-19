package edu.upb.transitourbano.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.lang.reflect.Type;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import edu.upb.transitourbano.R;
import edu.upb.transitourbano.models.Discount;
import edu.upb.transitourbano.models.RoadBlock;
import edu.upb.transitourbano.models.repository.Base;
import edu.upb.transitourbano.ui.activities.AddRoadBlockActivity;
import edu.upb.transitourbano.utils.Constants;
import edu.upb.transitourbano.viewmodel.RoadblockViewModel;
import edu.upb.transitourbano.viewmodel.UserViewModel;

public class MapFragment extends BaseFragment implements OnMapReadyCallback {

    private GoogleMap map;
    private MapView mapView;
    private Context context;
    private RoadBlock roadBlock;
    private List<RoadBlock> roadBlockList;
    private ClusterManager<ClusterItem> clusterManager;
    private RoadblockViewModel roadblockViewModel;

    private Marker marker;
    private FloatingActionButton floatingActionButton;
    private UserViewModel userViewModel;
    private Type RoadblockList = new TypeToken<ArrayList<RoadBlock>>(){}.getType();

    public MapFragment(Context context) {
        super();
        this.context = context;
        roadBlockList = new LinkedList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        roadblockViewModel = new ViewModelProvider(this).get(RoadblockViewModel.class);
        initUI(view);
        initMap(savedInstanceState);
        return view;
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setZoomControlsEnabled(true);

        LatLng maker = new LatLng(Constants.DEFAULT_LAT, Constants.DEFAULT_LNG);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(maker, Constants.DEFAULT_ZOOM));

        clusterManager = initClusterManager();
        initListenersObservers();
        fillRoadblocksList();
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

    private ClusterManager<ClusterItem> initClusterManager(){
        final ClusterManager<ClusterItem> clusterManager = new ClusterManager<>(context, map);
        if(userViewModel.getEmail().equals("debug@gmail.com")){
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

                        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                        List<Address> addresses = null;

                        roadBlock = new RoadBlock(System.currentTimeMillis(), "placeholder", "placeholder", userViewModel.getEmail(), latLng);
                        try {
                            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                            roadBlock.setAddress(addresses.get(0).getAddressLine(0));
                        } catch (IOException e) {
                            e.printStackTrace();
                            roadBlock.setAddress("Conection error");
                        }
                        Log.e("Map","pressed: " + roadBlock.getAddress());
                        marker = map.addMarker(new MarkerOptions().position(roadBlock.getPosition()).title(roadBlock.getSnippet()));
                        marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.marker));
                    } else {
                        roadBlock = null;
                        marker.remove();
                    }
                }
            });
        }
        return clusterManager;
    }

    private void fillRoadblocksList() {
        roadblockViewModel.getRoadblocks().observe(this, new Observer<Base>() {
            @Override
            public void onChanged(Base base) {
                Gson gson = new Gson();
                String values = gson.toJson(base.getData());
                Log.e("Roadblocks", values);
                roadBlockList = gson.fromJson(values, RoadblockList);
                clusterManager.clearItems();
                fillRoadblocksOnMap();
                clusterManager.cluster();
            }
        });
    }

    private void fillRoadblocksOnMap(){
        for(RoadBlock r : roadBlockList){
            clusterManager.addItem(r);
        }
    }

    private void initListenersObservers(){
        // on move listener
        map.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
            @Override
            public void onCameraMove() {
                clusterManager.cluster();
            }
        });

        // on click listener
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(roadBlock == null){
                    Log.e("Map","pressed: null");
                    Toast.makeText(context,"Put a marker first",Toast.LENGTH_SHORT).show();
                }else{
                    Log.e("Map","pressed: " + roadBlock.getPosition().latitude + ", "+ roadBlock.getPosition().longitude);
                    Intent intent = new Intent(context, AddRoadBlockActivity.class);
                    intent.putExtra("roadblock", new Gson().toJson(roadBlock));
                    intent.putExtra("dbIndex", (long)roadBlockList.size());
                    marker.remove();
                    getActivity().startActivity(intent);
                }
            }
        });
    }
}
