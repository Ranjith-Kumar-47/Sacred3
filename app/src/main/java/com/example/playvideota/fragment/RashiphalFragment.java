package com.example.playvideota.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.playvideota.AdminRashiphal;
import com.example.playvideota.AdminRashiphalAddData;
import com.example.playvideota.R;
import com.example.playvideota.adapter.RashiphalAdapter;
import com.example.playvideota.databinding.FragmentRashiphalBinding;
import com.example.playvideota.model.RashiPhalModel;
import com.example.playvideota.model.RashiphalDataModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;


public class RashiphalFragment extends Fragment {

    FragmentRashiphalBinding binding;

    RecyclerView rashiphalRV;
    ArrayList<RashiPhalModel> list;
    FirebaseDatabase database;
    TextView rashiphalDataTextview,todayDateTextview;
    CardView Aquarius,Aries,Cancer,Capricon,Gemini,Libra,Leo,Pisces,Taurus,Virgo,Sagittarius;


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

        todayDateTextview.setText(startDate+" "+endDate+" " +"Rashiphal");





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
                            rashiphalDataTextview.setBackgroundResource(R.drawable.capriconorg);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




        return binding.getRoot();
    }

    private void clickHalderOnRashi() {
        Aquarius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                                    rashiphalDataTextview.setBackgroundResource(R.drawable.aquarius);
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
                                    rashiphalDataTextview.setBackgroundResource(R.drawable.aries);
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
                                    rashiphalDataTextview.setBackgroundResource(R.drawable.cancer);
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
                                    rashiphalDataTextview.setBackgroundResource(R.drawable.capriconorg);
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
                                    rashiphalDataTextview.setBackgroundResource(R.drawable.gemini);
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
                                    rashiphalDataTextview.setBackgroundResource(R.drawable.libra);
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
                                    rashiphalDataTextview.setBackgroundResource(R.drawable.lio);
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
                                    rashiphalDataTextview.setBackgroundResource(R.drawable.pisces);
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
                                    rashiphalDataTextview.setBackgroundResource(R.drawable.taurus);
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
                                    rashiphalDataTextview.setBackgroundResource(R.drawable.virgo);
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
                                    rashiphalDataTextview.setBackgroundResource(R.drawable.zodiac_sagarithus);
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
    }
}