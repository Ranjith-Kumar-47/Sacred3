package com.example.playvideota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
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
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String api = "AIzaSyBA5stcvWxiMf5PhX6HRQJJMhC2a6ovzxo";

    RecyclerView youtuberRV;
    ArrayList<YoutuberModel> list;
    YoutuberAdapter youtuberAdapter;
    ArrayList<String> youtubeAcountList;
    String personName = "";
    String personPhoto = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youtubeAccount();
        gridListData();
        settingAdapter();

        loadYoutubeAccount();

        personName = getIntent().getStringExtra("personName");
        personPhoto = getIntent().getStringExtra("personPhoto");

        ImageView profileUserImage = findViewById(R.id.profileUserImage);

        Picasso.with(getApplicationContext())
                .load(personPhoto)
                .into(profileUserImage);




    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    private void youtubeAccount(){
        youtubeAcountList = new ArrayList<>();

        youtubeAcountList.add("GoogleDevelopers");
        youtubeAcountList.add("PowerKids");

        youtubeAcountList.add("Movieclips");
        youtubeAcountList.add("SThenics");

        youtubeAcountList.add("sonyliv");
        youtubeAcountList.add("google");
        youtubeAcountList.add("ZeeMusicCompany");
        youtubeAcountList.add("WWE");
        youtubeAcountList.add("LikeNastya");

        youtubeAcountList.add("SETIndia");
        youtubeAcountList.add("PewDiePie");
        youtubeAcountList.add("MrBeast");
        youtubeAcountList.add("CanalKondZilla");
        youtubeAcountList.add("Calisthenicmovement");
        youtubeAcountList.add("ArianaGrande");
        youtubeAcountList.add("AshtonFitness");
        youtubeAcountList.add("voot");
        youtubeAcountList.add("star");

        youtubeAcountList.add("amazon");
        youtubeAcountList.add("school");

    }

    private void loadYoutubeAccount() {


        for (int j = 0; j < youtubeAcountList.size(); j++) {
            String youtubeAccountUrl = "https://youtube.googleapis.com/youtube/v3/channels?part=snippet,brandingSettings&forUsername="+youtubeAcountList.get(j)+"&key=AIzaSyBA5stcvWxiMf5PhX6HRQJJMhC2a6ovzxo";

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
                            JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                            mediumJsonObject.getString("url");
                            System.out.println("URL : " + mediumJsonObject.getString("url"));

                            // getting channel branding image
                            JSONObject channelBrandingJsonObject = jsonObject.getJSONObject("brandingSettings");
                            JSONObject bannerImageJsonObject = channelBrandingJsonObject.getJSONObject("image");
                            bannerImageJsonObject.getString("bannerExternalUrl");


                            YoutuberModel youtuberModel = new YoutuberModel(
                                    mediumJsonObject.getString("url"),
                                    snippetJsonObject.getString("title"),
                                    jsonObject.getString("id"),
                                    bannerImageJsonObject.getString("bannerExternalUrl")

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
        youtuberRV = findViewById(R.id.youtuberRV);
        youtuberRV.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(youtuberRV.VERTICAL);
        youtuberRV.setLayoutManager(gridLayoutManager);

        youtuberAdapter = new YoutuberAdapter(this, list);
        youtuberRV.setAdapter(youtuberAdapter);

    }


    private void gridListData() {
        list = new ArrayList<>();
    }
}