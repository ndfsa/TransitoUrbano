package edu.upb.transitourbano.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;

import edu.upb.transitourbano.R;
import edu.upb.transitourbano.models.repository.Base;
import edu.upb.transitourbano.models.ui.UserLogged;
import edu.upb.transitourbano.viewmodel.LoginViewModel;

public class RegisterActivity extends AppCompatActivity {

    private Context context;

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button registerButton;

    private LoginViewModel viewModel;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        this.context = this;
        initUI();
        initEvents();



    }

    private void initUI(){
        this.emailEditText = findViewById(R.id.emailEditText);
        this.passwordEditText = findViewById(R.id.passwordEditText);
        this.registerButton = findViewById(R.id.registerButton);
    }

    private void initEvents(){

        this.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {
                    if (!email.contains("@")) {
                        emailEditText.setError("Invalid Email");
                    }


                    LiveData<Base> result = viewModel.register(email, password);
                    result.observe(RegisterActivity.this, new Observer<Base>() {
                        @Override
                        public void onChanged(Base base) {
                            if (base.isSuccess()) {
                                Toast.makeText(context,
                                        R.string.user_create,
                                        Toast.LENGTH_SHORT)
                                        .show();

                                Intent intent = new Intent(context, LoginActivity.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(context,
                                        base.getMessage(),
                                        Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(context,
                            "Please enter all mandatory fields",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });


    }


}
