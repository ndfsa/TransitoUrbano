package edu.upb.transitourbano.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.upb.transitourbano.R;
import edu.upb.transitourbano.models.TopRoadBlock;

public class TopRoadBlockAdapter extends BaseAdapter {

    private Context context;
    private List<TopRoadBlock> topRoadBlock;

    public TopRoadBlockAdapter(Context context, List<TopRoadBlock> topRoadBlocks) {
        this.context = context;
        this.topRoadBlock = topRoadBlocks;
    }


    @Override
    public int getCount() {
        return this.topRoadBlock.size();
    }

    @Override
    public TopRoadBlock getItem(int position) {
        return this.topRoadBlock.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.topRoadBlock.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.top_road_block_item_xml, null);

            viewHolder.textViewAdress = view.findViewById(R.id.textViewAdress);
            viewHolder.textViewProba = view.findViewById(R.id.textViewProba);
            viewHolder.textViewRank = view.findViewById(R.id.textViewRank);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        TopRoadBlock topRoadBlock = this.topRoadBlock.get(position);
        viewHolder.textViewAdress.setText(topRoadBlock.getAdress());
        viewHolder.textViewProba.setText(topRoadBlock.getProba());
        viewHolder.textViewRank.setText(topRoadBlock.getRank());
        return view;
    }

    static class ViewHolder {
        TextView textViewAdress;
        TextView textViewProba;
        TextView textViewRank;
    }
}
