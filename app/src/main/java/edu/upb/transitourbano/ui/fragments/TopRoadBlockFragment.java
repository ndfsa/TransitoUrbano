package edu.upb.transitourbano.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;

import java.util.List;

import edu.upb.transitourbano.R;
import edu.upb.transitourbano.models.TopRoadBlock;
import edu.upb.transitourbano.ui.adapters.TopRoadBlockAdapter;
import edu.upb.transitourbano.utils.TopRoadBlockUtils;
import edu.upb.transitourbano.viewmodel.TopRoadBlockViewModel;

public class TopRoadBlockFragment extends BaseFragment {

    private ListView listview;
    private TopRoadBlockViewModel viewModel;
    private Button dbButtom;
    private int count = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_road_block, container, false);
        viewModel = new ViewModelProvider(this).get(TopRoadBlockViewModel.class);
        initViews(view);
        populateList();
        return view;
    }

    private void initViews(View view) {

        listview = view.findViewById(R.id.listTopRoadblock);
        dbButtom = view.findViewById(R.id.dbButton);
    }

    private void populateList() {
        List<TopRoadBlock> topRoadBlocks = TopRoadBlockUtils.getTopBlockedRoads();
        TopRoadBlockAdapter adapter = new TopRoadBlockAdapter(context, topRoadBlocks);
        listview.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                final TopRoadBlock topRoadBlock = new TopRoadBlock();
                topRoadBlock.setId(count);
                topRoadBlock.setAdress("Dir "+count);
                topRoadBlock.setProba("50%");
                topRoadBlock.setRank("#8");
                viewModel.register(topRoadBlock);
                Log.e("fragment","id "+topRoadBlock.getId());

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.getAll().observe(this, new Observer<List<TopRoadBlock>>() {
            @Override
            public void onChanged(List<TopRoadBlock> topRoadBlockList) {
                Log.e("Top road Block", new Gson().toJson(topRoadBlockList));
            }
        });
    }


}
