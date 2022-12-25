package com.example.playvideota.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.playvideota.R;
import com.example.playvideota.YoutubeDashboard;
import com.example.playvideota.databinding.FragmentMannTvBinding;
import com.example.playvideota.databinding.FragmentTvBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


public class MannTvFragment extends Fragment {

    FragmentMannTvBinding binding;
    ImageView videoImage1,videoImage2;
    TextView videoDescription1,videoDescription2;
    FirebaseDatabase database;



    public MannTvFragment() {
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
        binding = FragmentMannTvBinding.inflate(inflater,container,false);

        initingData();
        settingData();

        clickHandler();

        return  binding.getRoot();
    }

    private void clickHandler() {
        videoImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), YoutubeDashboard.class);
                intent.putExtra("id","UCDe0DwkMVFfSIoiYdQUPQmQ");
                startActivity(intent);
            }
        });

        videoImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), YoutubeDashboard.class);
                intent.putExtra("id","UCHq7ZxlzRRXimaBmk5QAxSQ");
                startActivity(intent);
            }
        });
    }

    private void settingData() {
        database.getReference().child("channels")
                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
                .child("channelName")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            videoDescription1.setText(snapshot.getValue().toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        database.getReference().child("channels")
                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
                .child("channelProfile")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            Picasso.with(getContext())
                                    .load(snapshot.getValue().toString())
                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
                                    .into(videoImage1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        database.getReference().child("channels")
                .child("UCHq7ZxlzRRXimaBmk5QAxSQ")
                .child("channelProfile")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            Picasso.with(getContext())
                                    .load(snapshot.getValue().toString())
                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
                                    .into(videoImage2);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        database.getReference().child("channels")
                .child("UCHq7ZxlzRRXimaBmk5QAxSQ")
                .child("channelName")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            videoDescription2.setText(snapshot.getValue().toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


//        database.getReference().child("channels")
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("sgltU2n6YTU")
//                .child("title")
//                .setValue("पति पत्नी का धर्म | जानिये कैसे रहना चाहिए पति पत्नी को | 90% नही जानते लोग | श्री अनिरुद्धाचार्य जी");
//
//        database.getReference().child("channels")
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("G9bMQn7WIf0")
//                .child("title")
//                .setValue("");
//
//        database.getReference().child("channels")
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("sgltU2n6YTU")
//                .child("title")
//                .setValue("Shri aniruddhacharya Ji maharaj | SHRIMAD BHAGWAT KATHA BUTIBORI(NAGPUR) -DAY- 7 DATE 5-11-2019");
//
//        database.getReference().child("channels")
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("EskWox5H9tY")
//                .child("title")
//                .setValue("इस धनतेरस पर पति पत्नी अपनाएं ये नियम । गृहस्थ जीवन हो जाएगा मालामाल । श्री अनिरुद्धाचार्य जी महाराज");
//
//        database.getReference().child("channels")
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("sXVqnxBBJ8w")
//                .child("title")
//                .setValue("");
//
//        database.getReference().child("channels")
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("sgltU2n6YTU")
//                .child("title")
//                .setValue("सबके दिल पर छा जाने वाला ये भजन | नीले घोड़े वाले कि गोदी में सो जाऊं | श्री अनिरुद्धाचार्य जी महाराज");
//
//        database.getReference().child("channels")
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("aOVUzHB7U_k")
//                .child("title")
//                .setValue("पूजा के नियम । घर में पूजा कैसे करें । जानिए संपूर्ण पूजा विधि। श्री अनिरुद्धाचार्य जी महाराज");
//
//        database.getReference().child("channels")
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("6Z8rKK0E7bA")
//                .child("title")
//                .setValue("गर्भवती स्त्री के पेट में पल रहा बच्चा लड़का है या लड़की । यह कितने महीने में और कब पता करना चाहिए");
//
//        database.getReference().child("channels")
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("UtCyyr5naEE")
//                .child("title")
//                .setValue("आइये जानते हैं | मृत्यु के बाद क्या होता है | हमारे साथ | बता रहे है | श्री अनिरुद्धाचार्य जी महाराज");
//
//        database.getReference().child("channels")
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("k7qX2_5RbJI")
//                .child("title")
//                .setValue("पराई स्त्री से सम्बंध बनाने पर क्या दंड मिलता है | स्त्री और पुरुष दोनों समझिये ये बात");
//
//        database.getReference().child("channels")
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("UAeujvJqzgg")
//                .child("title")
//                .setValue("कलियुग | राजा परीक्षित ने कलियुग को कहाँ कहाँ स्थान दिया | कलियुग के विभाजन की कथा");
//
//




    }

    private void initingData() {
        videoImage1 = binding.videoImage1;
        videoDescription1 = binding.videoDescription1;
        videoImage2 = binding.videoImage2;
        videoDescription2 = binding.videoDescription2;
    }
}