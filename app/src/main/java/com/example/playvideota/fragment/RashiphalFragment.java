package com.example.playvideota.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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


public class RashiphalFragment extends Fragment {

    FragmentRashiphalBinding binding;

    RecyclerView rashiphalRV;
    ArrayList<RashiPhalModel> list;
    FirebaseDatabase database;
    TextView rashiphalDataTextview;


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


        rashiphalRV = binding.rashiphalRV;
        RashiphalAdapter rashiphalAdapter = new RashiphalAdapter(getContext(),list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rashiphalRV.setLayoutManager(linearLayoutManager);
        rashiphalRV.setNestedScrollingEnabled(false);
        rashiphalRV.setAdapter(rashiphalAdapter);

        rashiphalDataTextview  = binding.rashiphalDataTextview;



        database.getReference().child("Rashipal")
                .child("Aquarius")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            RashiphalDataModel data = snapshot.getValue(RashiphalDataModel.class);
                            rashiphalDataTextview.setText(data.getAquarius());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




        return binding.getRoot();
    }
}