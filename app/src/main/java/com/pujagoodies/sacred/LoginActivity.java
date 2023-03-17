package com.pujagoodies.sacred;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.pujagoodies.sacred.R;
//import com.example.playvideota.R;
import com.pujagoodies.sacred.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    FirebaseAuth auth;
    FirebaseDatabase database;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());

//        setContentView(R.layout.activity_login);
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        currentUser = auth.getCurrentUser();

        binding.loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.loginBTN.setVisibility(View.GONE);
                String email = binding.emailETL.getText().toString();
                String password = binding.passwordETL.getText().toString();


                if((email.equalsIgnoreCase("")) || (password.equalsIgnoreCase(""))){
                    Toast.makeText(LoginActivity.this, "Enter Required Fields", Toast.LENGTH_SHORT).show();
                    binding.loginBTN.setVisibility(View.VISIBLE);
                }else {



                    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                binding.loginBTN.setVisibility(View.VISIBLE);
                                Intent intent = new Intent(LoginActivity.this, MandirDummyActivity.class);
                                startActivity(intent);
                            }else{
                                binding.loginBTN.setVisibility(View.VISIBLE);
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(LoginActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                                Toast.makeText(LoginActivity.this, task.getException().getMessage().toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        binding.goToRegister.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        if(currentUser != null){
            Intent intent = new Intent(LoginActivity.this , MandirDummyActivity.class);
            startActivity(intent);
        }
    }
}