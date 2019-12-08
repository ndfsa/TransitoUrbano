package edu.upb.transitourbano.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import edu.upb.transitourbano.R;
import edu.upb.transitourbano.adapters.RoadBlockListAViewAdapter;
import edu.upb.transitourbano.models.RoadBlock;
import edu.upb.transitourbano.utils.RoadBlockUtils;

public class RoadBlockListActivity extends AppCompatActivity {

    private ListView listview;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_block_list);
        initViews();

        List<RoadBlock> roadBlocks = RoadBlockUtils.getBlockedRoads();
        RoadBlockListAViewAdapter adapter = new RoadBlockListAViewAdapter(this, roadBlocks);
        listview.setAdapter(adapter);

    }
    private void initViews() {

        listview = findViewById(R.id.listOfBloquedRoads);
    }

}
