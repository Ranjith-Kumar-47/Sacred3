package com.example.playvideota.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.playvideota.FeedbackActivity;
import com.example.playvideota.R;
import com.example.playvideota.adapter.YoutuberAdapter;
import com.example.playvideota.api.MySingleton;
import com.example.playvideota.databinding.ActivityMainBinding;
import com.example.playvideota.databinding.FragmentTvBinding;
import com.example.playvideota.model.YoutuberModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class TvFragment extends Fragment {

    private String api = "AIzaSyBA5stcvWxiMf5PhX6HRQJJMhC2a6ovzxo";

    FragmentTvBinding binding;

    RecyclerView youtuberRV;
    ArrayList<YoutuberModel> list;
    YoutuberAdapter youtuberAdapter;
    ArrayList<String> youtubeAcountList;
    String personName = "";
    String personPhoto = "";
    FloatingActionButton feedBackButton;


    public TvFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        youtubeAccount();
//        gridListData();
//        settingAdapter();

//        loadYoutubeAccount();

//
//        personName = getIntent().getStringExtra("personName");
//        personPhoto = getIntent().getStringExtra("personPhoto");



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTvBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_tv, container, false);

        youtubeAccount();
        gridListData();
        settingAdapter();
        loadYoutubeAccount();

        binding.feedBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FeedbackActivity.class);
                startActivity(intent);

            }
        });

        return binding.getRoot();
    }


    private void youtubeAccount(){
        System.out.println("YoutubeAccount");
        youtubeAcountList = new ArrayList<>();

//        youtubeAcountList.add("GoogleDevelopers");
//        youtubeAcountList.add("PowerKids");
//
//        youtubeAcountList.add("Movieclips");
//        youtubeAcountList.add("SThenics");
//
//        youtubeAcountList.add("sonyliv");
//        youtubeAcountList.add("google");
//        youtubeAcountList.add("ZeeMusicCompany");
//        youtubeAcountList.add("WWE");
//        youtubeAcountList.add("LikeNastya");
//
//        youtubeAcountList.add("SETIndia");
//        youtubeAcountList.add("PewDiePie");
//        youtubeAcountList.add("MrBeast");
//        youtubeAcountList.add("CanalKondZilla");
//        youtubeAcountList.add("Calisthenicmovement");
//        youtubeAcountList.add("ArianaGrande");
//        youtubeAcountList.add("AshtonFitness");
//        youtubeAcountList.add("voot");
//        youtubeAcountList.add("star");
//
//        youtubeAcountList.add("amazon");
//        youtubeAcountList.add("school");


        youtubeAcountList.add("UCRUAdVm9ZOF4JheOd8qIQHA");
        youtubeAcountList.add("UCDe0DwkMVFfSIoiYdQUPQmQ");
        youtubeAcountList.add("UCPITDRnLbTRyyEUVwZHbMww");
        youtubeAcountList.add("UCSzOZ97LOpU-_AVlGfmD4rQ");
        youtubeAcountList.add("UCHq7ZxlzRRXimaBmk5QAxSQ");
        youtubeAcountList.add("UCUUIz69kK3Ib5bD4hWLKAwA");
        youtubeAcountList.add("UC8Igqo3g1U40n66BLb-xHuQ");
        youtubeAcountList.add("UCfwa_zKl8-zC9rQDWIEixgg");
        youtubeAcountList.add("UCfwa_zKl8-zC9rQDWIEixgg");
        youtubeAcountList.add("CT_QwW7Tbew5qrYNb2auqAQ");
        youtubeAcountList.add("UC04m8d9t8UeWZ5DuvQVnqiw");
        youtubeAcountList.add("UC6vQRTCxutg6fJLUGkDKynQ");
        youtubeAcountList.add("UCOizxR3GwY7dmehMCAdvv9g");
        youtubeAcountList.add("UCyIkg79GpPVF77qYKoAINtw");
        youtubeAcountList.add("UCDqkux3AH7P9hRjmunoUeAQ");
        youtubeAcountList.add("UC7ZivIYRB0fMSGh-THcTYbw");
        youtubeAcountList.add("UCaayLD9i5x4MmIoVZxXSv_g");
        youtubeAcountList.add("UCHKGDg0GJKBsA9mFraDOLHA");

//        youtubeAcountList.add("AasthaChannel UCRUAdVm9ZOF4JheOd8qIQHA");
//        youtubeAcountList.add("Aniruddhacharya ji UCDe0DwkMVFfSIoiYdQUPQmQ");
//        youtubeAcountList.add("Satsang UCPITDRnLbTRyyEUVwZHbMww");
//        youtubeAcountList.add("Bhakthi TV UCSzOZ97LOpU-_AVlGfmD4rQ");
//        youtubeAcountList.add("Shri Devkinandan Thakur Ji UCHq7ZxlzRRXimaBmk5QAxSQ");
//        youtubeAcountList.add("Pandit Pradeep Ji Mishra Sehore Wale UCUUIz69kK3Ib5bD4hWLKAwA");
//        youtubeAcountList.add("Bhakti Sangeet HDN UC8Igqo3g1U40n66BLb-xHuQ");
//        youtubeAcountList.add("JayaKishori Motivation UCfwa_zKl8-zC9rQDWIEixgg");
//        youtubeAcountList.add("Iamjayakishori UCfwa_zKl8-zC9rQDWIEixgg");
//        youtubeAcountList.add("SanskarTV CT_QwW7Tbew5qrYNb2auqAQ");
//        youtubeAcountList.add("SADHNA GOLD UC04m8d9t8UeWZ5DuvQVnqiw");
//        youtubeAcountList.add("Saregama Bhakti UC6vQRTCxutg6fJLUGkDKynQ");
//        youtubeAcountList.add("Gauri Gopal Tv UCOizxR3GwY7dmehMCAdvv9g");
//        youtubeAcountList.add("Swami Raghvacharya UCyIkg79GpPVF77qYKoAINtw");
//        youtubeAcountList.add("BhaktiSagar Tv UCDqkux3AH7P9hRjmunoUeAQ");
//        youtubeAcountList.add("Shemaroo Bhakti UC7ZivIYRB0fMSGh-THcTYbw");
//        youtubeAcountList.add("T-Series Bhakti Sagar UCaayLD9i5x4MmIoVZxXSv_g");
//        youtubeAcountList.add("Pen Bhakti UCHKGDg0GJKBsA9mFraDOLHA");
    }

    private void loadYoutubeAccount() {

        System.out.println("loadYoutubeAccount");

        for (int j = 0; j < youtubeAcountList.size(); j++) {
//            String youtubeAccountUrl1 = "https://youtube.googleapis.com/youtube/v3/channels?part=snippet,brandingSettings&forUsername="+youtubeAcountList.get(j)+"&key=AIzaSyBA5stcvWxiMf5PhX6HRQJJMhC2a6ovzxo";
            String youtubeAccountUrl  = "https://youtube.googleapis.com/youtube/v3/channels?part=snippet,brandingSettings&id="+youtubeAcountList.get(j)+"&key=AIzaSyBA5stcvWxiMf5PhX6HRQJJMhC2a6ovzxo";

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
                        YoutuberAdapter youtubeAccountAdapter = new YoutuberAdapter(getContext(), list);
                        youtuberRV.setAdapter(youtubeAccountAdapter);


                    } catch (Exception e) {
                        System.out.println("try catch error "+e.getMessage());
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO: Handle error
                    System.out.println("volly error "+error.getMessage());
                }
            });

//            MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
            MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);
        }

        YoutuberAdapter youtubeAccountAdapter1 = new YoutuberAdapter(getContext(), list);
//        youtuberAdapter = new YoutuberAdapter(getContext(), list);
        youtuberRV.setAdapter(youtubeAccountAdapter1);


    }


    private void settingAdapter() {
//        youtuberRV = findViewById(R.id.youtuberRV);
        System.out.println("setting Adapter");
        youtuberRV = binding.youtuberRV;
        youtuberRV.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setOrientation(youtuberRV.VERTICAL);
        youtuberRV.setLayoutManager(gridLayoutManager);

        YoutuberAdapter youtuberAdapters = new YoutuberAdapter(getContext(), list);
        youtuberRV.setAdapter(youtuberAdapters);

    }


    private void gridListData() {
        list = new ArrayList<>();
    }
}