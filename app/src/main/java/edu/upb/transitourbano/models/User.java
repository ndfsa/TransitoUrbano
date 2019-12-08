package edu.upb.transitourbano.models;

import java.util.List;

public class User {

    private int userID;

    private String name;

    private String reputation;

    private int image;

    private Discount userDiscounts;

    public User(int userID, String name, String reputation, int image, Discount userDiscounts) {
        this.userID = userID;
        this.name = name;
        this.reputation = reputation;
        this.image = image;
        this.userDiscounts = userDiscounts;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getReputation() {
        return reputation;
    }

    public int getImage() {
        return image;
    }

    public Discount getUserDiscounts() {
        return userDiscounts;
    }
}
