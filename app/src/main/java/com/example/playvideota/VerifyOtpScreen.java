package com.example.playvideota;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

public class VerifyOtpScreen extends AppCompatActivity {

    EditText inputOption1,inputOption2,inputOption3,inputOption4,inputOption5,inputOption6;

    Button verifyButtonClick;
    FirebaseDatabase database;
    String getOtpBacked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp_screen);

        database = FirebaseDatabase.getInstance();

        inputOption1 = findViewById(R.id.inputOption1);
        inputOption2 = findViewById(R.id.inputOption2);
        inputOption3 = findViewById(R.id.inputOption3);
        inputOption4 = findViewById(R.id.inputOption4);
        inputOption5 = findViewById(R.id.inputOption5);
        inputOption6 = findViewById(R.id.inputOption6);

        TextView textView = findViewById(R.id.showMobileNumber);
        textView.setText(String.format(
                "+91-%s", getIntent().getStringExtra("mobile")
        ));


        getOtpBacked = getIntent().getStringExtra("backendOtp");

        final ProgressBar progressBar = findViewById(R.id.progressbar_verifying_otp);


        verifyButtonClick = findViewById(R.id.submitOtpButton);

        verifyButtonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!inputOption1.getText().toString().trim().isEmpty() &&  !inputOption2.getText().toString().trim().isEmpty() && !inputOption3.getText().toString().trim().isEmpty() && !inputOption4.getText().toString().trim().isEmpty() && !inputOption5.getText().toString().trim().isEmpty() && !inputOption6.getText().toString().trim().isEmpty() ){

                    String enterCodeOtp = inputOption1.getText().toString().trim() +
                            inputOption2.getText().toString().trim() +
                            inputOption3.getText().toString().trim() +
                            inputOption4.getText().toString().trim() +
                            inputOption5.getText().toString().trim() +
                            inputOption6.getText().toString().trim() ;

                    if(getOtpBacked!=null){
                        progressBar.setVisibility(View.VISIBLE);
                        verifyButtonClick.setVisibility(View.INVISIBLE);

                        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                            getOtpBacked, enterCodeOtp
                        );

                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {

                                        progressBar.setVisibility(View.GONE);
                                        verifyButtonClick.setVisibility(View.VISIBLE);

                                        if(task.isSuccessful()){
//                                            getIntent().getStringExtra("mobile");

                                            database.getReference().child("Users")
                                                    .child(FirebaseAuth.getInstance().getUid())
                                                    .setValue(getIntent().getStringExtra("mobile"));

                                            String id = task.getResult().getUser().getUid();

                                            Intent intent = new Intent(VerifyOtpScreen.this, MainActivity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                        }else{
                                            Toast.makeText(VerifyOtpScreen.this, "Enter Correct OTP ", Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                });

                    }else {
                        Toast.makeText(VerifyOtpScreen.this, "Please Check Your Internet Connection ", Toast.LENGTH_SHORT).show();
                    }

//                    Toast.makeText(VerifyOtpScreen.this, "otp verified", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(VerifyOtpScreen.this, "please enter all number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        numberOtpMoveNext();


        TextView resendOtp = findViewById(R.id.textResendOtp);

        resendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                verifyButtonClick.setVisibility(View.GONE);

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + getIntent().getStringExtra("mobile"),
                        60,
                        TimeUnit.SECONDS,
                        VerifyOtpScreen.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {

                                Toast.makeText(VerifyOtpScreen.this, "Error please check your connection ", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String newBackendOtp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                                getOtpBacked = newBackendOtp;
                                progressBar.setVisibility(View.GONE);
                                verifyButtonClick.setVisibility(View.VISIBLE);

                                Toast.makeText(VerifyOtpScreen.this, "Otp Resended ", Toast.LENGTH_SHORT).show();

                            }
                        }
                );
            }
        });
    }

    private void numberOtpMoveNext() {
        inputOption1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    inputOption2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputOption2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    inputOption3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputOption3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    inputOption4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputOption4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    inputOption5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        inputOption5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    inputOption6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}