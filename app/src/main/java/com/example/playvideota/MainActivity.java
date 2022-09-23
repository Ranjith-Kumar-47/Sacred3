package com.example.playvideota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.playvideota.adapter.YoutuberAdapter;
import com.example.playvideota.api.MySingleton;
import com.example.playvideota.model.YoutuberModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static int RC_SIGN_IN = 10;

    private String api = "AIzaSyAcI_4tCAc7i6psHKyqpIzzdDjxfCR3VS0";
    private String apiTA = "365773667224-rf4dcrlqgriigbhnj0aeuumgtrpp372o.apps.googleusercontent.com";

    RecyclerView youtuberRV;
    ArrayList<YoutuberModel> list;
    YoutuberAdapter youtuberAdapter;

    GoogleSignInClient mGoogleSignInClient;

    ArrayList<String> youtubeAcountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youtubeAccount();
        gridListData();
        settingAdapter();

        loadYoutubeAccount();


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
        signInButton.setSize(SignInButton.SIZE_ICON_ONLY);


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }

        });

    }

    private void youtubeAccount(){
        youtubeAcountList = new ArrayList<>();

        youtubeAcountList.add("GoogleDevelopers");
        youtubeAcountList.add("PowerKids");
        youtubeAcountList.add("AmitBhadana");
        youtubeAcountList.add("Movieclips");
        youtubeAcountList.add("Goldmines");

        youtubeAcountList.add("sonyliv");
        youtubeAcountList.add("AshtonFitness");
        youtubeAcountList.add("ZeeMusicCompany");
        youtubeAcountList.add("WWE");
        youtubeAcountList.add("LikeNastya");

        youtubeAcountList.add("SETIndia");
        youtubeAcountList.add("PewDiePie");
        youtubeAcountList.add("MrBeast");
        youtubeAcountList.add("CanalKondZilla");
        youtubeAcountList.add("ArianaGrande");

        youtubeAcountList.add("voot");
        youtubeAcountList.add("star");
        youtubeAcountList.add("google");
        youtubeAcountList.add("amazon");
        youtubeAcountList.add("school");

    }

    private void loadYoutubeAccount() {


        for (int j = 0; j < 20; j++) {
            String youtubeAccountUrl = "https://youtube.googleapis.com/youtube/v3/channels?part=snippet&forUsername="+youtubeAcountList.get(j)+"&key=AIzaSyAcI_4tCAc7i6psHKyqpIzzdDjxfCR3VS0";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, youtubeAccountUrl, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray jsonArray = response.getJSONArray("items");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            jsonObject.getString("id");
                            System.out.println("ID : "+jsonObject.getString("id"));

                            JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                            snippetJsonObject.getString("title");

                            System.out.println("TITLE : " + snippetJsonObject.getString("title"));

                            JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                            JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("medium");

                            mediumJsonObject.getString("url");
                            System.out.println("URL : " + mediumJsonObject.getString("url"));

                            YoutuberModel youtuberModel = new YoutuberModel(
                                    mediumJsonObject.getString("url"),
                                    snippetJsonObject.getString("title"),
                                    jsonObject.getString("id")
                            );
                            list.add(youtuberModel);
                        }
                        YoutuberAdapter youtubeAccountAdapter = new YoutuberAdapter(getApplicationContext(), list);
                        youtuberRV.setAdapter(youtubeAccountAdapter);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO: Handle error

                }
            });

            MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

        }

        YoutuberAdapter youtubeAccountAdapter1 = new YoutuberAdapter(getApplicationContext(), list);
        youtuberRV.setAdapter(youtubeAccountAdapter1);


    }


    private void settingAdapter() {
        youtuberRV = findViewById(R.id.yutuberRV);
        youtuberRV.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(youtuberRV.VERTICAL);
        youtuberRV.setLayoutManager(gridLayoutManager);

        youtuberAdapter = new YoutuberAdapter(this, list);
        youtuberRV.setAdapter(youtuberAdapter);

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
            }

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("ta error : ", e.toString());

        }
    }

    private void gridListData() {
        list = new ArrayList<>();
//        list.add(new YoutuberModel(R.drawable.ic_profile_svgrepo_com,"pogo"));
//        list.add(new YoutuberModel(R.drawable.ic_profile_svgrepo_com,"pogo"));
//        list.add(new YoutuberModel(R.drawable.ic_profile_svgrepo_com,"pogo"));
//        list.add(new YoutuberModel(R.drawable.ic_profile_svgrepo_com,"pogo"));
//        list.add(new YoutuberModel(R.drawable.ic_profile_svgrepo_com,"pogo"));
//        list.add(new YoutuberModel(R.drawable.ic_profile_svgrepo_com,"pogo"));
//        list.add(new YoutuberModel(R.drawable.ic_profile_svgrepo_com,"pogo"));
//        list.add(new YoutuberModel(R.drawable.ic_profile_svgrepo_com,"pogo"));
//        list.add(new YoutuberModel(R.drawable.ic_profile_svgrepo_com,"pogo"));
        //                                for (int i = 0; i < response.length(); i++) {
//                                    JSONObject jsonObject = response.getJSONObject(i);
//                                    jsonObject.getString("name");
//                                    jsonObject.getString("url");
//                                    jsonObject.getString("site");
//
//                                    System.out.println("contest site : " + jsonObject.getString("site"));
//
//                                    ContestModel contestModelList = new ContestModel(
//                                            jsonObject.getString("site"),
//                                            jsonObject.getString("name"),
//                                            jsonObject.getString("start_time"),
//                                            jsonObject.getString("end_time"),
//                                            jsonObject.getString("url"),
//                                            jsonObject.getString("in_24_hours"),
//                                            jsonObject.getString("status")
//                                    );
//
//                                    // setting contest image
//                                    contestModelList.setPlatformImage(sMap.get(jsonObject.getString("site")));
//                                    contestList.add(contestModelList);
//                                }
//
//                                ContestAdapter con = new ContestAdapter(contestList,getContext());
//                                contestRv.setAdapter(con);
////                            contestAdapter.updateContest(contestList);
//                                System.out.println("BLOCK -> LENGTH : " + contestList.size());
    }
}