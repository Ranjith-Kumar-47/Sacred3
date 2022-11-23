package com.example.playvideota.fragment;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.playvideota.FeedbackActivity;
import com.example.playvideota.R;
import com.example.playvideota.TvSerialActivity;
import com.example.playvideota.YoutubeDashboard;
import com.example.playvideota.adapter.TvLiveVideoAdapter;
import com.example.playvideota.adapter.YoutubeDashBoardAdapterInterface;
import com.example.playvideota.adapter.YoutubeDashboardAdapter;
import com.example.playvideota.adapter.YoutuberAdapter;
import com.example.playvideota.api.MySingleton;
import com.example.playvideota.databinding.FragmentTvBinding;
import com.example.playvideota.model.TvLiveVideoModel;
import com.example.playvideota.model.YoutubeDashboradModel;
import com.example.playvideota.model.YoutuberModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class TvFragment extends Fragment implements YoutubeDashBoardAdapterInterface {

    private String api = "AIzaSyBA5stcvWxiMf5PhX6HRQJJMhC2a6ovzxo";

    FragmentTvBinding binding;

    RecyclerView youtuberRV;
    ArrayList<YoutuberModel> list;
    YoutuberAdapter youtuberAdapter;
    ArrayList<String> youtubeAcountList;
    String personName = "";
    String personPhoto = "";
    FloatingActionButton feedBackButton;
//    private String apikey = "AIzaSyBnT_DTpgZKYoT6IYH5fNni7O9DUTN98dE";
    private String apikey = "AIzaSyBA5stcvWxiMf5PhX6HRQJJMhC2a6ovzxo";

    // for live video
    RecyclerView liveVideoRV;
    ArrayList<YoutubeDashboradModel> tvLiveVideoModelArrayList;

    // for chalisa
    RecyclerView chalisaRV;
    ArrayList<YoutubeDashboradModel> tvChalisaArrayList;

    // for aarti
    RecyclerView aartiRV;
    ArrayList<YoutubeDashboradModel> tvAartiArrayList;

    // for Bhajan
    RecyclerView bhajanRV;
    ArrayList<YoutubeDashboradModel> bhajanArrayList;
    ArrayList<YoutubeDashboradModel> bhajanArrayListYoutuberModel = new ArrayList<YoutubeDashboradModel>();

    // for Mantra
    RecyclerView mantraRV;
    ArrayList<YoutubeDashboradModel> mantraArrayList;

    // for Dainik brat Katha
    RecyclerView dainikBratKathaRV;
    ArrayList<YoutubeDashboradModel> dainikBratKathaArrayList;

    // for sadguru
    RecyclerView sadguruRV;
    ArrayList<YoutubeDashboradModel> sadguruArrayList;

    // for Guru Dev Sri Sri Ravishanker
    RecyclerView guruDevSriSriRV;
    ArrayList<YoutubeDashboradModel> gurudevSriSriRavishankerArrayList;

    CardView mahabharatCV, sampurnRamayanaCV, uttarRamayanaCV, shreeMahalaxmiCV, shivMahapuranCV, jaiHanumanCV, visnuPuranCV, balKrishnaCV, gitaGyanCV, bikramBatalCV, karanCV, sankatMochanHanumanCV, vignahranGaneshCV, saiNathTeraHajarohathCV;
    ImageView mahabharatImageView, sampurnRamayanaIV, uttarRamayanaIV, shreeMahalaxmiIV, shivMahapuranIV, jaiHanumanIV, visnuPuranIV, balKrishnaIV, gitaGyanIV, bikramBatalIV, karanIV, sankatMochanHanumanIV, vignahranGaneshIV, saiNathTeraHajarohathIV;
    TextView mahabharatTV, sampurnRamayanaTV, uttarRamayanaTV, shreeMahalaxmiTV, shivMahapuranTV, jaiHanumanTV, visnuPuranTV, balKrishnaTV, gitaGyanTV, bikramBatalTV, karanTV, sankatMochanHanumanTV, vignahranGaneshTV, saiNathTeraHajarohathTV;


    public TvFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        loadBhajan();
        loadAarti();
        loadChalisa();
        loadLiveVideo();
        loadMantra();
        loadDainikBratKatha();
        loadSadguru();
        loadGurudevSriSriRaviSanker();
        initView();
        loadOtherTVSerial();
        clickListener();

        binding.feedBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FeedbackActivity.class);
                startActivity(intent);

            }
        });

        return binding.getRoot();
    }

    private void clickListener() {
        mahabharatCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TvSerialActivity.class);
                intent.putExtra("playlistId", "PLFr_jkwUp0hhm1lR1TSdgESOfoyLQR3t2");
                startActivity(intent);
            }
        });

        sampurnRamayanaCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TvSerialActivity.class);
                intent.putExtra("playlistId", "PLFPJRCFRDARSZofcQcV6m7Pu2EAL8_1dv");
                startActivity(intent);
            }
        });

        uttarRamayanaCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TvSerialActivity.class);
                intent.putExtra("playlistId", "PLFr_jkwUp0hhyQevNGOYNOMJnQMxUVbYF");
                startActivity(intent);
            }
        });

        shreeMahalaxmiCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TvSerialActivity.class);
                intent.putExtra("playlistId", "PLFr_jkwUp0hgkkuYwmaFJ1uyoN7uz2zTh");
                startActivity(intent);
            }
        });

        shivMahapuranCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TvSerialActivity.class);
                intent.putExtra("playlistId", "PL57F01972FF119B66");
                startActivity(intent);
            }
        });
        jaiHanumanCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TvSerialActivity.class);
                intent.putExtra("playlistId", "PLxAeSrqQeWdVRBmLQEbmrzPnGrgADaNFw");
                startActivity(intent);
            }
        });

        visnuPuranCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TvSerialActivity.class);
                intent.putExtra("playlistId", "PLQQa2ptMYrubalxxhseMKKZBYMGk_MC26");
                startActivity(intent);
            }
        });

        balKrishnaCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TvSerialActivity.class);
                intent.putExtra("playlistId", "PLFr_jkwUp0hgeL8Tvt4a8reRmum760h5G");
                startActivity(intent);
            }
        });


        gitaGyanCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TvSerialActivity.class);
                intent.putExtra("playlistId", "PLFPJRCFRDARSRskyLvVn6ukSQvLq2c_iy");
                startActivity(intent);
            }
        });

        bikramBatalCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TvSerialActivity.class);
                intent.putExtra("playlistId", "PLFr_jkwUp0hjTXfIElDpIfgBYUwWhKnSn");
                startActivity(intent);
            }
        });

        karanCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TvSerialActivity.class);
                intent.putExtra("playlistId", "PLzufeTFnhupzEKODFa86wWlD8HYEqMage");
                startActivity(intent);
            }
        });

        sankatMochanHanumanCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TvSerialActivity.class);
                intent.putExtra("playlistId", "PLlNHEsFhS-kVLRmuQyssIkr_qaPmyaKC7");
                startActivity(intent);
            }
        });

        vignahranGaneshCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TvSerialActivity.class);
                intent.putExtra("playlistId", "PLsGrL5_XD8WI8OKxiqOkNRRJT-Vnrb7qT");

                startActivity(intent);
            }
        });

        saiNathTeraHajarohathCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TvSerialActivity.class);
                intent.putExtra("playlistId", "PLVkaGZKVjEqQgBqA8-12rEun4OnhjlawN");
                startActivity(intent);
            }
        });


    }

    private void initView() {
        mahabharatCV = binding.mahabharatCV;
        mahabharatImageView = binding.mahabharatImageView;
        mahabharatTV = binding.mahabharatTV;
        sampurnRamayanaCV = binding.sampurnRamayanaCV;
        uttarRamayanaCV = binding.uttarRamayanaCV;
        shreeMahalaxmiCV = binding.shreeMahalaxmiCV;
        shivMahapuranCV = binding.shivMahapuranCV;
        jaiHanumanCV = binding.jaiHanumanCV;
        visnuPuranCV = binding.visnuPuranCV;
        balKrishnaCV = binding.balKrishnaCV;
        gitaGyanCV = binding.gitaGyanCV;
        bikramBatalCV = binding.bikramBatalCV;
        karanCV = binding.karanCV;
        sankatMochanHanumanCV = binding.sankatMochanHanumanCV;
        vignahranGaneshCV = binding.vignahranGaneshCV;
        saiNathTeraHajarohathCV = binding.saiNathTeraHajarohathCV;


        sampurnRamayanaIV = binding.sampurnRamayanaIV;
        uttarRamayanaIV = binding.uttarRamayanaIV;
        shreeMahalaxmiIV = binding.shreeMahalaxmiIV;
        shivMahapuranIV = binding.shivMahapuranIV;
        jaiHanumanIV = binding.jaiHanumanIV;
        visnuPuranIV = binding.visnuPuranIV;
        balKrishnaIV = binding.balKrishnaIV;
        gitaGyanIV = binding.gitaGyanIV;
        bikramBatalIV = binding.bikramBatalIV;
        karanIV = binding.karanIV;
        sankatMochanHanumanIV = binding.sankatMochanHanumanIV;
        vignahranGaneshIV = binding.vignahranGaneshIV;
        saiNathTeraHajarohathIV = binding.saiNathTeraHajarohathIV;


        sampurnRamayanaTV = binding.sampurnRamayanaTV;
        uttarRamayanaTV = binding.uttarRamayanaTV;
        shreeMahalaxmiTV = binding.shreeMahalaxmiTV;
        shivMahapuranTV = binding.shivMahapuranTV;
        jaiHanumanTV = binding.jaiHanumanTV;
        visnuPuranTV = binding.visnuPuranTV;
        balKrishnaTV = binding.balKrishnaTV;
        gitaGyanTV = binding.gitaGyanTV;
        bikramBatalTV = binding.bikramBatalTV;
        karanTV = binding.karanTV;
        sankatMochanHanumanTV = binding.sankatMochanHanumanTV;
        vignahranGaneshTV = binding.vignahranGaneshTV;
        saiNathTeraHajarohathTV = binding.saiNathTeraHajarohathTV;


    }


    private void youtubeAccount() {
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
            String youtubeAccountUrl = "https://youtube.googleapis.com/youtube/v3/channels?part=snippet,brandingSettings&id=" + youtubeAcountList.get(j) + "&key=" + apikey;

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, youtubeAccountUrl, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray jsonArray = response.getJSONArray("items");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            jsonObject.getString("id");
                            System.out.println("ID : " + jsonObject.getString("id"));

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
                        System.out.println("try catch error " + e.getMessage());
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO: Handle error
                    System.out.println("volly error " + error.getMessage());
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


        liveVideoRV = binding.liveVideoRV;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        liveVideoRV.setLayoutManager(linearLayoutManager);
        TvLiveVideoAdapter tvLiveVideoAdapter = new TvLiveVideoAdapter(tvLiveVideoModelArrayList, getContext(), this::itemClicked);
        liveVideoRV.setAdapter(tvLiveVideoAdapter);

        // for chalisa
        tvChalisaArrayList = new ArrayList<>();


        chalisaRV = binding.chalisaRV;
        LinearLayoutManager linearLayoutManagerChalisa = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        chalisaRV.setLayoutManager(linearLayoutManagerChalisa);
        TvLiveVideoAdapter tvChalisaAdapter = new TvLiveVideoAdapter(tvChalisaArrayList, getContext(), this::itemClicked);
        chalisaRV.setAdapter(tvChalisaAdapter);


        // for aarti
        tvAartiArrayList = new ArrayList<>();


        aartiRV = binding.aartiRV;
        LinearLayoutManager linearLayoutManagerAarti = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        aartiRV.setLayoutManager(linearLayoutManagerAarti);
        TvLiveVideoAdapter tvAartiAdapter = new TvLiveVideoAdapter(tvAartiArrayList, getContext(), this::itemClicked);
        aartiRV.setAdapter(tvAartiAdapter);


        // for bhajan
        bhajanArrayList = new ArrayList<>();


        bhajanRV = binding.bhajanRV;
        LinearLayoutManager linearLayoutManagerBhajan = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        bhajanRV.setLayoutManager(linearLayoutManagerBhajan);
        TvLiveVideoAdapter bhajanAdapter = new TvLiveVideoAdapter(bhajanArrayListYoutuberModel, getContext(), this::itemClicked);
        bhajanRV.setAdapter(bhajanAdapter);


        // for mantra
        mantraArrayList = new ArrayList<>();


        mantraRV = binding.mantraRV;
        LinearLayoutManager linearLayoutManagerMantra = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        mantraRV.setLayoutManager(linearLayoutManagerMantra);
        TvLiveVideoAdapter mantraAdapter = new TvLiveVideoAdapter(mantraArrayList, getContext(), this::itemClicked);
        mantraRV.setAdapter(mantraAdapter);


        // for dainik brat katha
        dainikBratKathaArrayList = new ArrayList<>();


        dainikBratKathaRV = binding.dainikBratKathaRV;
        LinearLayoutManager linearLayoutManagerDainikBratKatha = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        dainikBratKathaRV.setLayoutManager(linearLayoutManagerDainikBratKatha);
        TvLiveVideoAdapter dainikBratKathaAdapter = new TvLiveVideoAdapter(dainikBratKathaArrayList, getContext(), this::itemClicked);
        dainikBratKathaRV.setAdapter(dainikBratKathaAdapter);


        // for sadguru
        sadguruArrayList = new ArrayList<>();


        sadguruRV = binding.sadguruRV;
        LinearLayoutManager linearLayoutManagerSadguru = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        sadguruRV.setLayoutManager(linearLayoutManagerSadguru);
        TvLiveVideoAdapter sadguruAdapter = new TvLiveVideoAdapter(sadguruArrayList, getContext(), this::itemClicked);
        sadguruRV.setAdapter(sadguruAdapter);


        // for Gurudev Sri Sri Ravishankar
        gurudevSriSriRavishankerArrayList = new ArrayList<>();

        guruDevSriSriRV = binding.gurudevSriSriRavishankerRV;
        LinearLayoutManager linearLayoutManagerGurudevSriSriRaviShanker = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        guruDevSriSriRV.setLayoutManager(linearLayoutManagerGurudevSriSriRaviShanker);
        TvLiveVideoAdapter guruSriSriRavishankerAdapter = new TvLiveVideoAdapter(gurudevSriSriRavishankerArrayList, getContext(), this::itemClicked);
        guruDevSriSriRV.setAdapter(guruSriSriRavishankerAdapter);


    }

    private void loadBhajan() {

        System.out.println("Load Bhajan");

        String youtubeBhajanUrl = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=UCfzYE5p3KDmRQKUpOLz1_tw&eventType=live&eventType=none&maxResults=250&chart=mostPopular&q=news&order=viewCount&type=video&videoDefinition=any&key=" + apikey;


        System.out.println("LOADING VIDEO");
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, youtubeBhajanUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        JSONObject idJsonObject = jsonObject.getJSONObject("id");
                        idJsonObject.getString("videoId");
                        System.out.println("VIDEO ID of bhajan : " + idJsonObject.getString("videoId"));

                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("title");
                        snippetJsonObject.getString("channelId");
                        snippetJsonObject.getString("description");
                        snippetJsonObject.getString("liveBroadcastContent");

                        System.out.println("VIDEO TITLE of bhajan : " + snippetJsonObject.getString("title"));
                        System.out.println("VIDEO DESCRIPTION of bhajan : " + snippetJsonObject.getString("description"));

                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("URL of bhajan : " + mediumJsonObject.getString("url"));

                        YoutubeDashboradModel youtubeDashboradModel = new YoutubeDashboradModel(
                                mediumJsonObject.getString("url"),
                                snippetJsonObject.getString("description"),
                                snippetJsonObject.getString("title"),
                                idJsonObject.getString("videoId"),
                                snippetJsonObject.getString("liveBroadcastContent"),
                                snippetJsonObject.getString("channelId")

                        );

                        bhajanArrayListYoutuberModel.add(youtubeDashboradModel);

                        System.out.println("live video of bhajan : " + youtubeDashboradModel.getVideoLiveBroadcastContent());
                    }


//
//                    YoutubeDashboardAdapter youtubeDashboardAdapter1 = new YoutubeDashboardAdapter(getContext(), bhajanArrayListYoutuberModel);
                    TvLiveVideoAdapter tvLiveVideoAdapter = new TvLiveVideoAdapter(bhajanArrayListYoutuberModel, getContext(), TvFragment.this::itemClicked);
                    bhajanRV.setAdapter(tvLiveVideoAdapter);


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadAarti() {


        System.out.println("Loading Aarti");


        String urlvk = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLfx6o81oSA-qncdFkqIattVxgOdO-BMNC&key="+apikey +"&part=contentDetails&maxResults=5";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlvk, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        JSONObject idJsonObject = jsonObject.getJSONObject("contentDetails");
                        idJsonObject.getString("videoId");
                        System.out.println("VIDEO ID of Dainik Vrat Katha  : " + idJsonObject.getString("videoId"));

                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("title");
                        snippetJsonObject.getString("channelId");
                        snippetJsonObject.getString("description");
//                        snippetJsonObject.getString("liveBroadcastContent");
                        snippetJsonObject.getString("channelTitle");
                        snippetJsonObject.getString("playlistId");

                        System.out.println("VIDEO TITLE of dainik brat katha  : " + snippetJsonObject.getString("title"));
                        System.out.println("VIDEO DESCRIPTION of dbk : " + snippetJsonObject.getString("description"));

                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("URL of dbk : " + mediumJsonObject.getString("url"));

                        YoutubeDashboradModel youtubeDashboradModel = new YoutubeDashboradModel(
                                mediumJsonObject.getString("url"),
                                snippetJsonObject.getString("description"),
                                snippetJsonObject.getString("title"),
                                idJsonObject.getString("videoId"),
                                "none",
                                snippetJsonObject.getString("channelId")

                        );
                        tvAartiArrayList.add(youtubeDashboradModel);
                    }


//
//                    YoutubeDashboardAdapter youtubeDashboardAdapter1 = new YoutubeDashboardAdapter(getContext(), dainikBratKathaArrayList);
                    TvLiveVideoAdapter tvLiveVideoAdapter = new TvLiveVideoAdapter(tvAartiArrayList, getContext(), TvFragment.this::itemClicked);
                    aartiRV.setAdapter(tvLiveVideoAdapter);


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);




//
//        System.out.println("Loading Aarti");
//
//        String urlvk = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLfx6o81oSA-oonikoLBHKk5OeklJMTwqn&key="+apikey +"&part=contentDetails&maxResults=5";
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlvk, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONArray jsonArray = response.getJSONArray("items");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//                        JSONObject idJsonObject = jsonObject.getJSONObject("contentDetails");
//                        idJsonObject.getString("videoId");
//                        System.out.println("VIDEO ID of Dainik Vrat Katha  : " + idJsonObject.getString("videoId"));
//
//                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
//                        snippetJsonObject.getString("title");
//                        snippetJsonObject.getString("channelId");
//                        snippetJsonObject.getString("description");
////                        snippetJsonObject.getString("liveBroadcastContent");
//                        snippetJsonObject.getString("channelTitle");
//                        snippetJsonObject.getString("playlistId");
//
//                        System.out.println("VIDEO TITLE of dainik brat katha  : " + snippetJsonObject.getString("title"));
//                        System.out.println("VIDEO DESCRIPTION of dbk : " + snippetJsonObject.getString("description"));
//
//                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
//                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");
//
//                        mediumJsonObject.getString("url");
//                        System.out.println("URL of dbk : " + mediumJsonObject.getString("url"));
//
//                        YoutubeDashboradModel youtubeDashboradModel = new YoutubeDashboradModel(
//                                mediumJsonObject.getString("url"),
//                                snippetJsonObject.getString("description"),
//                                snippetJsonObject.getString("title"),
//                                idJsonObject.getString("videoId"),
//                                "none",
//                                snippetJsonObject.getString("channelId")
//
//                        );
//                        tvAartiArrayList.add(youtubeDashboradModel);
//                    }
//
//
////
////                    YoutubeDashboardAdapter youtubeDashboardAdapter1 = new YoutubeDashboardAdapter(getContext(), dainikBratKathaArrayList);
//                    TvLiveVideoAdapter tvLiveVideoAdapter = new TvLiveVideoAdapter(tvAartiArrayList, getContext(), TvFragment.this::itemClicked);
//                    aartiRV.setAdapter(tvLiveVideoAdapter);
//
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // TODO: Handle error
//
//            }
//        });
//
//        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadLiveVideo() {

        System.out.println("Loading Aarti");

        String youtubeBhajanUrl = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=UCx3--yoxFz4RF13KMGH7__g&eventType=live&eventType=none&maxResults=250&chart=mostPopular&q=news&order=viewCount&type=video&videoDefinition=any&key=" + apikey;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, youtubeBhajanUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        JSONObject idJsonObject = jsonObject.getJSONObject("id");
                        idJsonObject.getString("videoId");
                        System.out.println("VIDEO ID of bhajan : " + idJsonObject.getString("videoId"));

                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("title");
                        snippetJsonObject.getString("channelId");
                        snippetJsonObject.getString("description");
                        snippetJsonObject.getString("liveBroadcastContent");

                        System.out.println("VIDEO TITLE of bhajan : " + snippetJsonObject.getString("title"));
                        System.out.println("VIDEO DESCRIPTION of bhajan : " + snippetJsonObject.getString("description"));

                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("URL of bhajan : " + mediumJsonObject.getString("url"));

                        YoutubeDashboradModel youtubeDashboradModel = new YoutubeDashboradModel(
                                mediumJsonObject.getString("url"),
                                snippetJsonObject.getString("description"),
                                snippetJsonObject.getString("title"),
                                idJsonObject.getString("videoId"),
                                snippetJsonObject.getString("liveBroadcastContent"),
                                snippetJsonObject.getString("channelId")

                        );

                        tvLiveVideoModelArrayList.add(youtubeDashboradModel);

                        System.out.println("live video of Aarti : " + youtubeDashboradModel.getVideoLiveBroadcastContent());
                    }


//
//                    YoutubeDashboardAdapter youtubeDashboardAdapter1 = new YoutubeDashboardAdapter(getContext(), bhajanArrayListYoutuberModel);
                    TvLiveVideoAdapter tvLiveVideoAdapter = new TvLiveVideoAdapter(tvLiveVideoModelArrayList, getContext(), TvFragment.this::itemClicked);
                    liveVideoRV.setAdapter(tvLiveVideoAdapter);


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadMantra() {



        System.out.println("Loading Aarti");


        String urlvk = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PL57FdneUw7RLbUAA9xb0bqJza-xbkMgbw&key="+apikey +"&part=contentDetails&maxResults=5";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlvk, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        JSONObject idJsonObject = jsonObject.getJSONObject("contentDetails");
                        idJsonObject.getString("videoId");
                        System.out.println("VIDEO ID of Dainik Vrat Katha  : " + idJsonObject.getString("videoId"));

                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("title");
                        snippetJsonObject.getString("channelId");
                        snippetJsonObject.getString("description");
//                        snippetJsonObject.getString("liveBroadcastContent");
                        snippetJsonObject.getString("channelTitle");
                        snippetJsonObject.getString("playlistId");

                        System.out.println("VIDEO TITLE of dainik brat katha  : " + snippetJsonObject.getString("title"));
                        System.out.println("VIDEO DESCRIPTION of dbk : " + snippetJsonObject.getString("description"));

                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("URL of dbk : " + mediumJsonObject.getString("url"));

                        YoutubeDashboradModel youtubeDashboradModel = new YoutubeDashboradModel(
                                mediumJsonObject.getString("url"),
                                snippetJsonObject.getString("description"),
                                snippetJsonObject.getString("title"),
                                idJsonObject.getString("videoId"),
                                "none",
                                snippetJsonObject.getString("channelId")

                        );
                        mantraArrayList.add(youtubeDashboradModel);
                    }


//
//                    YoutubeDashboardAdapter youtubeDashboardAdapter1 = new YoutubeDashboardAdapter(getContext(), dainikBratKathaArrayList);
                    TvLiveVideoAdapter tvLiveVideoAdapter = new TvLiveVideoAdapter(mantraArrayList, getContext(), TvFragment.this::itemClicked);
                    mantraRV.setAdapter(tvLiveVideoAdapter);


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);


    }

    private void loadDainikBratKatha() {

        System.out.println("Loading Dainik Brat Katha ");


//        String urlvks = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLfx6o81oSA-pl3iLsHPoK3oUWWIU8awC3&key=AIzaSyBA5stcvWxiMf5PhX6HRQJJMhC2a6ovzxo&part=contentDetails&maxResults=20&chart=mostPopular&order=viewCount";
//        String youtubeBhajanUrl = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=UCtzWNV1gw53ecASMQ-6Esnw&eventType=live&eventType=none&maxResults=250&chart=mostPopular&q=news&order=viewCount&type=video&videoDefinition=any&key=" + apikey;


        String urlvk = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLfx6o81oSA-pl3iLsHPoK3oUWWIU8awC3&key="+apikey +"&part=contentDetails&maxResults=5";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlvk, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        JSONObject idJsonObject = jsonObject.getJSONObject("contentDetails");
                        idJsonObject.getString("videoId");
                        System.out.println("VIDEO ID of Dainik Vrat Katha  : " + idJsonObject.getString("videoId"));

                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("title");
                        snippetJsonObject.getString("channelId");
                        snippetJsonObject.getString("description");
//                        snippetJsonObject.getString("liveBroadcastContent");
                        snippetJsonObject.getString("channelTitle");
                        snippetJsonObject.getString("playlistId");

                        System.out.println("VIDEO TITLE of dainik brat katha  : " + snippetJsonObject.getString("title"));
                        System.out.println("VIDEO DESCRIPTION of dbk : " + snippetJsonObject.getString("description"));

                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("URL of dbk : " + mediumJsonObject.getString("url"));

                        YoutubeDashboradModel youtubeDashboradModel = new YoutubeDashboradModel(
                                mediumJsonObject.getString("url"),
                                snippetJsonObject.getString("description"),
                                snippetJsonObject.getString("title"),
                                idJsonObject.getString("videoId"),
                                "none",
                                snippetJsonObject.getString("channelId")

                        );
                        dainikBratKathaArrayList.add(youtubeDashboradModel);
                    }


//
//                    YoutubeDashboardAdapter youtubeDashboardAdapter1 = new YoutubeDashboardAdapter(getContext(), dainikBratKathaArrayList);
                    TvLiveVideoAdapter tvLiveVideoAdapter = new TvLiveVideoAdapter(dainikBratKathaArrayList, getContext(), TvFragment.this::itemClicked);
                    dainikBratKathaRV.setAdapter(tvLiveVideoAdapter);


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadSadguru() {

        System.out.println("Loading Aarti");

        String youtubeBhajanUrl = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=UCgaiWfiix1zaQS6Mn5SIw2g&eventType=live&eventType=none&maxResults=250&chart=mostPopular&q=news&order=viewCount&type=video&videoDefinition=any&key=" + apikey;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, youtubeBhajanUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        JSONObject idJsonObject = jsonObject.getJSONObject("id");
                        idJsonObject.getString("videoId");
                        System.out.println("VIDEO ID of bhajan : " + idJsonObject.getString("videoId"));

                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("title");
                        snippetJsonObject.getString("channelId");
                        snippetJsonObject.getString("description");
                        snippetJsonObject.getString("liveBroadcastContent");

                        System.out.println("VIDEO TITLE of bhajan : " + snippetJsonObject.getString("title"));
                        System.out.println("VIDEO DESCRIPTION of bhajan : " + snippetJsonObject.getString("description"));

                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("URL of bhajan : " + mediumJsonObject.getString("url"));

                        YoutubeDashboradModel youtubeDashboradModel = new YoutubeDashboradModel(
                                mediumJsonObject.getString("url"),
                                snippetJsonObject.getString("description"),
                                snippetJsonObject.getString("title"),
                                idJsonObject.getString("videoId"),
                                snippetJsonObject.getString("liveBroadcastContent"),
                                snippetJsonObject.getString("channelId")

                        );

                        sadguruArrayList.add(youtubeDashboradModel);

                        System.out.println("live video of Aarti : " + youtubeDashboradModel.getVideoLiveBroadcastContent());
                    }


//
//                    YoutubeDashboardAdapter youtubeDashboardAdapter1 = new YoutubeDashboardAdapter(getContext(), bhajanArrayListYoutuberModel);
                    TvLiveVideoAdapter tvLiveVideoAdapter = new TvLiveVideoAdapter(sadguruArrayList, getContext(), TvFragment.this::itemClicked);
                    sadguruRV.setAdapter(tvLiveVideoAdapter);


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadGurudevSriSriRaviSanker() {

        System.out.println("Loading Aarti");


        String youtubeBhajanUrl = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=UC60K5WIeDKvsJk2hL0QLYwA&eventType=live&eventType=none&maxResults=250&chart=mostPopular&q=news&order=viewCount&type=video&videoDefinition=any&key=" + apikey;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, youtubeBhajanUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        JSONObject idJsonObject = jsonObject.getJSONObject("id");
                        idJsonObject.getString("videoId");
                        System.out.println("VIDEO ID of bhajan : " + idJsonObject.getString("videoId"));

                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("title");
                        snippetJsonObject.getString("channelId");
                        snippetJsonObject.getString("description");
                        snippetJsonObject.getString("liveBroadcastContent");

                        System.out.println("VIDEO TITLE of bhajan : " + snippetJsonObject.getString("title"));
                        System.out.println("VIDEO DESCRIPTION of bhajan : " + snippetJsonObject.getString("description"));

                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("URL of bhajan : " + mediumJsonObject.getString("url"));

                        YoutubeDashboradModel youtubeDashboradModel = new YoutubeDashboradModel(
                                mediumJsonObject.getString("url"),
                                snippetJsonObject.getString("description"),
                                snippetJsonObject.getString("title"),
                                idJsonObject.getString("videoId"),
                                snippetJsonObject.getString("liveBroadcastContent"),
                                snippetJsonObject.getString("channelId")

                        );

                        gurudevSriSriRavishankerArrayList.add(youtubeDashboradModel);

                        System.out.println("live video of Aarti : " + youtubeDashboradModel.getVideoLiveBroadcastContent());
                    }


//
//                    YoutubeDashboardAdapter youtubeDashboardAdapter1 = new YoutubeDashboardAdapter(getContext(), bhajanArrayListYoutuberModel);
                    TvLiveVideoAdapter tvLiveVideoAdapter = new TvLiveVideoAdapter(gurudevSriSriRavishankerArrayList, getContext(), TvFragment.this::itemClicked);
                    guruDevSriSriRV.setAdapter(tvLiveVideoAdapter);


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadChalisa() {

        System.out.println("Loading Aarti");

        String youtubeBhajanUrl = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=UCaayLD9i5x4MmIoVZxXSv_g&eventType=live&eventType=none&maxResults=250&chart=mostPopular&q=news&order=viewCount&type=video&videoDefinition=any&key=" + apikey;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, youtubeBhajanUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        JSONObject idJsonObject = jsonObject.getJSONObject("id");
                        idJsonObject.getString("videoId");
                        System.out.println("VIDEO ID of bhajan : " + idJsonObject.getString("videoId"));

                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("title");
                        snippetJsonObject.getString("channelId");
                        snippetJsonObject.getString("description");
                        snippetJsonObject.getString("liveBroadcastContent");

                        System.out.println("VIDEO TITLE of bhajan : " + snippetJsonObject.getString("title"));
                        System.out.println("VIDEO DESCRIPTION of bhajan : " + snippetJsonObject.getString("description"));

                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("URL of bhajan : " + mediumJsonObject.getString("url"));

                        YoutubeDashboradModel youtubeDashboradModel = new YoutubeDashboradModel(
                                mediumJsonObject.getString("url"),
                                snippetJsonObject.getString("description"),
                                snippetJsonObject.getString("title"),
                                idJsonObject.getString("videoId"),
                                snippetJsonObject.getString("liveBroadcastContent"),
                                snippetJsonObject.getString("channelId")

                        );

                        tvChalisaArrayList.add(youtubeDashboradModel);

                        System.out.println("live video of Aarti : " + youtubeDashboradModel.getVideoLiveBroadcastContent());
                    }


//
//                    YoutubeDashboardAdapter youtubeDashboardAdapter1 = new YoutubeDashboardAdapter(getContext(), bhajanArrayListYoutuberModel);
                    TvLiveVideoAdapter tvLiveVideoAdapter = new TvLiveVideoAdapter(tvChalisaArrayList, getContext(), TvFragment.this::itemClicked);
                    chalisaRV.setAdapter(tvLiveVideoAdapter);


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadOtherTVSerial() {

        System.out.println("Loading Other TV Serial ... ");
        loadMahabharat();
        loadSampurnRamayana();
        loadUttarRamayana();
        loadShreeMahalaxmi();
        loadSampurnRamayana();
        loadshivMahapuran();
        loadjaiHanuman();
        loadbalKrishna();
        loadgitaGyan();
        loadbikramBatal();
        loadkaran();
        loadsankatMochanHanuman();
        loadvisnuPuran();
        loadvignahranGanesh();
        loadsaiNathTeraHajarohath();

        System.out.println("Loaded Other TV Serial");
    }

    private void loadMahabharat() {

        System.out.println("Loading Other TV Serial ... ");
        String mahabharatUrl = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLFr_jkwUp0hhm1lR1TSdgESOfoyLQR3t2&key=" + apikey + "&part=contentDetails&maxResults=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mahabharatUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject pageOptionJsonObject = response.getJSONObject("pageInfo");
                    pageOptionJsonObject.getString("totalResults");
                    mahabharatTV.setText(pageOptionJsonObject.getString("totalResults").toString() + " " + "Episode");
                    System.out.println("Total Video : " + pageOptionJsonObject.getString("totalResults"));


                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("playlistId");
                        System.out.println("Playlist ID : " + snippetJsonObject.getString("playlistId"));


                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("Image URL  : " + mediumJsonObject.getString("url"));

                        Picasso.with(getContext())
                                .load(mediumJsonObject.getString("url").toString())
                                .placeholder(R.drawable.ic_profile_svgrepo_com)
                                .into(binding.mahabharatImageView);


                    }


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadSampurnRamayana() {

        System.out.println("Loading Other TV Serial ... ");
        String mahabharatUrl = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLFPJRCFRDARSZofcQcV6m7Pu2EAL8_1dv&key=" + apikey + "&part=contentDetails&maxResults=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mahabharatUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject pageOptionJsonObject = response.getJSONObject("pageInfo");
                    pageOptionJsonObject.getString("totalResults");
                    sampurnRamayanaTV.setText(pageOptionJsonObject.getString("totalResults").toString() + " " + "Episode");
                    System.out.println("Total Video : " + pageOptionJsonObject.getString("totalResults"));

                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("playlistId");
                        System.out.println("Playlist ID : " + snippetJsonObject.getString("playlistId"));


                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("Image URL  : " + mediumJsonObject.getString("url"));

                        Picasso.with(getContext())
                                .load(mediumJsonObject.getString("url").toString())
                                .placeholder(R.drawable.ic_profile_svgrepo_com)
                                .into(binding.sampurnRamayanaIV);


                    }


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadUttarRamayana() {

        System.out.println("Loading Other TV Serial ... ");
        String mahabharatUrl = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLFr_jkwUp0hhyQevNGOYNOMJnQMxUVbYF&key=" + apikey + "&part=contentDetails&maxResults=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mahabharatUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject pageOptionJsonObject = response.getJSONObject("pageInfo");
                    pageOptionJsonObject.getString("totalResults");
                    uttarRamayanaTV.setText(pageOptionJsonObject.getString("totalResults").toString() + " " + "Episode");
                    System.out.println("Total Video : " + pageOptionJsonObject.getString("totalResults"));

                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("playlistId");
                        System.out.println("Playlist ID : " + snippetJsonObject.getString("playlistId"));


                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("Image URL  : " + mediumJsonObject.getString("url"));

                        Picasso.with(getContext())
                                .load(mediumJsonObject.getString("url").toString())
                                .placeholder(R.drawable.ic_profile_svgrepo_com)
                                .into(binding.uttarRamayanaIV);


                    }


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadShreeMahalaxmi() {

        System.out.println("Loading Other TV Serial ... ");
        String mahabharatUrl = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLFr_jkwUp0hgkkuYwmaFJ1uyoN7uz2zTh&key=" + apikey + "&part=contentDetails&maxResults=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mahabharatUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject pageOptionJsonObject = response.getJSONObject("pageInfo");
                    pageOptionJsonObject.getString("totalResults");
                    shreeMahalaxmiTV.setText(pageOptionJsonObject.getString("totalResults").toString() + " " + "Episode");
                    System.out.println("Total Video : " + pageOptionJsonObject.getString("totalResults"));

                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("playlistId");
                        System.out.println("Playlist ID : " + snippetJsonObject.getString("playlistId"));


                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("Image URL  : " + mediumJsonObject.getString("url"));

                        Picasso.with(getContext())
                                .load(mediumJsonObject.getString("url").toString())
                                .placeholder(R.drawable.ic_profile_svgrepo_com)
                                .into(binding.shreeMahalaxmiIV);


                    }


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadshivMahapuran() {

        System.out.println("Loading Other TV Serial ... ");
        String mahabharatUrl = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PL57F01972FF119B66&key=" + apikey + "&part=contentDetails&maxResults=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mahabharatUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject pageOptionJsonObject = response.getJSONObject("pageInfo");
                    pageOptionJsonObject.getString("totalResults");
                    shivMahapuranTV.setText(pageOptionJsonObject.getString("totalResults").toString() + " " + "Episode");
                    System.out.println("Total Video : " + pageOptionJsonObject.getString("totalResults"));

                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("playlistId");
                        System.out.println("Playlist ID : " + snippetJsonObject.getString("playlistId"));


                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("Image URL  : " + mediumJsonObject.getString("url"));

                        Picasso.with(getContext())
                                .load(mediumJsonObject.getString("url").toString())
                                .placeholder(R.drawable.ic_profile_svgrepo_com)
                                .into(binding.shivMahapuranIV);


                    }


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadjaiHanuman() {

        System.out.println("Loading Other TV Serial ... ");
        String mahabharatUrl = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLxAeSrqQeWdVRBmLQEbmrzPnGrgADaNFw&key=" + apikey + "&part=contentDetails&maxResults=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mahabharatUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject pageOptionJsonObject = response.getJSONObject("pageInfo");
                    pageOptionJsonObject.getString("totalResults");
                    jaiHanumanTV.setText(pageOptionJsonObject.getString("totalResults").toString() + " " + "Episode");
                    System.out.println("Total Video : " + pageOptionJsonObject.getString("totalResults"));

                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("playlistId");
                        System.out.println("Playlist ID : " + snippetJsonObject.getString("playlistId"));


                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("Image URL  : " + mediumJsonObject.getString("url"));

                        Picasso.with(getContext())
                                .load(mediumJsonObject.getString("url").toString())
                                .placeholder(R.drawable.ic_profile_svgrepo_com)
                                .into(binding.jaiHanumanIV);


                    }


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadbalKrishna() {

        System.out.println("Loading Other TV Serial ... ");
        String mahabharatUrl = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLFr_jkwUp0hgeL8Tvt4a8reRmum760h5G&key=" + apikey + "&part=contentDetails&maxResults=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mahabharatUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject pageOptionJsonObject = response.getJSONObject("pageInfo");
                    pageOptionJsonObject.getString("totalResults");
                    balKrishnaTV.setText(pageOptionJsonObject.getString("totalResults").toString() + " " + "Episode");
                    System.out.println("Total Video : " + pageOptionJsonObject.getString("totalResults"));

                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("playlistId");
                        System.out.println("Playlist ID : " + snippetJsonObject.getString("playlistId"));


                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("Image URL  : " + mediumJsonObject.getString("url"));

                        Picasso.with(getContext())
                                .load(mediumJsonObject.getString("url").toString())
                                .placeholder(R.drawable.ic_profile_svgrepo_com)
                                .into(binding.balKrishnaIV);


                    }


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadgitaGyan() {

        System.out.println("Loading Other TV Serial ... ");
        String mahabharatUrl = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLFPJRCFRDARSRskyLvVn6ukSQvLq2c_iy&key=" + apikey + "&part=contentDetails&maxResults=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mahabharatUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject pageOptionJsonObject = response.getJSONObject("pageInfo");
                    pageOptionJsonObject.getString("totalResults");
                    gitaGyanTV.setText(pageOptionJsonObject.getString("totalResults").toString() + " " + "Episode");
                    System.out.println("Total Video : " + pageOptionJsonObject.getString("totalResults"));

                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("playlistId");
                        System.out.println("Playlist ID : " + snippetJsonObject.getString("playlistId"));


                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("Image URL  : " + mediumJsonObject.getString("url"));

                        Picasso.with(getContext())
                                .load(mediumJsonObject.getString("url").toString())
                                .placeholder(R.drawable.ic_profile_svgrepo_com)
                                .into(binding.gitaGyanIV);


                    }


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadbikramBatal() {

        System.out.println("Loading Other TV Serial ... ");
        String mahabharatUrl = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLFr_jkwUp0hjTXfIElDpIfgBYUwWhKnSn&key=" + apikey + "&part=contentDetails&maxResults=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mahabharatUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject pageOptionJsonObject = response.getJSONObject("pageInfo");
                    pageOptionJsonObject.getString("totalResults");
                    bikramBatalTV.setText(pageOptionJsonObject.getString("totalResults").toString() + " " + "Episode");
                    System.out.println("Total Video : " + pageOptionJsonObject.getString("totalResults"));

                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("playlistId");
                        System.out.println("Playlist ID : " + snippetJsonObject.getString("playlistId"));


                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("Image URL  : " + mediumJsonObject.getString("url"));

                        Picasso.with(getContext())
                                .load(mediumJsonObject.getString("url").toString())
                                .placeholder(R.drawable.ic_profile_svgrepo_com)
                                .into(binding.bikramBatalIV);


                    }


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadkaran() {

        System.out.println("Loading Other TV Serial ... ");
        String mahabharatUrl = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLzufeTFnhupzEKODFa86wWlD8HYEqMage&key=" + apikey + "&part=contentDetails&maxResults=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mahabharatUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject pageOptionJsonObject = response.getJSONObject("pageInfo");
                    pageOptionJsonObject.getString("totalResults");
                    karanTV.setText(pageOptionJsonObject.getString("totalResults").toString() + " " + "Episode");
                    System.out.println("Total Video : " + pageOptionJsonObject.getString("totalResults"));

                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("playlistId");
                        System.out.println("Playlist ID : " + snippetJsonObject.getString("playlistId"));


                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("Image URL  : " + mediumJsonObject.getString("url"));

                        Picasso.with(getContext())
                                .load(mediumJsonObject.getString("url").toString())
                                .placeholder(R.drawable.ic_profile_svgrepo_com)
                                .into(binding.karanIV);


                    }


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadsankatMochanHanuman() {

        System.out.println("Loading Other TV Serial ... ");
        String mahabharatUrl = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLlNHEsFhS-kVLRmuQyssIkr_qaPmyaKC7&key=" + apikey + "&part=contentDetails&maxResults=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mahabharatUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject pageOptionJsonObject = response.getJSONObject("pageInfo");
                    pageOptionJsonObject.getString("totalResults");
                    sankatMochanHanumanTV.setText(pageOptionJsonObject.getString("totalResults").toString() + " " + "Episode");
                    System.out.println("Total Video : " + pageOptionJsonObject.getString("totalResults"));

                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("playlistId");
                        System.out.println("Playlist ID : " + snippetJsonObject.getString("playlistId"));


                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("Image URL  : " + mediumJsonObject.getString("url"));

                        Picasso.with(getContext())
                                .load(mediumJsonObject.getString("url").toString())
                                .placeholder(R.drawable.ic_profile_svgrepo_com)
                                .into(binding.sankatMochanHanumanIV);


                    }


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadvisnuPuran() {

        System.out.println("Loading Other TV Serial ... ");
        String mahabharatUrl = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLQQa2ptMYrubalxxhseMKKZBYMGk_MC26&key=" + apikey + "&part=contentDetails&maxResults=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mahabharatUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject pageOptionJsonObject = response.getJSONObject("pageInfo");
                    pageOptionJsonObject.getString("totalResults");
                    visnuPuranTV.setText(pageOptionJsonObject.getString("totalResults").toString() + " " + "Episode");
                    System.out.println("Total Video : " + pageOptionJsonObject.getString("totalResults"));

                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("playlistId");
                        System.out.println("Playlist ID : " + snippetJsonObject.getString("playlistId"));


                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("Image URL  : " + mediumJsonObject.getString("url"));

                        Picasso.with(getContext())
                                .load(mediumJsonObject.getString("url").toString())
                                .placeholder(R.drawable.ic_profile_svgrepo_com)
                                .into(binding.visnuPuranIV);


                    }


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadvignahranGanesh() {

        System.out.println("Loading Other TV Serial ... ");
        String mahabharatUrl = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLsGrL5_XD8WI8OKxiqOkNRRJT-Vnrb7qT&key=" + apikey + "&part=contentDetails&maxResults=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mahabharatUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject pageOptionJsonObject = response.getJSONObject("pageInfo");
                    pageOptionJsonObject.getString("totalResults");
                    vignahranGaneshTV.setText(pageOptionJsonObject.getString("totalResults").toString() + " " + "Episode");
                    System.out.println("Total Video : " + pageOptionJsonObject.getString("totalResults"));

                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("playlistId");
                        System.out.println("Playlist ID : " + snippetJsonObject.getString("playlistId"));


                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("Image URL  : " + mediumJsonObject.getString("url"));

                        Picasso.with(getContext())
                                .load(mediumJsonObject.getString("url").toString())
                                .placeholder(R.drawable.ic_profile_svgrepo_com)
                                .into(binding.vignahranGaneshIV);


                    }


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }

    private void loadsaiNathTeraHajarohath() {

        System.out.println("Loading Other TV Serial ... ");
        String mahabharatUrl = "https://youtube.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLVkaGZKVjEqQgBqA8-12rEun4OnhjlawN&key=" + apikey + "&part=contentDetails&maxResults=1";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mahabharatUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject pageOptionJsonObject = response.getJSONObject("pageInfo");
                    pageOptionJsonObject.getString("totalResults");
                    saiNathTeraHajarohathTV.setText(pageOptionJsonObject.getString("totalResults").toString() + " " + "Episode");
                    System.out.println("Total Video : " + pageOptionJsonObject.getString("totalResults"));

                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
                        snippetJsonObject.getString("playlistId");
                        System.out.println("Playlist ID : " + snippetJsonObject.getString("playlistId"));


                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        mediumJsonObject.getString("url");
                        System.out.println("Image URL  : " + mediumJsonObject.getString("url"));

                        Picasso.with(getContext())
                                .load(mediumJsonObject.getString("url").toString())
                                .placeholder(R.drawable.ic_profile_svgrepo_com)
                                .into(binding.saiNathTeraHajarohathIV);


                    }


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

        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);

    }


    private void gridListData() {
        list = new ArrayList<>();
    }

    @Override
    public void itemClicked(String userId, String videoID) {
        System.out.println("ITEM CLICKED");
        System.out.println("Video ID : " + videoID);
        System.out.println("LOADING VIDEO...");
        Toast.makeText(getContext(), "adapter clicked", Toast.LENGTH_SHORT).show();
//        loadVideoToYoutubeVideoPlayer(userId,videoID);
    }
}