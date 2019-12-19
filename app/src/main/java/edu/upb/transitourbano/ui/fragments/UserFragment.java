package edu.upb.transitourbano.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import edu.upb.transitourbano.R;
import edu.upb.transitourbano.models.User;
import edu.upb.transitourbano.models.ui.UserLogged;
import edu.upb.transitourbano.ui.adapters.UserDiscountAdapter;
import edu.upb.transitourbano.viewmodel.UserViewModel;

public class UserFragment extends BaseFragment {

    private ListView listView;
    private TextView textView;
    private UserViewModel userViewModel;
    private RatingBar ratingBar;
    public UserFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        initUI(view);
        populateList();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView.setText(userViewModel.getEmail());
        ratingBar.setRating((float)userViewModel.getRating());

    }

    private void initUI(View view) {
        listView = view.findViewById(R.id.listViewDiscounts);
        textView = view.findViewById(R.id.userFragmentTextView);
        ratingBar = view.findViewById(R.id.userFragmentRating);

    }

    private void populateList() {
        UserDiscountAdapter adapter = new UserDiscountAdapter(context, userViewModel.getDiscountList());
        listView.setAdapter(adapter);
    }

}
