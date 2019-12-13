package edu.upb.transitourbano.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;

import edu.upb.transitourbano.models.Base;
import edu.upb.transitourbano.repository.ApiRepository;

public class UserViewModel {
    private LiveData<Base> base;

    public UserViewModel() {
    }

    public LiveData<Base> getDiscountList() {
        LiveData<Base> j = ApiRepository.getInstance().getUser();
        Log.e("error", ""+j.getValue());
        return j;
    }
}
