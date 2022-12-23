package com.example.playvideota.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.playvideota.PanchangAbout;
import com.example.playvideota.PanchangAboutGanesh;
import com.example.playvideota.R;
import com.example.playvideota.databinding.FragmentPanchangBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class PanchangFragment extends Fragment {


    FragmentPanchangBinding binding;
    ImageView pachangDailyImageView;
    TextView panchangDailyTitleTextView,panchangDailyTitleDescriptionTextView,panchangDailyFestivalTextView;


    FirebaseDatabase database;

    TextView sasSubhMahuratTimeTv,sasGulikKalTimeTv,sasRahuKalTimeTv,sasyumghanatKalTimeTv;
    TextView ssSuryodayTimeTv,ssSuryaasthTimeTv,ssChandrodayTimeTv,ssChandroasthTimeTv;
    TextView thethiDetails,spMuleTv,spGandTv,spNagTv,spMuleTimeTv,spGandTimeTv,spNagTimeTv;
    TextView fbMahinaAmanatTv,fbfbMahinaAmanatData,fbMahinaPurnimatTv,fbfbMahinaPurnimatData,fbVikramSawanthTv,fbVikramSawanthData,fbSakSawanthTv,fbSakSawanthData;
    TextView sixBoxSuryaRashiTv,sixBoxSuryaRashiData,sixBoxChandRashiTv,sixBoxChandRashiData,sixBoxDisshasulTv,sixBoxDisshasulData,sixBoxChandraNiwasTv,sixBoxChandraNiwasData,sixBoxRetuTv,sixBoxsixBoxRetuData,sixBoxAyanTv,sixBoxAyanData;

    public PanchangFragment() {
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
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_panchang, container, false);
        binding = FragmentPanchangBinding.inflate(inflater,container,false);

//        TextView todayDateTextview = binding.todayDateTextview;
//        long millis = System.currentTimeMillis();
//
//        // creating a new object of the class Date
//        java.util.Date date = new java.util.Date(millis);
//        System.out.println(date);
//        String cDate = ""+date;
//        String startDate = cDate.substring(0,10);
//        String endDate = cDate.substring(29);
//
//        todayDateTextview.setText(" "+startDate+" "+endDate+" " );

        initingTextView();
        addingDataToTextView();


        pachangDailyImageView = binding.pachangDailyImageView;
        panchangDailyTitleTextView = binding.panchangDailyTitleTextView;
        panchangDailyTitleDescriptionTextView = binding.panchangDailyTitleDescriptionTextView;
        panchangDailyFestivalTextView = binding.panchangDailyFestivalTextView;

        database.getReference().child("Panchang")
                .child("daily_panchang")
                .child("daily_panchang_image")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            System.out.println("Value : "+snapshot.getValue());
//                            pachangDailyImageView.setImageURI(Uri.parse(snapshot.getValue().toString()));
                            Picasso.with(getContext()).load(snapshot.getValue().toString()).placeholder(R.drawable.ic_profile_svgrepo_com).into(binding.pachangDailyImageView);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


        database.getReference().child("Panchang")
                .child("daily_panchang").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){

                            System.out.println("value ta : "+snapshot.getValue());
                            System.out.println("key ta : "+snapshot.getKey());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




        database.getReference().child("Panchang")
                .child("daily_panchang")
                .child("panchang_description")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    System.out.println("Value : "+snapshot.getValue());
                                    panchangDailyTitleDescriptionTextView.setText(snapshot.getValue().toString());

                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

        database.getReference().child("Panchang")
                .child("daily_panchang")
                .child("panchang_festival").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            System.out.println("Value : "+snapshot.getValue());
                            panchangDailyFestivalTextView.setText(snapshot.getValue().toString());
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        database.getReference().child("Panchang")
                .child("daily_panchang")
                .child("panchang_title").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            System.out.println("Value : "+snapshot.getValue());
                            panchangDailyTitleTextView.setText(snapshot.getValue().toString());

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



        CardView cardView2 = binding.cardView2;
        CardView cardView3 = binding.cardView3;
//        CardView cardView4 = binding.cardView4;

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PanchangAbout.class);
                startActivity(intent);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PanchangAboutGanesh.class);
                startActivity(intent);
            }
        });

//        cardView4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), PanchangAbout.class);
//                startActivity(intent);
//            }
//        });



        return  binding.getRoot();
    }

    private void addingDataToTextView() {
    }

    private void initingTextView() {
        sasSubhMahuratTimeTv = binding.sasSubhMahuratTimeTv;
        sasGulikKalTimeTv = binding.sasGulikKalTimeTv;
        sasRahuKalTimeTv = binding.sasRahuKalTimeTv;
        sasyumghanatKalTimeTv = binding.sasyumghanatKalTimeTv;

        ssSuryodayTimeTv = binding.ssSuryodayTimeTv;
        ssSuryaasthTimeTv = binding.ssSuryaasthTimeTv;
        ssChandrodayTimeTv = binding.ssChandrodayTimeTv;
        ssChandroasthTimeTv = binding.ssChandroasthTimeTv;

        thethiDetails = binding.thethiDetails;
        spMuleTv = binding.spMuleTv;
        spGandTv = binding.spGandTv;
        spNagTv = binding.spNagTv;
        spMuleTimeTv = binding.spMuleTimeTv;
        spGandTimeTv = binding.spGandTimeTv;
        spNagTimeTv = binding.spNagTimeTv;

        fbMahinaAmanatTv = binding.fbMahinaAmanatTv;
        fbfbMahinaAmanatData = binding.fbfbMahinaAmanatData;
        fbMahinaPurnimatTv = binding.fbMahinaPurnimatTv;
        fbfbMahinaPurnimatData = binding.fbfbMahinaPurnimatData;
        fbVikramSawanthTv = binding.fbVikramSawanthTv;
        fbVikramSawanthData = binding.fbVikramSawanthData;
        fbSakSawanthTv = binding.fbSakSawanthTv;
        fbSakSawanthData = binding.fbSakSawanthData;

        sixBoxSuryaRashiTv = binding.sixBoxSuryaRashiTv;
        sixBoxSuryaRashiData = binding.sixBoxSuryaRashiData;
        sixBoxChandRashiTv = binding.sixBoxChandRashiTv;
        sixBoxChandRashiData = binding.sixBoxChandRashiData;
        sixBoxDisshasulTv = binding.sixBoxDisshasulTv;
        sixBoxDisshasulData = binding.sixBoxDisshasulData;
        sixBoxChandraNiwasTv = binding.sixBoxChandraNiwasTv;
        sixBoxChandraNiwasData = binding.sixBoxChandraNiwasData;
        sixBoxRetuTv = binding.sixBoxRetuTv;
        sixBoxsixBoxRetuData = binding.sixBoxsixBoxRetuData;
        sixBoxAyanTv = binding.sixBoxAyanTv;
        sixBoxAyanData = binding.sixBoxAyanData;


    }
}