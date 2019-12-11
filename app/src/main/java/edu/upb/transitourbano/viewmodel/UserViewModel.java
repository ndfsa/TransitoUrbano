package edu.upb.transitourbano.viewmodel;

import java.util.List;

import edu.upb.transitourbano.models.Discount;
import edu.upb.transitourbano.repository.Repository;

public class UserViewModel {
    private List<Discount> discountList;

    public UserViewModel() {
        this.discountList = Repository.getInstance().getDiscounts();
    }

    public List<Discount> getDiscountList() {
        return discountList;
    }
}
