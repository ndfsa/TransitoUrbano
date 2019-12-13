package edu.upb.transitourbano.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import java.util.List;

import edu.upb.transitourbano.R;
import edu.upb.transitourbano.models.Base;
import edu.upb.transitourbano.models.Discount;
import edu.upb.transitourbano.models.User;
import edu.upb.transitourbano.models.ui.UserLogged;
import edu.upb.transitourbano.ui.adapters.UserDiscountAdapter;
import edu.upb.transitourbano.viewmodel.UserViewModel;

public class UserFragment extends BaseFragment {

    private ListView listView;
    private UserViewModel userViewModel;
    public UserFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        userViewModel = new UserViewModel();
        subscribe();
        initUI(view);
        populateList();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initUI(View view) {
        listView = view.findViewById(R.id.listViewDiscounts);
    }

    private void populateList() {
        UserDiscountAdapter adapter = new UserDiscountAdapter(context, UserLogged.getInstance().getDiscountList());
        listView.setAdapter(adapter);
    }
    private void subscribe(){
        userViewModel.getDiscountList().observe(this, new Observer<Base>() {
            @Override
            public void onChanged(Base base) {
                Log.e("observer value", "" + base.getData());
                if (base.isSuccess()) {
                    User user = (User)base.getData();
                    List<Discount> discountList = user.getUserDiscounts();
                    UserLogged.getInstance().setDiscountList(discountList);
                } else {
                    Log.e("Error:", base.getMessage());
                    if (base.getException() != null) {
                        Log.e("Exception:", "" + base.getException().getMessage());
                    }
                }
            }
        });
    }
}
