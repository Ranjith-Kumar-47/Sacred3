package com.example.playvideota;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class EnterPhoneNumberScreen extends AppCompatActivity {

    EditText input_mobile_number;
    Button getOtpButton;

    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_phone_number_screen);

        mAuth = FirebaseAuth.getInstance();

        input_mobile_number = findViewById(R.id.input_mobile_number);
        getOtpButton = findViewById(R.id.getOtpButton);

        progressBar = findViewById(R.id.progressbar_sending_otp);


        getOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input_mobile_number.getText().toString().trim().isEmpty()){
                    if((input_mobile_number.getText().toString().trim()).length() == 10) {
//                        Intent intent = new Intent(EnterPhoneNumberScreen.this, VerifyOtpScreen.class);
//                        intent.putExtra("mobile", input_mobile_number.getText().toString());
//                        startActivity(intent);

                        progressBar.setVisibility(View.VISIBLE);
                        getOtpButton.setVisibility(View.INVISIBLE);
                        
//                        otpSend();
//                        FirebaseAuth.getInstance().getFirebaseAuthSettings().setAppVerificationDisabledForTesting(true);

                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+91" + input_mobile_number.getText().toString(),
                                60,
                                TimeUnit.SECONDS,
                                EnterPhoneNumberScreen.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                        progressBar.setVisibility(View.GONE);
                                        getOtpButton.setVisibility(View.VISIBLE);
                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        progressBar.setVisibility(View.GONE);
                                        getOtpButton.setVisibility(View.VISIBLE);
                                        Toast.makeText(EnterPhoneNumberScreen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                        System.out.println("error " +e.getMessage());
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String backendOtp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        progressBar.setVisibility(View.GONE);
                                        getOtpButton.setVisibility(View.VISIBLE);
                                        Intent intent = new Intent(EnterPhoneNumberScreen.this, VerifyOtpScreen.class);
                                        intent.putExtra("mobile", input_mobile_number.getText().toString().trim());
                                        intent.putExtra("backendOtp",backendOtp);
                                        startActivity(intent);
                                    }
                                }
                        );


                    }else{
                            Toast.makeText(EnterPhoneNumberScreen.this, "Please Enter correct Number ", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                    Toast.makeText(EnterPhoneNumberScreen.this, "Enter Mobile Number ", Toast.LENGTH_SHORT).show();
                }
            }

            
        });
    }

    private void otpSend() {
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {
                // This callback will be invoked in two situations:
                // 1 - Instant verification. In some cases the phone number can be instantly
                //     verified without needing to send or enter a verification code.
                // 2 - Auto-retrieval. On some devices Google Play services can automatically
                //     detect the incoming verification SMS and perform verification without
                //     user action.

                progressBar.setVisibility(View.GONE);
                getOtpButton.setVisibility(View.VISIBLE);

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                // This callback is invoked in an invalid request for verification is made,
                // for instance if the the phone number format is not valid.
                progressBar.setVisibility(View.GONE);
                getOtpButton.setVisibility(View.VISIBLE);
                Toast.makeText(EnterPhoneNumberScreen.this, "Error please check your connection ", Toast.LENGTH_SHORT).show();
                System.out.println("error " +e.getMessage());
                // Show a message and update the UI
            }

            @Override
            public void onCodeSent(@NonNull String backendOtp,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.

                progressBar.setVisibility(View.GONE);
                getOtpButton.setVisibility(View.VISIBLE);
                Intent intent = new Intent(EnterPhoneNumberScreen.this, VerifyOtpScreen.class);
                intent.putExtra("mobile", input_mobile_number.getText().toString().trim());
                intent.putExtra("backendOtp",backendOtp);
                startActivity(intent);
            }
        };

        mAuth = FirebaseAuth.getInstance();
        // set this to remove reCaptcha web
        mAuth.getFirebaseAuthSettings().setAppVerificationDisabledForTesting(true);


        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91" + input_mobile_number.getText().toString().trim())       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
}