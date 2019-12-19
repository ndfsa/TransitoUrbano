package edu.upb.transitourbano.models;

import java.util.List;

public class User {

    private double rating;

    private String email;

    private List<Discount> discountList;


    public User(double rating, String email, List<Discount> userDiscounts) {
        this.rating = rating;
        this.email = email;
        this.discountList = userDiscounts;
    }

    public String getEmail() {
        return email;
    }

    public double getRating() {
        return rating;
    }

    public List<Discount> getUserDiscounts() {
        return discountList;
    }
}
