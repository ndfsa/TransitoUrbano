package edu.upb.transitourbano.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.upb.transitourbano.R;
import edu.upb.transitourbano.models.Discount;

public class UserDiscountAdapter extends BaseAdapter {

    private Context context;
    private List<Discount> discountList;

    public UserDiscountAdapter(Context context, List<Discount> discountList) {
        this.context = context;
        this.discountList = discountList;
    }

    @Override
    public int getCount() {
        return discountList.size();
    }

    @Override
    public Object getItem(int i) {
        return discountList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return discountList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null ){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate(R.layout.discount_list_item,null);

            viewHolder.textViewNum = view.findViewById(R.id.discoutnItemNumber);
            viewHolder.textViewName = view.findViewById(R.id.discoutnItemText);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textViewName.setText(this.discountList.get(i).getName());
        viewHolder.textViewNum.setText(this.discountList.get(i).getDiscountRateString());
        return view;
    }
    static class ViewHolder {
        TextView textViewName;
        TextView textViewNum;
    }
}
