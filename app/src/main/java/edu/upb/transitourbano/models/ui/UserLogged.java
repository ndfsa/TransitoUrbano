package edu.upb.transitourbano.models.ui;

import android.util.Log;

import java.util.List;

import edu.upb.transitourbano.models.Discount;
import edu.upb.transitourbano.utils.DiscountsUtils;


public class UserLogged {

    private DiscountsUtils discountsUtils;

    private static UserLogged ourInstance;

    public static UserLogged getInstance() {
        if(ourInstance == null){
            ourInstance = new UserLogged();
        }
        return ourInstance;
    }

    private static String email = "fr@gmail.com";

    private static List<Discount> discountList;

    private UserLogged() {
        this.discountsUtils = new DiscountsUtils();
        this.discountList = discountsUtils.getDiscountList();
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static List<Discount> getDiscountList() {
        return discountList;
    }

    public static void setDiscountList(List<Discount> discountList) {
        UserLogged.discountList = discountList;
    }
}
