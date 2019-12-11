package edu.upb.transitourbano.utils;

import java.util.LinkedList;
import java.util.List;

import edu.upb.transitourbano.models.Discount;

public class DiscountsUtils {
    private List<Discount> discountList = new LinkedList<>();

    public List<Discount> getDiscountList() {
        discountList.add(new Discount("Puma Katari", 30));
        discountList.add(new Discount("Puma Katari", 20));
        discountList.add(new Discount("CineCenter", 50));
        discountList.add(new Discount("Puma Katari", 50));
        discountList.add(new Discount("CineCenter", 50));
        discountList.add(new Discount("Pedidos Ya", 90));
        discountList.add(new Discount("CineCenter", 50));


        return discountList;
    }
}
