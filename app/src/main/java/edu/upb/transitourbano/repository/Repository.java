package edu.upb.transitourbano.repository;

import java.util.List;

import edu.upb.transitourbano.models.Discount;
import edu.upb.transitourbano.utils.DiscountsUtils;

public class Repository {
    private static final Repository ourInstance = new Repository();

    private List<Discount> discountList;

    private DiscountsUtils discountsUtils;

    public static Repository getInstance() {
        return ourInstance;
    }
    private Repository() {
        this.discountsUtils = new DiscountsUtils();
        this.discountList = discountsUtils.getDiscountList();
    }

    public List<Discount> getDiscounts(){
        return discountList;
    }
}
