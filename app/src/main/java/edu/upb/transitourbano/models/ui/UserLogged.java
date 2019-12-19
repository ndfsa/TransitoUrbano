package edu.upb.transitourbano.models.ui;

import android.util.Log;

import java.util.List;

import edu.upb.transitourbano.models.Discount;
import edu.upb.transitourbano.utils.DiscountsUtils;


public class UserLogged {

    private double rating;
    private static List<Discount> discountList;
    private String email = "fr@gmail.com";

    private static UserLogged ourInstance;
    private DiscountsUtils discountsUtils;

    public static UserLogged getInstance() {
        if(ourInstance == null){
            ourInstance = new UserLogged();
        }
        return ourInstance;
    }


    private UserLogged() {
        this.discountsUtils = new DiscountsUtils();
        this.discountList = discountsUtils.getDiscountList();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Discount> getDiscountList() {
        return discountList;
    }

    public static void setDiscountList(List<Discount> discountList) {
        UserLogged.discountList = discountList;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
