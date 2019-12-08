package edu.upb.transitourbano.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import edu.upb.transitourbano.ui.activities.MainActivity;


public class BaseFragment extends Fragment {

    protected MainActivity activity;
    protected Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof MainActivity) {
            this.activity = (MainActivity) context;
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        this.context = null;
    }

}
