package com.pujagoodies.sacred.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
//import com.example.playvideota.R;
import com.pujagoodies.sacred.R;
import com.pujagoodies.sacred.databinding.FragmentRashiphalBinding;
import com.pujagoodies.sacred.VideoPlayer;
import com.pujagoodies.sacred.api.MySingleton;
import com.pujagoodies.sacred.model.RashiPhalModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class RashiphalFragment extends Fragment {

    FragmentRashiphalBinding binding;

    RecyclerView rashiphalRV;
    ArrayList<RashiPhalModel> list;
    FirebaseDatabase database;
    TextView rashiphalDataTextview,todayDateTextview;
    CardView Aquarius,Aries,Cancer,Capricon,Gemini,Libra,Leo,Pisces,Taurus,Virgo,Sagittarius,scorpio;
    TextView aquariusTv,ariesTv,cancerTv,capriconTv,geminiTv,libraTv,leoTv,piscesTv,taurusTv,virgoTv,sagittariusTv,scorpioTv;
    ImageView adminVideo, adminVideoPlayButton;
    String videoIdData = "";

    String userId = "";
    String videoId = "";
    String videoTitle = "";
    String videoDescription = "";
    String videoLiveBroadcastContent = "";
    String channelIcon = "";
    String channelName = "";

    public RashiphalFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        return inflater.inflate(R.layout.fragment_rashiphal, container, false);
        binding = FragmentRashiphalBinding.inflate(inflater,container, false);

        list = new ArrayList<>();

        list.add(new RashiPhalModel(R.drawable.aquarius,"Aquarius"));
        list.add(new RashiPhalModel(R.drawable.aries,"Aries"));
        list.add(new RashiPhalModel(R.drawable.cancer,"Cancer"));
        list.add(new RashiPhalModel(R.drawable.capriconorg,"Capricon"));
        list.add(new RashiPhalModel(R.drawable.gemini,"Gemini"));
        list.add(new RashiPhalModel(R.drawable.libra,"Libra"));
        list.add(new RashiPhalModel(R.drawable.lio,"Leo"));
        list.add(new RashiPhalModel(R.drawable.pisces,"Pisces"));
        list.add(new RashiPhalModel(R.drawable.taurus,"Taurus"));
        list.add(new RashiPhalModel(R.drawable.virgo,"Virgo"));
        list.add(new RashiPhalModel(R.drawable.zodiac_sagarithus,"Sagittarius"));


//        rashiphalRV = binding.rashiphalRV;
//        RashiphalAdapter rashiphalAdapter = new RashiphalAdapter(getContext(),list);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
//        rashiphalRV.setLayoutManager(linearLayoutManager);
//        rashiphalRV.setNestedScrollingEnabled(false);
//        rashiphalRV.setAdapter(rashiphalAdapter);


        initialiseData();
        clickHalderOnRashi();

        long millis = System.currentTimeMillis();

        // creating a new object of the class Date
        java.util.Date date = new java.util.Date(millis);
        System.out.println(date);
        String cDate = ""+date;
        String startDate = cDate.substring(0,10);
        String endDate = cDate.substring(29);

//        आज 14 Nov, 2022

        todayDateTextview.setText(startDate+" "+endDate+" " +"राशिफल");




        lookSelected(capriconTv);
        database.getReference().child("Rashipal")
                .child("Capricon")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            System.out.println("Database Data : "+snapshot.toString());
                            System.out.println("Database Value : "+snapshot.getValue());
                            System.out.println("Database Key : "+snapshot.getKey());
//                            RashiphalDataModel data = snapshot.getValue(RashiphalDataModel.class);
                            rashiphalDataTextview.setText(snapshot.getValue().toString());
//                            rashiphalDataTextview.setBackgroundResource(R.drawable.capriconorg);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });

        database.getReference().child("Rashipal")
                .child("videoId")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            System.out.println("Database Data : "+snapshot.toString());
                            System.out.println("Database Value : "+snapshot.getValue());
                            System.out.println("Database Key : "+snapshot.getKey());
                            String videoIdValue = snapshot.getValue().toString();
                            videoIdData = videoIdValue;
                            adminVideo();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


        adminVideoPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VideoPlayer.class);
                intent.putExtra("userId", userId );
                intent.putExtra("videoId",videoId);
                intent.putExtra("videoTitle",videoTitle);
                intent.putExtra("videoDescription",videoDescription);
                intent.putExtra("videoLiveBroadcastContent",videoLiveBroadcastContent);
                intent.putExtra("channelIcon",channelIcon);
                intent.putExtra("channelName",channelName);
                v.getContext().startActivity(intent);
            }
        });






        return binding.getRoot();
    }
    @SuppressLint("ResourceAsColor")
    private void lookSelected(TextView parsedButton) {
        parsedButton.setBackgroundResource(R.drawable.yes_button_bg);
//        parsedButton.setBackgroundColor(R.color.orange);
        parsedButton.setTextColor(R.color.orange);


    }

    @SuppressLint("ResourceAsColor")
    private void lookUnSelected(TextView parsedButton) {
        parsedButton.setBackgroundResource(R.drawable.exit_dialog_bg);
//        parsedButton.setBackgroundColor(R.color.white);
        parsedButton.setTextColor(R.color.black);

    }

    private void adminVideo() {

        System.out.println("loading admin video...");
        String adminVideoUrl = "https://youtube.googleapis.com/youtube/v3/videos?part=snippet%2CcontentDetails%2Cstatistics&id="+ videoIdData +"&key=AIzaSyBA5stcvWxiMf5PhX6HRQJJMhC2a6ovzxo";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, adminVideoUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray jsonArray = response.getJSONArray("items");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");

                        userId = snippetJsonObject.getString("channelId");
                        videoTitle = snippetJsonObject.getString("title");
                        videoDescription = snippetJsonObject.getString("description");
                        channelName = snippetJsonObject.getString("channelTitle");
                        videoLiveBroadcastContent = snippetJsonObject.getString("liveBroadcastContent");
                        videoId = videoIdData;


                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");

                        channelIcon = mediumJsonObject.getString("url");
                        System.out.println("Image URL  : " + mediumJsonObject.getString("url"));

                        Picasso.with(getContext())
                                .load(mediumJsonObject.getString("url").toString())
                                .placeholder(R.drawable.ic_profile_svgrepo_com)
                                .into(binding.adminVideo);


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

    private void clickHalderOnRashi() {
        Aquarius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(aquariusTv);

                lookUnSelected(ariesTv);
                lookUnSelected(cancerTv);
                lookUnSelected(capriconTv);
                lookUnSelected(geminiTv);
                lookUnSelected(libraTv);
                lookUnSelected(leoTv);
                lookUnSelected(piscesTv);
                lookUnSelected(taurusTv);
                lookUnSelected(virgoTv);
                lookUnSelected(sagittariusTv);
                lookUnSelected(scorpioTv);


                database.getReference().child("Rashipal")
                        .child("Aquarius")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    System.out.println("Database Data : "+snapshot.toString());
                                    System.out.println("Database Value : "+snapshot.getValue());
                                    System.out.println("Database Key : "+snapshot.getKey());
                                    rashiphalDataTextview.setText(snapshot.getValue().toString());
//                                    rashiphalDataTextview.setBackgroundResource(R.drawable.aquarius);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
            }
        });

        Aries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lookSelected(ariesTv);

                lookUnSelected(aquariusTv);
                lookUnSelected(cancerTv);
                lookUnSelected(capriconTv);
                lookUnSelected(geminiTv);
                lookUnSelected(libraTv);
                lookUnSelected(leoTv);
                lookUnSelected(piscesTv);
                lookUnSelected(taurusTv);
                lookUnSelected(virgoTv);
                lookUnSelected(sagittariusTv);
                lookUnSelected(scorpioTv);

                database.getReference().child("Rashipal")
                        .child("Aries")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    System.out.println("Database Data : "+snapshot.toString());
                                    System.out.println("Database Value : "+snapshot.getValue());
                                    System.out.println("Database Key : "+snapshot.getKey());
                                    rashiphalDataTextview.setText(snapshot.getValue().toString());
//                                    rashiphalDataTextview.setBackgroundResource(R.drawable.aries);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
            }
        });

        Cancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lookSelected(cancerTv);

                lookUnSelected(ariesTv);
                lookUnSelected(aquariusTv);
//                lookUnSelected(cancerTv);
                lookUnSelected(capriconTv);
                lookUnSelected(geminiTv);
                lookUnSelected(libraTv);
                lookUnSelected(leoTv);
                lookUnSelected(piscesTv);
                lookUnSelected(taurusTv);
                lookUnSelected(virgoTv);
                lookUnSelected(sagittariusTv);
                lookUnSelected(scorpioTv);

                database.getReference().child("Rashipal")
                        .child("Cancer")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    System.out.println("Database Data : "+snapshot.toString());
                                    System.out.println("Database Value : "+snapshot.getValue());
                                    System.out.println("Database Key : "+snapshot.getKey());
                                    rashiphalDataTextview.setText(snapshot.getValue().toString());
//                                    rashiphalDataTextview.setBackgroundResource(R.drawable.cancer);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
            }
        });

        Capricon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lookSelected(capriconTv);

                lookUnSelected(ariesTv);
                lookUnSelected(aquariusTv);
                lookUnSelected(cancerTv);
//                lookUnSelected(capriconTv);
                lookUnSelected(geminiTv);
                lookUnSelected(libraTv);
                lookUnSelected(leoTv);
                lookUnSelected(piscesTv);
                lookUnSelected(taurusTv);
                lookUnSelected(virgoTv);
                lookUnSelected(sagittariusTv);
                lookUnSelected(scorpioTv);

                database.getReference().child("Rashipal")
                        .child("Capricon")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    System.out.println("Database Data : "+snapshot.toString());
                                    System.out.println("Database Value : "+snapshot.getValue());
                                    System.out.println("Database Key : "+snapshot.getKey());
                                    rashiphalDataTextview.setText(snapshot.getValue().toString());
//                                    rashiphalDataTextview.setBackgroundResource(R.drawable.capriconorg);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
            }
        });

        Gemini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lookSelected(geminiTv);

                lookUnSelected(ariesTv);
                lookUnSelected(aquariusTv);
                lookUnSelected(cancerTv);
                lookUnSelected(capriconTv);
//                lookUnSelected(geminiTv);
                lookUnSelected(libraTv);
                lookUnSelected(leoTv);
                lookUnSelected(piscesTv);
                lookUnSelected(taurusTv);
                lookUnSelected(virgoTv);
                lookUnSelected(sagittariusTv);
                lookUnSelected(scorpioTv);

                database.getReference().child("Rashipal")
                        .child("Gemini")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    System.out.println("Database Data : "+snapshot.toString());
                                    System.out.println("Database Value : "+snapshot.getValue());
                                    System.out.println("Database Key : "+snapshot.getKey());
                                    rashiphalDataTextview.setText(snapshot.getValue().toString());
//                                    rashiphalDataTextview.setBackgroundResource(R.drawable.gemini);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
            }
        });

        Libra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(libraTv);

                lookUnSelected(ariesTv);
                lookUnSelected(aquariusTv);
                lookUnSelected(cancerTv);
                lookUnSelected(capriconTv);
                lookUnSelected(geminiTv);
//                lookUnSelected(libraTv);
                lookUnSelected(leoTv);
                lookUnSelected(piscesTv);
                lookUnSelected(taurusTv);
                lookUnSelected(virgoTv);
                lookUnSelected(sagittariusTv);
                lookUnSelected(scorpioTv);

                database.getReference().child("Rashipal")
                        .child("Libra")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    System.out.println("Database Data : "+snapshot.toString());
                                    System.out.println("Database Value : "+snapshot.getValue());
                                    System.out.println("Database Key : "+snapshot.getKey());
                                    rashiphalDataTextview.setText(snapshot.getValue().toString());
//                                    rashiphalDataTextview.setBackgroundResource(R.drawable.libra);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
            }
        });

        Leo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lookSelected(leoTv);

                lookUnSelected(ariesTv);
                lookUnSelected(aquariusTv);
                lookUnSelected(cancerTv);
                lookUnSelected(capriconTv);
                lookUnSelected(geminiTv);
                lookUnSelected(libraTv);
//                lookUnSelected(leoTv);
                lookUnSelected(piscesTv);
                lookUnSelected(taurusTv);
                lookUnSelected(virgoTv);
                lookUnSelected(sagittariusTv);
                lookUnSelected(scorpioTv);

                database.getReference().child("Rashipal")
                        .child("Leo")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    System.out.println("Database Data : "+snapshot.toString());
                                    System.out.println("Database Value : "+snapshot.getValue());
                                    System.out.println("Database Key : "+snapshot.getKey());
                                    rashiphalDataTextview.setText(snapshot.getValue().toString());
//                                    rashiphalDataTextview.setBackgroundResource(R.drawable.lio);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
            }
        });

        Pisces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lookSelected(piscesTv);

                lookUnSelected(ariesTv);
                lookUnSelected(aquariusTv);
                lookUnSelected(cancerTv);
                lookUnSelected(capriconTv);
                lookUnSelected(geminiTv);
                lookUnSelected(libraTv);
                lookUnSelected(leoTv);
//                lookUnSelected(piscesTv);
                lookUnSelected(taurusTv);
                lookUnSelected(virgoTv);
                lookUnSelected(sagittariusTv);
                lookUnSelected(scorpioTv);

                database.getReference().child("Rashipal")
                        .child("Pisces")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    System.out.println("Database Data : "+snapshot.toString());
                                    System.out.println("Database Value : "+snapshot.getValue());
                                    System.out.println("Database Key : "+snapshot.getKey());
                                    rashiphalDataTextview.setText(snapshot.getValue().toString());
//                                    rashiphalDataTextview.setBackgroundResource(R.drawable.pisces);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
            }
        });

        Taurus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lookSelected(taurusTv);

                lookUnSelected(ariesTv);
                lookUnSelected(aquariusTv);
                lookUnSelected(cancerTv);
                lookUnSelected(capriconTv);
                lookUnSelected(geminiTv);
                lookUnSelected(libraTv);
                lookUnSelected(leoTv);
                lookUnSelected(piscesTv);
//                lookUnSelected(taurusTv);
                lookUnSelected(virgoTv);
                lookUnSelected(sagittariusTv);
                lookUnSelected(scorpioTv);
                database.getReference().child("Rashipal")
                        .child("Taurus")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    System.out.println("Database Data : "+snapshot.toString());
                                    System.out.println("Database Value : "+snapshot.getValue());
                                    System.out.println("Database Key : "+snapshot.getKey());
                                    rashiphalDataTextview.setText(snapshot.getValue().toString());
//                                    rashiphalDataTextview.setBackgroundResource(R.drawable.taurus);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
            }
        });

        Virgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lookSelected(virgoTv);

                lookUnSelected(ariesTv);
                lookUnSelected(aquariusTv);
                lookUnSelected(cancerTv);
                lookUnSelected(capriconTv);
                lookUnSelected(geminiTv);
                lookUnSelected(libraTv);
                lookUnSelected(leoTv);
                lookUnSelected(piscesTv);
                lookUnSelected(taurusTv);
//                lookUnSelected(virgoTv);
                lookUnSelected(sagittariusTv);
                lookUnSelected(scorpioTv);

                database.getReference().child("Rashipal")
                        .child("Virgo")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    System.out.println("Database Data : "+snapshot.toString());
                                    System.out.println("Database Value : "+snapshot.getValue());
                                    System.out.println("Database Key : "+snapshot.getKey());
                                    rashiphalDataTextview.setText(snapshot.getValue().toString());
//                                    rashiphalDataTextview.setBackgroundResource(R.drawable.virgo);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
            }
        });

        Sagittarius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lookSelected(sagittariusTv);

                lookUnSelected(ariesTv);
                lookUnSelected(aquariusTv);
                lookUnSelected(cancerTv);
                lookUnSelected(capriconTv);
                lookUnSelected(geminiTv);
                lookUnSelected(libraTv);
                lookUnSelected(leoTv);
                lookUnSelected(piscesTv);
                lookUnSelected(taurusTv);
                lookUnSelected(virgoTv);
//                lookUnSelected(sagittariusTv);
                lookUnSelected(scorpioTv);

                database.getReference().child("Rashipal")
                        .child("Sagittarius")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    System.out.println("Database Data : "+snapshot.toString());
                                    System.out.println("Database Value : "+snapshot.getValue());
                                    System.out.println("Database Key : "+snapshot.getKey());
                                    rashiphalDataTextview.setText(snapshot.getValue().toString());
//                                    rashiphalDataTextview.setBackgroundResource(R.drawable.zodiac_sagarithus);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
            }
        });

        scorpio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lookSelected(scorpioTv);

                lookUnSelected(ariesTv);
                lookUnSelected(aquariusTv);
                lookUnSelected(cancerTv);
                lookUnSelected(capriconTv);
                lookUnSelected(geminiTv);
                lookUnSelected(libraTv);
                lookUnSelected(leoTv);
                lookUnSelected(piscesTv);
                lookUnSelected(taurusTv);
                lookUnSelected(virgoTv);
                lookUnSelected(sagittariusTv);
//                lookUnSelected(scorpioTv);

                database.getReference().child("Rashipal")
                        .child("Scorpio")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    System.out.println("Database Data : "+snapshot.toString());
                                    System.out.println("Database Value : "+snapshot.getValue());
                                    System.out.println("Database Key : "+snapshot.getKey());
                                    rashiphalDataTextview.setText(snapshot.getValue().toString());
//                                    rashiphalDataTextview.setBackgroundResource(R.drawable.zodiac_sagarithus);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
            }
        });


    }

    private void initialiseData() {
        rashiphalDataTextview  = binding.rashiphalDataTextview;
        todayDateTextview = binding.todayDateTextview;
        Aquarius = binding.Aquarius;
        Aries = binding.Aries;
        Cancer = binding.Cancer;
        Capricon = binding.Capricon;
        Gemini = binding.Gemini;
        Libra = binding.Libra;
        Leo = binding.Leo;
        Pisces = binding.Pisces;
        Taurus = binding.Taurus;
        Virgo = binding.Virgo;
        Sagittarius = binding.Sagittarius;
        scorpio = binding.scorpio;


        aquariusTv =binding.aquariusTv;
        ariesTv = binding.ariesTv;
        cancerTv = binding.cancerTv;
        capriconTv = binding.capriconTv;
        geminiTv = binding.geminiTv;
        libraTv = binding.libraTv;
        leoTv = binding.leoTv;
        piscesTv = binding.piscesTv;
        taurusTv = binding.taurusTv;
        virgoTv = binding.virgoTv;
        sagittariusTv = binding.sagittariusTv;
        scorpioTv = binding.scorpioTv;

        adminVideo = binding.adminVideo;
        adminVideoPlayButton = binding.adminVideoPlayButton;

    }
}