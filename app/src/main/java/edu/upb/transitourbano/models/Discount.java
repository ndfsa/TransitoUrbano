package edu.upb.transitourbano.models;

public class Discount {

    private String name;

    private int discountRate;

    public Discount(String name, int discountRate) {
        this.name = name;
        this.discountRate = discountRate;
    }

    public String getName() {
        return name;
    }

    public int getDiscountRate() {
        return discountRate;
    }
}
