package edu.upb.transitourbano.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import edu.upb.transitourbano.models.Base;
import edu.upb.transitourbano.models.Discount;
import edu.upb.transitourbano.models.User;
import edu.upb.transitourbano.utils.DiscountsUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepository {

    private UserAPI userAPI;
    private List<Discount> discountList;
    private DiscountsUtils discountsUtils;
    private static final ApiRepository ourInstance = new ApiRepository();

    public static ApiRepository getInstance() {
        return ourInstance;
    }

    private ApiRepository() {
        userAPI = ApiService.createService(UserAPI.class);
    }
    public List<Discount> getDiscountsList(){
        return discountList;
    }

    public LiveData<Base> getUser(String email) {
        final MutableLiveData<Base> results = new MutableLiveData<>();
        userAPI.getDiscounts(email, "alt").enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    results.postValue(new Base(response.body()));
                } else {
                    results.postValue(new Base(response.message(), new NullPointerException()));
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                results.postValue(new Base("onFailure", new Exception(t)));
            }

        });
        return results;
    }
}
