package com.pujagoodies.sacred;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.mandir.Test;
import com.pujagoodies.sacred.R;
//import com.example.playvideota.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class AuthActivity extends AppCompatActivity {

//    private static int RC_SIGN_IN = 10;
//    GoogleSignInClient mGoogleSignInClient;

    Button phoneNumberButton;
    FirebaseDatabase database;
    FirebaseStorage storage;
    FirebaseUser currentUser;
    FirebaseAuth auth;
    TextView loginOrSignUpTv;

//    String token;
//    private String applicationId = "OTPLess:NHIDKECWTRQPMHWFXLKYCACBPMFMECZT";
//    private String secretKey = "nUKQZBGCIedyMZMBH35LPJe0ArlpljRPZIrqcGqEeX8CPMaugIVFhk3rt7xhyGN82";
//
//    private static final int RC_SIGN_IN = 1;
//    private static final String TAG = "GOOGLEAUTH";
//    GoogleSignInClient mGoogleSignInClient;
//    Dialog dialog;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    Button sign_in_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.


        auth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();
        currentUser = auth.getCurrentUser();

//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();
//
//        // Build a GoogleSignInClient with the options specified by gso.
//        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);




        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);


        // Set the dimensions of the sign-in button.
//        signInButton.setSize(SignInButton.SIZE_STANDARD);
        sign_in_button = findViewById(R.id.sign_in_button);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            navigateToSecondActivity();
        }

        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }

        });


        phoneNumberButton = findViewById(R.id.phoneNumberButton);

        phoneNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthActivity.this, EnterPhoneNumberScreen.class);
                startActivity(intent);
            }
        });

        loginOrSignUpTv = findViewById(R.id.loginOrSignUpTv);
        loginOrSignUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(currentUser != null){
            Intent intent = new Intent(AuthActivity.this, MandirDummyActivity.class);
            startActivity(intent);
        }
    }




    private void signIn() {
//        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//        startActivityForResult(signInIntent, RC_SIGN_IN);

        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent, 1000);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN) {
//            // The Task returned from this call is always completed, no need to attach
//            // a listener.
//            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//            handleSignInResult(task);
//        }
        
        if(requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try{
//                GoogleSignInAccount account = task.getResult(ApiException.class);
//                firebaseAuthWithGoogle(account.getIdToken());
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                Toast.makeText(this, "Please check Your Internet Connection", Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
        
    }

    private void navigateToSecondActivity() {
        finish();
        Intent intent = new Intent(AuthActivity.this, MandirDummyActivity.class);
        startActivity(intent);
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken,null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = auth.getCurrentUser();
                            Intent intent = new Intent(AuthActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
//                            dialog.dismiss();
                        }else {
//                            dialog.dismiss();
                            Toast.makeText(AuthActivity.this, "LOGIN Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            if (acct != null) {

                String idToken = acct.getIdToken();

                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();
                Toast.makeText(this, "email : " + personEmail, Toast.LENGTH_SHORT).show();

                database.getReference().child("Users")
                        .child(personId)
                        .setValue(personEmail);
                Intent intent = new Intent(AuthActivity.this, MainActivity.class);
                intent.putExtra("personName", acct.getDisplayName());
                intent.putExtra("personPhoto", acct.getPhotoUrl());
                startActivity(intent);
            }


        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("ta error : ", e.toString());

        }
    }
}