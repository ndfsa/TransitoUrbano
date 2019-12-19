package edu.upb.transitourbano.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.upb.transitourbano.R;
import edu.upb.transitourbano.models.TopRoadBlock;
import edu.upb.transitourbano.models.User;
import edu.upb.transitourbano.ui.fragments.MapFragment;
import edu.upb.transitourbano.ui.fragments.RoadBlockListFragment;
import edu.upb.transitourbano.ui.fragments.TopRoadBlockFragment;
import edu.upb.transitourbano.ui.fragments.UserFragment;
import edu.upb.transitourbano.viewmodel.TopRoadBlockViewModel;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private CoordinatorLayout parentCoordinatorLayout;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    private Map<String, Fragment> mapFragments = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        configureNavigationEvents();
        configureNavigationDrawer();
        configureToolbar();
        initFragments();
        loadFragment("mapFragment");




    }
    private void initUI() {
        this.drawerLayout = findViewById(R.id.main_drawer_layout);
        this.parentCoordinatorLayout = findViewById(R.id.parentCoordinatorLayout);
        this.appBarLayout = findViewById(R.id.appBarLayout);
        this.toolbar = findViewById(R.id.toolbar);
        this.navigationView = findViewById(R.id.navigationView);

    }
    private void configureNavigationDrawer() {
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    private void configureToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        actionBarDrawerToggle.syncState();
    }

    private void configureNavigationEvents() {
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.map:
                        loadFragment("mapFragment");
                        break;
                    case R.id.roadblock:
                        loadFragment("roadBlockFragment");
                        break;
                    case R.id.toproadblock:
                        loadFragment("topRoadBlockFragment");
                        break;
                    case R.id.user:
                        loadFragment("userFragment");
                        break;
                    default:
                        return true;
                }
                drawerLayout.closeDrawers();
                return true;

            }
        });
    }

    private void initFragments() {
        mapFragments.put("mapFragment", new MapFragment());
        mapFragments.put("userFragment", new UserFragment());
        mapFragments.put("roadBlockFragment", new RoadBlockListFragment());
        mapFragments.put("topRoadBlockFragment", new TopRoadBlockFragment());

    }

    private void goToRoadblockList(){
        Intent intent = new Intent(this, RoadBlockListFragment.class);
        startActivity(intent);
    }

    private void loadFragment(String key) {
        if (mapFragments.containsKey(key)) {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.containerFrameLayout, mapFragments.get(key), key)
                    .commit();
        }
    }
}
