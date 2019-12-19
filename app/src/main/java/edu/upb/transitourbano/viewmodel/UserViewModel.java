package edu.upb.transitourbano.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

import edu.upb.transitourbano.models.Discount;
import edu.upb.transitourbano.models.ui.UserLogged;

public class UserViewModel extends AndroidViewModel {

    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public List<Discount> getDiscountList(){
        return UserLogged.getInstance().getDiscountList();
    }

    public double getRating(){
        return UserLogged.getInstance().getRating();
    }

    public String getEmail(){
        return UserLogged.getInstance().getEmail();
    }
}
