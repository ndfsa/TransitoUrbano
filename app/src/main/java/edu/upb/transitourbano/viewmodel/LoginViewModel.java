package edu.upb.transitourbano.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.google.firebase.auth.FirebaseUser;

import edu.upb.transitourbano.models.repository.Base;
import edu.upb.transitourbano.models.ui.UserLogged;
import edu.upb.transitourbano.repository.Repository;
import edu.upb.transitourbano.repository.RepositoryImpl;

public class LoginViewModel extends AndroidViewModel {

    private RepositoryImpl repository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance();
    }

    public LiveData<Base> login(final String email, String password){
        final MutableLiveData<Base>result = new MutableLiveData<>();
        repository.login(email, password).observeForever(new Observer<Base>() {
            @Override
            public void onChanged(Base base) {
                if (base.isSuccess()) {
                    UserLogged userLogged = new UserLogged(email);
                    result.postValue(new Base(userLogged));
                } else {
                    result.postValue(base);
                }
            }
        });
        return result;
    }


    public LiveData<Base> register(final String email, String password){
        final MutableLiveData<Base>result = new MutableLiveData<>();
        repository.register(email, password).observeForever(new Observer<Base>() {
            @Override
            public void onChanged(Base base) {
                if (base.isSuccess()) {
                    UserLogged userLogged = new UserLogged(email);
                    result.postValue(new Base(userLogged));
                } else {
                    result.postValue(base);
                }
            }
        });
        return result;
    }

}
