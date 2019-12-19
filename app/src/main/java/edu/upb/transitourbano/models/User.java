package edu.upb.transitourbano.models;

import java.util.List;

public class User {

    private double rating;

    private String email;

    private List<Discount> discountList;


    public User(double rating, String email, List<Discount> discountList) {
        this.rating = rating;
        this.email = email;
        this.discountList = discountList;
    }

    public String getEmail() {
        return email;
    }

    public double getRating() {
        return rating;
    }

    public List<Discount> getDiscountList() {
        return discountList;
    }
}
