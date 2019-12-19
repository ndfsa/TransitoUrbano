package edu.upb.transitourbano.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import edu.upb.transitourbano.R;
import edu.upb.transitourbano.models.RoadBlock;
import edu.upb.transitourbano.viewmodel.RoadblockViewModel;

public class AddRoadBlockActivity extends AppCompatActivity {

    private EditText addressEditText;
    private EditText infoEditText;
    private Button button;
    private RoadBlock roadBlock;
    private long dbIndex;

    private RoadblockViewModel roadblockViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_road_block);
        roadblockViewModel = new ViewModelProvider(this).get(RoadblockViewModel.class);
        initUI();
        getRoadBlockInfo();
        initEvents();
    }

    private void getRoadBlockInfo() {
        Intent intent = getIntent();
        if(intent.hasExtra("roadblock")){
            roadBlock = new Gson().fromJson(intent.getStringExtra("roadblock"), RoadBlock.class);
            dbIndex = intent.getLongExtra("dbIndex",0);
        }else{
            Toast.makeText(this,
                    "Error getting map information",
                    Toast.LENGTH_SHORT)
                    .show();
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
                if(infoEditText.getText().toString().equals("")){
                    Toast.makeText(view.getContext(),
                            "Cannot send empty description",
                            Toast.LENGTH_SHORT)
                            .show();
                }else{
                    roadBlock.setInfo(infoEditText.getText().toString());
                    roadblockViewModel.setRoadblock(roadBlock, dbIndex);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        addressEditText.setText(roadBlock.getAddress());
    }
}
