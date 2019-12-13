package edu.upb.transitourbano.models;

import java.util.List;

public class User {

    private int userID;

    private String name;

    private String rating;

    private int image;

    private String email;

    private List<Discount> discountList;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(int userID, String name, String rating, int image, String email, List<Discount> userDiscounts) {
        this.userID = userID;
        this.name = name;
        this.rating = rating;
        this.image = image;
        this.email = email;
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
