package edu.upb.transitourbano.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.upb.transitourbano.R;
import edu.upb.transitourbano.models.RoadBlock;

public class RoadBlockListAViewAdapter extends BaseAdapter {

    private Context context;
    private List<RoadBlock> roadBlockList;

    public RoadBlockListAViewAdapter(Context context, List<RoadBlock> roadBlockList) {
        this.context = context;
        this.roadBlockList = roadBlockList;
    }


    @Override
    public int getCount() {
        return this.roadBlockList.size();
    }

    @Override
    public RoadBlock getItem(int position) {
        return this.roadBlockList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.roadBlockList.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.road_block_list_item, null);

            viewHolder.textViewAdress = view.findViewById(R.id.textViewAdress);
            viewHolder.textViewInfo = view.findViewById(R.id.textViewInfo);
            viewHolder.textViewInformant = view.findViewById(R.id.textViewInformant);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        RoadBlock roadBlock = this.roadBlockList.get(position);
        viewHolder.textViewAdress.setText(roadBlock.getAdress());
        viewHolder.textViewInfo.setText(roadBlock.getInfo());
        viewHolder.textViewInformant.setText(roadBlock.getInformant());
        return view;
    }

    static class ViewHolder {
        TextView textViewAdress;
        TextView textViewInfo;
        TextView textViewInformant;
    }
}