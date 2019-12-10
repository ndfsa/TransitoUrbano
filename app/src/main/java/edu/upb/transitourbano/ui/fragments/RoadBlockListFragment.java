package edu.upb.transitourbano.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.List;

import edu.upb.transitourbano.R;

import edu.upb.transitourbano.ui.adapters.RoadBlockListAViewAdapter;
import edu.upb.transitourbano.models.RoadBlock;
import edu.upb.transitourbano.utils.RoadBlockUtils;

public class RoadBlockListFragment extends BaseFragment {

    private ListView listview;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_road_block_list, container, false);
        initViews(view);
        populateList();
        return view;

    }

    private void initViews(View view) {

        listview = view.findViewById(R.id.listOfBloquedRoads);
    }

    private void populateList() {
        List<RoadBlock> roadBlocks = RoadBlockUtils.getBlockedRoads();
        RoadBlockListAViewAdapter adapter = new RoadBlockListAViewAdapter(context, roadBlocks);
        listview.setAdapter(adapter);
    }

}
