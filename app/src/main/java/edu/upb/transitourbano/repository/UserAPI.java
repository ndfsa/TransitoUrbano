package edu.upb.transitourbano.repository;
import java.util.List;

import edu.upb.transitourbano.models.Discount;
import edu.upb.transitourbano.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface UserAPI {
    @GET("api%2Fuser.json")
    Call<User> getDiscounts(@Query("user_email") String email,
                            @Query("alt") String alt);
}
