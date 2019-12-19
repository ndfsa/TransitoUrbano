package edu.upb.transitourbano.repository;

import android.app.Application;
import android.util.Log;

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

    private List<Discount> discountList;

    private DiscountsUtils discountsUtils;

    public static Repository getInstance(Application application) {
        if (instance == null){
            instance = new Repository(application);
        }
        return instance;
    }
    private Repository(Application application) {
        this.discountsUtils = new DiscountsUtils();
        this.discountList = discountsUtils.getDiscountList();
        this.local = new LocalRepository(application);
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
