package edu.upb.transitourbano.models;

public class Discount {

    private String name;

    private int Id;

    private int discountRate;

    public Discount(String name, int discountRate) {
        this.name = name;
        this.discountRate = discountRate;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getDiscountRate() {
        return discountRate + "%";
    }
}
