package edu.upb.transitourbano.viewmodel;

import java.util.List;

import edu.upb.transitourbano.models.Discount;
import edu.upb.transitourbano.models.ui.UserLogged;

public class UserViewModel {

    public UserViewModel() {
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
