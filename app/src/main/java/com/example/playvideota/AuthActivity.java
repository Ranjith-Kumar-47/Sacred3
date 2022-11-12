package com.example.playvideota;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpResponse;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.playvideota.api.MySingleton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.otpless.main.Otpless;

import com.otpless.main.OtplessIntentRequest;

import com.otpless.main.OtplessProvider;

import com.otpless.main.OtplessTokenData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AuthActivity extends AppCompatActivity {

    private static int RC_SIGN_IN = 10;
    GoogleSignInClient mGoogleSignInClient;
    private Otpless otpless;
    String whatsappUrl ;
    Button phoneNumberButton;
    String token;
    private String applicationId = "OTPLess:NHIDKECWTRQPMHWFXLKYCACBPMFMECZT";
    private String secretKey = "nUKQZBGCIedyMZMBH35LPJe0ArlpljRPZIrqcGqEeX8CPMaugIVFhk3rt7xhyGN82";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);


        // Set the dimensions of the sign-in button.
        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }

        });


        //Initialize OTPLess Instance
        otpless = OtplessProvider.getInstance(this).init(this::onOtplessResult);



        Button whatsappButton = (Button) findViewById(R.id.whatsappButton);
        signInWithWhataApp();
        whatsappButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(AuthActivity.this, "not working yet", Toast.LENGTH_SHORT).show();
                signInWithWhataApp();

                String url1 = whatsappUrl ;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url1));
                startActivity(i);

                initiateOtplessFlow(whatsappUrl);

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


    }

    private String signInWithWhataApp() {


        String url = "https://api.otpless.com/api/v1/user/getSignupUrl";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String valUrl = response.getString("url");
                    whatsappUrl = valUrl;
                    System.out.println("My Value url of whatsapp : "+valUrl);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap header = new HashMap();
                header.put("Clientid", "OTPLess:NHIDKECWTRQPMHWFXLKYCACBPMFMECZT");
                header.put("Clientsecret", "nUKQZBGCIedyMZMBH35LPJe0ArlpljRPZIrqcGqEeX8CPMaugIVFhk3rt7xhyGN82");
                header.put("State", "STATE");
                return header;
            }
        };

        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

        return whatsappUrl;
    }


    private void initiateOtplessFlow(String intentUri) {

        //While you create a request with otpless sdk you can define your own loading text and color

        System.out.println("initaite otp less flow ");
        final OtplessIntentRequest request = new OtplessIntentRequest(intentUri)
                .setLoadingText("Please wait...")
                .setProgressBarColor(R.color.purple_200);



        otpless.openOtpless(request);

    }


    //Call back function Where token is received
    private void onOtplessResult(@NonNull OtplessTokenData response) {
        if (response == null) {
            return;
        }
        //Send this token to your backend end api to fetch user details from otpless service
        token = response.getToken();

        System.out.println("token : "+token);


    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri personPhoto = acct.getPhotoUrl();
                Toast.makeText(this, "email : " + personEmail, Toast.LENGTH_SHORT).show();
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