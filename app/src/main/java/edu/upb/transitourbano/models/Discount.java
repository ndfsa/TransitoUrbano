package edu.upb.transitourbano.models;

public class Discount {

    private String name;

    private String uuid;

    private String condition;

    private int discountRate;

    public Discount(String name, int discountRate) {
        this.name = name;
        this.discountRate = discountRate;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getDiscountRateString() {
        return discountRate + "%";
    }
}
