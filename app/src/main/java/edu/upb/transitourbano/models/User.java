package edu.upb.transitourbano.models;

import java.util.List;

public class User {

    private int userID;

    private String name;

    private String rating;

    private int image;

    private List<Discount> discountList;



    public User(int userID, String name, String rating, int image, List<Discount> userDiscounts) {
        this.userID = userID;
        this.name = name;
        this.rating = rating;
        this.image = image;
        this.discountList = userDiscounts;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public int getImage() {
        return image;
    }

    public List<Discount> getUserDiscounts() {
        return discountList;
    }
}
