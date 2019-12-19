package edu.upb.transitourbano.repository.firebase;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.List;

import edu.upb.transitourbano.R;
import edu.upb.transitourbano.models.Discount;
import edu.upb.transitourbano.models.User;
import edu.upb.transitourbano.models.repository.Base;
import edu.upb.transitourbano.models.ui.UserLogged;

public class FirebaseRepository{

    private static FirebaseRepository instance;
    private FirebaseAuth auth;
    private FirebaseDatabase firebaseDatabase;

    public static FirebaseRepository getInstance() {
        if (instance == null) {
            instance = new FirebaseRepository();
        }
        return instance;
    }

    private FirebaseRepository() {
        auth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
    }

    public LiveData<Base> login(final String email, final String password) {
        final MutableLiveData<Base> results = new MutableLiveData<>();
        this.auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            UserLogged.getInstance().setEmail(user.getEmail());
                            String path = "users/" + user.getEmail().split("@")[0];
                            subscribeToValues(path);
                            Log.e("user is", user.getEmail() + " subscribed to: " + path);
                            results.postValue(new Base(user));

                        } else {
                            Log.e("user","Failed");
                            results.postValue(new Base("login Failure",
                                    new NullPointerException()));
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        results.postValue(new Base("login.onFailure", e));
                    }
                });
        return results;
    }

    public LiveData<Base> register(final String email, String password) {
        final MutableLiveData<Base> results = new MutableLiveData<>();
        this.auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            List<Discount> discountList = new LinkedList<>();
                            discountList.add(new Discount("Puma", "ds01", "For one use only", 20));
                            User user = new User(0, email, discountList);
                            String path = "users/" + user.getEmail().split("@")[0];
                            setValue(path, user);
                            Log.e("new user is",  new Gson().toJson(user)+ " path: " + path);
                            results.postValue(new Base(firebaseUser));
                        } else {
                            Log.e("create error", "maybe null");
                            results.postValue(new Base("Register Failure",
                                    new NullPointerException()));
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        results.postValue(new Base("register.onFailure", e));
                    }
                });
        return results;
    }

    public LiveData<Base> setValue(String path, Object value) {
        final MutableLiveData<Base> result = new MutableLiveData<>();
        firebaseDatabase.getReference(path).setValue(value);
        return result;
    }

    public LiveData<Base> subscribeToValues(String path) {
        final MutableLiveData<Base> result = new MutableLiveData<>();
        firebaseDatabase.getReference(path).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String values = new Gson().toJson(dataSnapshot.getValue());
                User user = new Gson().fromJson(values, User.class);
                UserLogged.getInstance().setDiscountList(user.getDiscountList());
                UserLogged.getInstance().setRating(user.getRating());
                Log.e("Database", values);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("database error", databaseError.getMessage());
            }
        });
        return result;
    }

}
