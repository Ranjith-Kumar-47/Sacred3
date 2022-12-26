package com.example.playvideota.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.playvideota.R;
import com.example.playvideota.WebViewActivity;
import com.example.playvideota.YoutubeDashboard;
import com.example.playvideota.adapter.YoutuberAdapter;
import com.example.playvideota.api.MySingleton;
import com.example.playvideota.databinding.FragmentMannTvBinding;
import com.example.playvideota.databinding.FragmentTvBinding;
import com.example.playvideota.model.YoutuberModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;


public class MannTvFragment extends Fragment {

    FragmentMannTvBinding binding;
    ImageView videoImage1,videoImage2,videoImage3,videoImage4,videoImage5,videoImage6,videoImage7,videoImage8;
    TextView videoDescription1,videoDescription2,videoDescription3,videoDescription4,videoDescription5,videoDescription6,videoDescription7,videoDescription8;
    FirebaseDatabase database;
    CardView adminVideoCardView;
    ImageView adminVideo,adminVideoPlayButton;

    String url = "";
    String videoVisibility = "";

    String adminVideoId = "";



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
        adminVideoHandler();

        return  binding.getRoot();
    }

    private void adminVideoHandler() {
        adminVideoCardView.setVisibility(View.GONE);

        database.getReference().child("LiveVideo")
                .child("visibility")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            videoVisibility = snapshot.getValue().toString();
                            System.out.println("visiblity : "+videoVisibility);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        if(videoVisibility.equalsIgnoreCase("visible")){
            adminVideoCardView.setVisibility(View.VISIBLE);
            System.out.println("visiblity amit : "+videoVisibility);
            database.getReference().child("LiveVideo")
                    .child("videoId")
                    .addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                adminVideoId = snapshot.getValue().toString();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

            database.getReference().child("LiveVideo")
                    .child("videoImage")
                    .addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                Picasso.with(getContext())
                                        .load(snapshot.getValue().toString())
                                        .placeholder(R.drawable.ic_video_loading)
                                        .into(adminVideo);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
        }

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

        adminVideoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  =  new Intent(getContext(), WebViewActivity.class);
                intent.putExtra("id",adminVideoId);
                startActivity(intent);
            }
        });
    }

    private void settingData() {
//        database.getReference().child("channels")
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("channelName")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()){
//                            videoDescription1.setText(snapshot.getValue().toString());
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });



//        database.getReference().child("channels")
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("channelProfile")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()){
//                            Picasso.with(getContext())
//                                    .load(snapshot.getValue().toString())
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
//                                    .into(videoImage1);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

        database.getReference().child("tvSerial")
                .child("mahabharat")
                .child("title")
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

        database.getReference().child("tvSerial")
                .child("mahabharat")
                .child("image")
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


//        database.getReference().child("channels")
//                .child("UCHq7ZxlzRRXimaBmk5QAxSQ")
//                .child("channelProfile")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()){
//                            Picasso.with(getContext())
//                                    .load(snapshot.getValue().toString())
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
//                                    .into(videoImage2);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//        database.getReference().child("channels")
//                .child("UCHq7ZxlzRRXimaBmk5QAxSQ")
//                .child("channelName")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()){
//                            videoDescription2.setText(snapshot.getValue().toString());
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });


        database.getReference().child("tvSerial")
                .child("ramayanImage")
                .child("image")
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

        database.getReference().child("tvSerial")
                .child("ramayanImage")
                .child("title")
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
//                .child("UCfwa_zKl8-zC9rQDWIEixgg")
//                .child("channelProfile")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()){
//                            Picasso.with(getContext())
//                                    .load(snapshot.getValue().toString())
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
//                                    .into(videoImage3);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//        database.getReference().child("channels")
//                .child("UCfwa_zKl8-zC9rQDWIEixgg")
//                .child("channelName")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()){
//                            videoDescription3.setText(snapshot.getValue().toString());
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });


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

        database.getReference().child("tvSerial")
                .child("ShreeMahalaxmi")
                .child("image")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            Picasso.with(getContext())
                                    .load(snapshot.getValue().toString())
                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
                                    .into(videoImage3);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        database.getReference().child("tvSerial")
                .child("ShreeMahalaxmi")
                .child("title")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            videoDescription3.setText(snapshot.getValue().toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        database.getReference().child("tvSerial")
                .child("UttarRamayana")
                .child("image")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            Picasso.with(getContext())
                                    .load(snapshot.getValue().toString())
                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
                                    .into(videoImage4);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        database.getReference().child("tvSerial")
                .child("UttarRamayana")
                .child("title")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            videoDescription4.setText(snapshot.getValue().toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




    }

    private void initingData() {
        videoImage1 = binding.videoImage1;
        videoImage2 = binding.videoImage2;
        videoImage3 = binding.videoImage3;
        videoImage4 = binding.videoImage4;
        videoImage5 = binding.videoImage5;
        videoImage6 = binding.videoImage6;
        videoImage7 = binding.videoImage7;
        videoImage8 = binding.videoImage8;

        videoDescription1 = binding.videoDescription1;
        videoDescription2 = binding.videoDescription2;
        videoDescription3 = binding.videoDescription3;
        videoDescription4 = binding.videoDescription4;
        videoDescription5 = binding.videoDescription5;
        videoDescription6 = binding.videoDescription6;
        videoDescription7 = binding.videoDescription7;
        videoDescription8 = binding.videoDescription8;

        adminVideoCardView = binding.adminVideoCardView;
        adminVideo = binding.adminVideo;
        adminVideoPlayButton = binding.adminVideoPlayButton;


    }
}