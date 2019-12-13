package edu.upb.transitourbano.repository;

import androidx.lifecycle.LiveData;

import edu.upb.transitourbano.models.repository.Base;
import edu.upb.transitourbano.repository.firebase.FirebaseRepository;

public class Repository implements  RepositoryImpl{

    public static Repository instance;

    public static Repository getInstance() {
        if (instance == null){
            instance = new Repository();
        }
        return instance;
    }

    private Repository() {
    }

    @Override
    public LiveData<Base> login(String email, String password) {
        return FirebaseRepository.getInstance().login(email,password);
    }
}
