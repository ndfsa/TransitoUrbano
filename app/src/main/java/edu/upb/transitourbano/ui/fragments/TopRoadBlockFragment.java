package edu.upb.transitourbano.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.List;

import edu.upb.transitourbano.R;
import edu.upb.transitourbano.models.RoadBlock;
import edu.upb.transitourbano.models.TopRoadBlock;
import edu.upb.transitourbano.ui.adapters.RoadBlockListAViewAdapter;
import edu.upb.transitourbano.ui.adapters.TopRoadBlockAdapter;
import edu.upb.transitourbano.utils.RoadBlockUtils;
import edu.upb.transitourbano.utils.TopRoadBlockUtils;

public class TopRoadBlockFragment extends BaseFragment {

    private ListView listview;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_road_block, container, false);
        initViews(view);
        populateList();
        return view;

    }

    private void initViews(View view) {

        listview = view.findViewById(R.id.listTopRoadblock);
    }

    private void populateList() {
        List<TopRoadBlock> topRoadBlocks = TopRoadBlockUtils.getTopBlockedRoads();
        TopRoadBlockAdapter adapter = new TopRoadBlockAdapter(context, topRoadBlocks);
        listview.setAdapter(adapter);
    }

}
