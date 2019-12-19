package edu.upb.transitourbano.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import edu.upb.transitourbano.models.TopRoadBlock;
import edu.upb.transitourbano.models.repository.Base;
import edu.upb.transitourbano.repository.firebase.FirebaseRepository;
import java.util.List;

import edu.upb.transitourbano.models.Discount;
import edu.upb.transitourbano.repository.local.LocalRepository;
import edu.upb.transitourbano.utils.DiscountsUtils;

public class Repository implements  RepositoryImpl{

    public static Repository instance;
    private LocalRepository local;


    private static final Repository ourInstance = new Repository();

    private List<Discount> discountList;

    private DiscountsUtils discountsUtils;

    public static Repository getInstance(Application application) {
        if (instance == null){
            instance = new Repository();
        }
        return instance;
    }
    private Repository() {
        this.discountsUtils = new DiscountsUtils();
        this.discountList = discountsUtils.getDiscountList();
    }

    public List<Discount> getDiscounts(){
        return discountList;
    }

    @Override
    public LiveData<Base> login(String email, String password) {
        return FirebaseRepository.getInstance().login(email,password);
    }

    @Override
    public LiveData<Base> register(String email, String password) {
        return FirebaseRepository.getInstance().register(email,password);
    }

    @Override
    public void insert(TopRoadBlock topRoadBlock) {
        local.insert(topRoadBlock);
    }

    @Override
    public LiveData<List<TopRoadBlock>> getAll() {
        return local.getAll();
    }


}
