package edu.upb.transitourbano.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;

import edu.upb.transitourbano.R;

public class AddRoadBlockActivity extends AppCompatActivity {

    private EditText addressEditText;
    private EditText infoEditText;

    private Button button;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_road_block);
        this.context = this;
        initUI();
        initEvents();
        getRoadBlockInfo();
    }

    private void getRoadBlockInfo() {
        Intent intent = getIntent();
        if(intent.hasExtra("address")){
            String address = intent.getStringExtra("address");
            addressEditText.setText(address);
            double lat = intent.getDoubleExtra("lat",0.00);
            double lng = intent.getDoubleExtra("lng",0.00);
            LatLng latlng = new LatLng(lat,lng);
        }
    }

    private void initUI() {
        addressEditText = findViewById(R.id.addressTextView);
        infoEditText = findViewById(R.id.infoTextView);
        button = findViewById(R.id.addressButton);
    }

    private void initEvents(){
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
