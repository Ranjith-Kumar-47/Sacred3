package com.pujagoodies.sacred;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.playvideota.R;
import com.example.playvideota.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.pujagoodies.sacred.model.RegisterUserModel;


public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;
    // for firebase authentication
    FirebaseAuth auth;

    // for database
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());

//        setContentView(R.layout.activity_register);
        setContentView(binding.getRoot());

        initData();

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((binding.emailET.getText().toString().equalsIgnoreCase("")) || (binding.passwordET.getText().toString().equalsIgnoreCase("")) || (binding.nameET.getText().toString().equalsIgnoreCase(""))) {
                    Toast.makeText(RegisterActivity.this, "Enter all Fields", Toast.LENGTH_SHORT).show();
                } else {
                    binding.signup.setVisibility(View.GONE);
                    auth.createUserWithEmailAndPassword(binding.emailET.getText().toString(), binding.passwordET.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        binding.signup.setVisibility(View.VISIBLE);
                                        RegisterUserModel user = new RegisterUserModel(binding.nameET.getText().toString(),
                                                binding.emailET.getText().toString(),
                                                binding.passwordET.getText().toString());

                                        //getting the unquie id for user
                                        String id = task.getResult().getUser().getUid();
                                        database.getReference().child("users").child(id).setValue(user);
                                        Toast.makeText(RegisterActivity.this, "User data saved successfully...", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        startActivity(intent);

                                    } else {
                                        binding.signup.setVisibility(View.VISIBLE);
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                        Toast.makeText(RegisterActivity.this, task.getException().getMessage().toString(), Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                }

            }
        });

        binding.goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // intent are used to go activity to different activity
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {
    }
}