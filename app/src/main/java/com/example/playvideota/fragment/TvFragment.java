package com.example.playvideota.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.playvideota.FeedbackActivity;
import com.example.playvideota.R;
import com.example.playvideota.adapter.TvLiveVideoAdapter;
import com.example.playvideota.adapter.YoutuberAdapter;
import com.example.playvideota.api.MySingleton;
import com.example.playvideota.databinding.ActivityMainBinding;
import com.example.playvideota.databinding.FragmentTvBinding;
import com.example.playvideota.model.TvLiveVideoModel;
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

    // for live video
    RecyclerView liveVideoRV;
    ArrayList<TvLiveVideoModel> tvLiveVideoModelArrayList;

    // for chalisa
    RecyclerView chalisaRV;
    ArrayList<TvLiveVideoModel> tvChalisaArrayList;

    // for aarti
    RecyclerView aartiRV;
    ArrayList<TvLiveVideoModel> tvAartiArrayList;

    // for Bhajan
    RecyclerView bhajanRV;
    ArrayList<TvLiveVideoModel> bhajanArrayList;

    // for Mantra
    RecyclerView mantraRV;
    ArrayList<TvLiveVideoModel> mantraArrayList;

    // for Dainik brat Katha
    RecyclerView dainikBratKathaRV;
    ArrayList<TvLiveVideoModel> dainikBratKathaArrayList;

    // for sadguru
    RecyclerView sadguruRV;
    ArrayList<TvLiveVideoModel> sadguruArrayList;

    // for Guru Dev Sri Sri Ravishanker
    RecyclerView guruDevSriSriRV;
    ArrayList<TvLiveVideoModel> gurudevSriSriRavishankerArrayList;


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

//            String liveYoutubeVideoUrl = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=" +youtubeAcountList.get(j)+"&eventType=live&maxResults=250&type=video&key=AIzaSyBA5stcvWxiMf5PhX6HRQJJMhC2a6ovzxo";
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


        // for live video
        tvLiveVideoModelArrayList = new ArrayList<>();

        tvLiveVideoModelArrayList.add(new TvLiveVideoModel(R.drawable.aquarius));
        tvLiveVideoModelArrayList.add(new TvLiveVideoModel(R.drawable.cancer));
        tvLiveVideoModelArrayList.add(new TvLiveVideoModel(R.drawable.libra));
        tvLiveVideoModelArrayList.add(new TvLiveVideoModel(R.drawable.gemini));
        tvLiveVideoModelArrayList.add(new TvLiveVideoModel(R.drawable.lio));


        liveVideoRV = binding.liveVideoRV;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        liveVideoRV.setLayoutManager(linearLayoutManager);
        TvLiveVideoAdapter tvLiveVideoAdapter = new TvLiveVideoAdapter(tvLiveVideoModelArrayList, getContext());
        liveVideoRV.setAdapter(tvLiveVideoAdapter);

        // for chalisa
        tvChalisaArrayList = new ArrayList<>();

        tvChalisaArrayList.add(new TvLiveVideoModel(R.drawable.lio));
        tvChalisaArrayList.add(new TvLiveVideoModel(R.drawable.libra));
        tvChalisaArrayList.add(new TvLiveVideoModel(R.drawable.gemini));
        tvChalisaArrayList.add(new TvLiveVideoModel(R.drawable.cancer));
        tvChalisaArrayList.add(new TvLiveVideoModel(R.drawable.aquarius));

        chalisaRV = binding.chalisaRV;
        LinearLayoutManager linearLayoutManagerChalisa = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        chalisaRV.setLayoutManager(linearLayoutManagerChalisa);
        TvLiveVideoAdapter tvChalisaAdapter = new TvLiveVideoAdapter(tvChalisaArrayList, getContext());
        chalisaRV.setAdapter(tvChalisaAdapter);



        // for aarti
        tvAartiArrayList = new ArrayList<>();

        tvAartiArrayList.add(new TvLiveVideoModel(R.drawable.lio));
        tvAartiArrayList.add(new TvLiveVideoModel(R.drawable.libra));
        tvAartiArrayList.add(new TvLiveVideoModel(R.drawable.gemini));
        tvAartiArrayList.add(new TvLiveVideoModel(R.drawable.cancer));
        tvAartiArrayList.add(new TvLiveVideoModel(R.drawable.aquarius));

        aartiRV = binding.aartiRV;
        LinearLayoutManager linearLayoutManagerAarti = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        aartiRV.setLayoutManager(linearLayoutManagerAarti);
        TvLiveVideoAdapter tvAartiAdapter = new TvLiveVideoAdapter(tvAartiArrayList, getContext());
        aartiRV.setAdapter(tvAartiAdapter);


        // for bhajan
        bhajanArrayList = new ArrayList<>();

        bhajanArrayList.add(new TvLiveVideoModel(R.drawable.lio));
        bhajanArrayList.add(new TvLiveVideoModel(R.drawable.libra));
        bhajanArrayList.add(new TvLiveVideoModel(R.drawable.gemini));
        bhajanArrayList.add(new TvLiveVideoModel(R.drawable.cancer));
        bhajanArrayList.add(new TvLiveVideoModel(R.drawable.aquarius));

        bhajanRV = binding.bhajanRV;
        LinearLayoutManager linearLayoutManagerBhajan = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        bhajanRV.setLayoutManager(linearLayoutManagerBhajan);
        TvLiveVideoAdapter bhajanAdapter = new TvLiveVideoAdapter(bhajanArrayList, getContext());
        bhajanRV.setAdapter(tvAartiAdapter);


        // for mantra
        mantraArrayList = new ArrayList<>();

        mantraArrayList.add(new TvLiveVideoModel(R.drawable.lio));
        mantraArrayList.add(new TvLiveVideoModel(R.drawable.libra));
        mantraArrayList.add(new TvLiveVideoModel(R.drawable.gemini));
        mantraArrayList.add(new TvLiveVideoModel(R.drawable.cancer));
        mantraArrayList.add(new TvLiveVideoModel(R.drawable.aquarius));

        mantraRV = binding.mantraRV;
        LinearLayoutManager linearLayoutManagerMantra = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        mantraRV.setLayoutManager(linearLayoutManagerMantra);
        TvLiveVideoAdapter mantraAdapter = new TvLiveVideoAdapter(mantraArrayList, getContext());
        mantraRV.setAdapter(mantraAdapter);


        // for dainik brat katha
        dainikBratKathaArrayList = new ArrayList<>();

        dainikBratKathaArrayList.add(new TvLiveVideoModel(R.drawable.lio));
        dainikBratKathaArrayList.add(new TvLiveVideoModel(R.drawable.libra));
        dainikBratKathaArrayList.add(new TvLiveVideoModel(R.drawable.gemini));
        dainikBratKathaArrayList.add(new TvLiveVideoModel(R.drawable.cancer));
        dainikBratKathaArrayList.add(new TvLiveVideoModel(R.drawable.aquarius));

        dainikBratKathaRV = binding.dainikBratKathaRV;
        LinearLayoutManager linearLayoutManagerDainikBratKatha = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        dainikBratKathaRV.setLayoutManager(linearLayoutManagerDainikBratKatha);
        TvLiveVideoAdapter dainikBratKathaAdapter = new TvLiveVideoAdapter(dainikBratKathaArrayList, getContext());
        dainikBratKathaRV.setAdapter(dainikBratKathaAdapter);


        // for sadguru
        sadguruArrayList = new ArrayList<>();

        sadguruArrayList.add(new TvLiveVideoModel(R.drawable.lio));
        sadguruArrayList.add(new TvLiveVideoModel(R.drawable.libra));
        sadguruArrayList.add(new TvLiveVideoModel(R.drawable.gemini));
        sadguruArrayList.add(new TvLiveVideoModel(R.drawable.cancer));
        sadguruArrayList.add(new TvLiveVideoModel(R.drawable.aquarius));

        sadguruRV = binding.sadguruRV;
        LinearLayoutManager linearLayoutManagerSadguru = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        sadguruRV.setLayoutManager(linearLayoutManagerSadguru);
        TvLiveVideoAdapter sadguruAdapter = new TvLiveVideoAdapter(sadguruArrayList, getContext());
        sadguruRV.setAdapter(sadguruAdapter);



        // for Gurudev Sri Sri Ravishankar
        gurudevSriSriRavishankerArrayList = new ArrayList<>();

        gurudevSriSriRavishankerArrayList.add(new TvLiveVideoModel(R.drawable.lio));
        gurudevSriSriRavishankerArrayList.add(new TvLiveVideoModel(R.drawable.libra));
        gurudevSriSriRavishankerArrayList.add(new TvLiveVideoModel(R.drawable.gemini));
        gurudevSriSriRavishankerArrayList.add(new TvLiveVideoModel(R.drawable.cancer));
        gurudevSriSriRavishankerArrayList.add(new TvLiveVideoModel(R.drawable.aquarius));

        guruDevSriSriRV = binding.gurudevSriSriRavishankerRV;
        LinearLayoutManager linearLayoutManagerGurudevSriSriRaviShanker = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        guruDevSriSriRV.setLayoutManager(linearLayoutManagerGurudevSriSriRaviShanker);
        TvLiveVideoAdapter guruSriSriRavishankerAdapter = new TvLiveVideoAdapter(gurudevSriSriRavishankerArrayList, getContext());
        guruDevSriSriRV.setAdapter(guruSriSriRavishankerAdapter);






    }


    private void gridListData() {
        list = new ArrayList<>();
    }
}