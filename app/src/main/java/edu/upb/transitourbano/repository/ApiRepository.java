package edu.upb.transitourbano.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
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
    private static ApiRepository ourInstance;

    public static ApiRepository getInstance() {
        if (ourInstance == null) {
            ourInstance = new ApiRepository();
        }
        return ourInstance;
    }

    private ApiRepository() {
        userAPI = ApiService.createService(UserAPI.class);
    }
    public List<Discount> getDiscountsList(){
        return discountList;
    }

    public LiveData<Base> getUser() {
        final MutableLiveData<Base> results = new MutableLiveData<>();
        Log.e("error", "requested");
        userAPI.getUser("media").enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    results.postValue(new Base(response.body()));
                } else {
                    results.postValue(new Base(response.message(), new NullPointerException()));
                    Log.e("error", "null pointer on base");
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                results.postValue(new Base("onFailure", new Exception(t)));
                Log.e("error", "failure on request");
            }
        });
        return results;
    }
}
