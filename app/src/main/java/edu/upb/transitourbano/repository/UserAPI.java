package edu.upb.transitourbano.repository;
import java.util.HashMap;

import edu.upb.transitourbano.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface UserAPI {
    @GET("api%2Fusers.json")
    Call<User> getUser(@Query("alt") String alt);
}
