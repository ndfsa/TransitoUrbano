package edu.upb.transitourbano.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.upb.transitourbano.models.TopRoadBlock;
import edu.upb.transitourbano.models.repository.Base;

public interface RepositoryImpl {

    LiveData<Base> login(String email, String password);
    LiveData<Base> register(String email, String password);

    //Db
    void insert(TopRoadBlock user);

    //Db
    LiveData<List<TopRoadBlock>> getAll();
}
