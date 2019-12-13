package edu.upb.transitourbano.repository;

import androidx.lifecycle.LiveData;

import edu.upb.transitourbano.models.repository.Base;

public interface RepositoryImpl {

    LiveData<Base> login(String email, String password);
    LiveData<Base> register(String email, String password);
}
