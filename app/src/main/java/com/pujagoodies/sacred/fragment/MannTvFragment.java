package com.pujagoodies.sacred.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.pujagoodies.sacred.databinding.FragmentMannTvBinding;
import com.pujagoodies.sacred.FeedbackActivity;
//import com.example.playvideota.R;
import com.pujagoodies.sacred.R;
import com.pujagoodies.sacred.YoutubeDashboard;
import com.pujagoodies.sacred.adapter.AdminLiveVideoAdapter;
import com.pujagoodies.sacred.model.AdminLiveVideoModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MannTvFragment extends Fragment {

    FragmentMannTvBinding binding;
    ImageView videoImage1, videoImage2, videoImage3, videoImage4, videoImage5, videoImage6, videoImage7, videoImage8;
    TextView videoDescription1, videoDescription2, videoDescription3, videoDescription4, videoDescription5, videoDescription6, videoDescription7, videoDescription8;
    FirebaseDatabase database;
    HorizontalScrollView adminLiveVideoHorizontalSv,adminLiveVideoHorizontalSvMandir;
    TextView mandirVideoTv;


    String url = "";
    String videoVisibility = "";
    String videoVisibilityMandir = "";

    String adminVideoId = "";
    ArrayList<AdminLiveVideoModel> list = new ArrayList<>();
    ArrayList<AdminLiveVideoModel> mandirList= new ArrayList<>();
    RecyclerView adminLiveVideoRv;
    RecyclerView adminLiveVideoRvMandir;


    public MannTvFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
        FirebaseMessaging.getInstance().subscribeToTopic("notification");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMannTvBinding.inflate(inflater, container, false);

        initingData();
        settingData();





        settingAdapter();

        clickHandler();
        feedbackHandler();
        adminVideoHandler();
        adminMandirHandler();


        return binding.getRoot();
    }



    private void adminMandirHandler() {
        database.getReference().child("Mandir")
                .child("visibility")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            videoVisibilityMandir = snapshot.getValue().toString();
                            System.out.println("visiblity : " + videoVisibilityMandir);
                            if (videoVisibilityMandir.equalsIgnoreCase("visible")) {
                                adminLiveVideoHorizontalSvMandir.setVisibility(View.VISIBLE);
                                mandirVideoTv.setVisibility(View.VISIBLE);
                                database.getReference().child("Mandir")
                                        .child("videos")
                                        .addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                if (snapshot.exists()) {

                                                   try {
                                                       for (DataSnapshot ds : snapshot.getChildren()) {
                                                           System.out.println("ds k : " + ds.getKey());
                                                           System.out.println("ds v : " + ds.getValue());
                                                           System.out.println("v id : " + ds.getKey());
                                                           System.out.println("v imageUrl : " + ds.child(ds.getKey()).getValue().toString());
                                                           System.out.println("v title : " + ds.child("title").getValue().toString());
                                                           System.out.println("v description : " + ds.child("description").getValue().toString());

                                                           AdminLiveVideoModel adminLiveVideoModel = new AdminLiveVideoModel(
                                                                   ds.getKey(),
                                                                   ds.child(ds.getKey()).getValue().toString(),
                                                                   ds.child("title").getValue().toString(),
                                                                   ds.child("description").getValue().toString()

                                                           );
                                                           mandirList.add(adminLiveVideoModel);
                                                       }
                                                   }catch (Exception e){
                                                       Toast.makeText(getContext(), "processing", Toast.LENGTH_SHORT).show();

                                                   }

                                                    AdminLiveVideoAdapter adminLiveVideoAdapter = new AdminLiveVideoAdapter(getContext(), mandirList);
                                                    adminLiveVideoRvMandir.setAdapter(adminLiveVideoAdapter);

                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError error) {

                                            }
                                        });


                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

    }

    private void settingAdapter() {

//        youtubeVideoRV = findViewById(R.id.youtubeVideoRV);
//        youtubeVideoRV.setHasFixedSize(true);
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
//        gridLayoutManager.setOrientation(youtubeVideoRV.VERTICAL);
//        youtubeVideoRV.setLayoutManager(gridLayoutManager);
//
//        YoutubeDashboardAdapter youtubeDashboardAdapter3 = new YoutubeDashboardAdapter(getApplicationContext(), list, this);
//        youtubeVideoRV.setAdapter(youtubeDashboardAdapter3);

        adminLiveVideoRv = binding.adminLiveVideoRv;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        adminLiveVideoRv.setLayoutManager(linearLayoutManager);
        adminLiveVideoRv.setNestedScrollingEnabled(false);

//        adminLiveVideoRv.setHasFixedSize(true);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
//        gridLayoutManager.setOrientation(adminLiveVideoRv.HORIZONTAL);
//        adminLiveVideoRv.setLayoutManager(gridLayoutManager);
//        adminLiveVideoRv.setNestedScrollingEnabled(false);


        AdminLiveVideoAdapter adminLiveVideoAdapter = new AdminLiveVideoAdapter(getContext(), list);
        adminLiveVideoRv.setAdapter(adminLiveVideoAdapter);

        adminLiveVideoRvMandir = binding.adminLiveVideoRvMandir;
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        linearLayoutManager2.setSmoothScrollbarEnabled(true);
        adminLiveVideoRvMandir.setLayoutManager(linearLayoutManager2);
        adminLiveVideoRvMandir.setNestedScrollingEnabled(false);

        AdminLiveVideoAdapter adminLiveVideoAdapter2 = new AdminLiveVideoAdapter(getContext(), list);
        adminLiveVideoRvMandir.setAdapter(adminLiveVideoAdapter2);

    }

    private void feedbackHandler() {
        binding.feedBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FeedbackActivity.class);
                startActivity(intent);

            }
        });
    }

    private void adminVideoHandler() {


        database.getReference().child("LiveVideo")
                .child("visibility")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            videoVisibility = snapshot.getValue().toString();
                            System.out.println("visiblity : " + videoVisibility);
                            if (videoVisibility.equalsIgnoreCase("visible")) {
                                adminLiveVideoHorizontalSv.setVisibility(View.VISIBLE);
                                database.getReference().child("LiveVideo")
                                        .child("videos")
                                        .addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                if (snapshot.exists()) {

                                                    try {
                                                        for (DataSnapshot ds : snapshot.getChildren()) {
                                                            System.out.println("ds k : " + ds.getKey());
                                                            System.out.println("ds v : " + ds.getValue());
                                                            System.out.println("v id : " + ds.getKey());
                                                            System.out.println("v imageUrl : " + ds.child(ds.getKey()).getValue().toString());
                                                            System.out.println("v title : " + ds.child("title").getValue().toString());
                                                            System.out.println("v description : " + ds.child("description").getValue().toString());

                                                            AdminLiveVideoModel adminLiveVideoModel = new AdminLiveVideoModel(
                                                                    ds.getKey(),
                                                                    ds.child(ds.getKey()).getValue().toString(),
                                                                    ds.child("title").getValue().toString(),
                                                                    ds.child("description").getValue().toString()

                                                            );
                                                            list.add(adminLiveVideoModel);
                                                        }
                                                    }catch (Exception e){
                                                        Toast.makeText(getContext(), "Processing", Toast.LENGTH_SHORT).show();
                                                    }



                                                    AdminLiveVideoAdapter adminLiveVideoAdapter = new AdminLiveVideoAdapter(getContext(), list);
                                                    adminLiveVideoRv.setAdapter(adminLiveVideoAdapter);

                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError error) {

                                            }
                                        });


                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


    }

    private void clickHandler() {
        videoImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), YoutubeDashboard.class);
                intent.putExtra("serialName", "mahabharat");
                startActivity(intent);
            }
        });

        videoImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), YoutubeDashboard.class);
                intent.putExtra("serialName", "ramayanImage");
                startActivity(intent);
            }
        });

        videoImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), YoutubeDashboard.class);
                intent.putExtra("serialName", "ShreeMahalaxmi");
                startActivity(intent);
            }
        });

        videoImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), YoutubeDashboard.class);
                intent.putExtra("serialName", "UttarRamayana");
                startActivity(intent);
            }
        });

        videoImage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), YoutubeDashboard.class);
                intent.putExtra("serialName", "balKrishna");
                startActivity(intent);
            }
        });

        videoImage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), YoutubeDashboard.class);
                intent.putExtra("serialName", "saiBaba");
                startActivity(intent);
            }
        });

        videoImage7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), YoutubeDashboard.class);
                intent.putExtra("serialName", "shivPuran");
                startActivity(intent);
            }
        });

        videoImage8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), YoutubeDashboard.class);
                intent.putExtra("serialName", "vignahartaGanesh");
                startActivity(intent);
            }
        });

//        adminVideoCardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent  =  new Intent(getContext(), WebViewActivity.class);
//                intent.putExtra("id",adminVideoId);
//                startActivity(intent);
//            }
//        });
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
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com.xml)
//                                    .into(videoImage1);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

//        database.getReference().child("tvSerial")
//                .child("mahabharat")
//                .child("title")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            videoDescription1.setText("महाभारत");
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

//        Picasso.with(getContext())
//                .load("https://firebasestorage.googleapis.com/v0/b/playvideota.appspot.com/o/tvSerial%2Fmahabharat.jpg?alt=media&token=c8b9c95e-c766-4cc6-a79d-2019cc76eeb2")
//                .placeholder(R.drawable.ic_profile_svgrepo_com)
//                .into(videoImage1);
        videoImage1.setImageResource(R.drawable.tamahabharat);
        videoDescription1.setText("महाभारत");

//        database.getReference().child("tvSerial")
//                .child("mahabharat")
//                .child("image")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            Picasso.with(getContext())
//                                    .load("https://firebasestorage.googleapis.com/v0/b/playvideota.appspot.com/o/tvSerial%2Fmahabharat.jpg?alt=media&token=c8b9c95e-c766-4cc6-a79d-2019cc76eeb2")
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
//                                    .into(videoImage1);
//
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });


//        database.getReference().child("channels")
//                .child("UCHq7ZxlzRRXimaBmk5QAxSQ")
//                .child("channelProfile")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()){
//                            Picasso.with(getContext())
//                                    .load(snapshot.getValue().toString())
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com.xml)
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


//        Picasso.with(getContext())
//                .load("https://firebasestorage.googleapis.com/v0/b/playvideota.appspot.com/o/tvSerial%2Framayana.png?alt=media&token=93da567e-7aec-40ce-b33e-2ed2b2d97165")
//                .placeholder(R.drawable.ic_profile_svgrepo_com)
//                .into(videoImage2);
        videoImage2.setImageResource(R.drawable.taramayana);
        videoDescription2.setText("रामायण");

//        database.getReference().child("tvSerial")
//                .child("ramayanImage")
//                .child("image")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            Picasso.with(getContext())
//                                    .load("https://firebasestorage.googleapis.com/v0/b/playvideota.appspot.com/o/tvSerial%2Framayana.png?alt=media&token=93da567e-7aec-40ce-b33e-2ed2b2d97165")
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

//        database.getReference().child("tvSerial")
//                .child("ramayanImage")
//                .child("title")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            videoDescription2.setText("रामायण");
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });


//        database.getReference().child("channels")
//                .child("UCfwa_zKl8-zC9rQDWIEixgg")
//                .child("channelProfile")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()){
//                            Picasso.with(getContext())
//                                    .load(snapshot.getValue().toString())
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com.xml)
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

//        database.getReference().child("tvSerial")
//                .child("ShreeMahalaxmi")
//                .child("image")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            Picasso.with(getContext())
//                                    .load("https://firebasestorage.googleapis.com/v0/b/playvideota.appspot.com/o/tvSerial%2Ftalaxmi.jpg?alt=media&token=f0cf8b6b-7069-45f2-a539-f8257e7b36c1")
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
//        Picasso.with(getContext())
//                .load("https://firebasestorage.googleapis.com/v0/b/playvideota.appspot.com/o/tvSerial%2Ftalaxmi.jpg?alt=media&token=f0cf8b6b-7069-45f2-a539-f8257e7b36c1")
//                .placeholder(R.drawable.ic_profile_svgrepo_com)
//                .into(videoImage3);
        videoImage3.setImageResource(R.drawable.talaxmi);
        videoDescription3.setText("जय महालक्ष्मी");

//        database.getReference().child("tvSerial")
//                .child("ShreeMahalaxmi")
//                .child("title")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

//        Picasso.with(getContext())
//                .load("https://firebasestorage.googleapis.com/v0/b/playvideota.appspot.com/o/tvSerial%2FuttarRamayana.jpeg?alt=media&token=35313318-b204-450e-8b95-c359367da27d")
//                .placeholder(R.drawable.ic_profile_svgrepo_com)
//                .into(videoImage4);
        videoImage4.setImageResource(R.drawable.tauttarramayana);
        videoDescription4.setText("उत्तर रामायण");

//        database.getReference().child("tvSerial")
//                .child("UttarRamayana")
//                .child("image")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            Picasso.with(getContext())
//                                    .load(snapshot.getValue().toString())
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
//                                    .into(videoImage4);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

//        database.getReference().child("tvSerial")
//                .child("UttarRamayana")
//                .child("title")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            videoDescription4.setText(snapshot.getValue().toString());
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

//        Picasso.with(getContext())
//                .load("https://firebasestorage.googleapis.com/v0/b/playvideota.appspot.com/o/tvSerial%2Ftabalkrishna.jpeg?alt=media&token=2d33d59a-2650-4850-993e-86356f707db5")
//                .placeholder(R.drawable.ic_profile_svgrepo_com)
//                .into(videoImage5);
        videoImage5.setImageResource(R.drawable.tabalkrishna);
        videoDescription5.setText("बाल कृष्ण");

//        database.getReference().child("tvSerial")
//                .child("balKrishna")
//                .child("image")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            Picasso.with(getContext())
//                                    .load("https://firebasestorage.googleapis.com/v0/b/playvideota.appspot.com/o/tvSerial%2Ftaganesh.png?alt=media&token=b4c4018f-6502-4c06-8d47-9009b2d90bda")
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
//                                    .into(videoImage5);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

//        database.getReference().child("tvSerial")
//                .child("balKrishna")
//                .child("title")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            videoDescription5.setText("विघ्नहर्ता गणेश");
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

//        Picasso.with(getContext())
//                .load("https://firebasestorage.googleapis.com/v0/b/playvideota.appspot.com/o/tvSerial%2Ftasaibaba.png?alt=media&token=a68d56e2-f9c2-4e5c-9f12-f7c3b74c99cc")
//                .placeholder(R.drawable.ic_profile_svgrepo_com)
//                .into(videoImage6);
        videoImage6.setImageResource(R.drawable.tasaibaba);
        videoDescription6.setText("साईं बाबा");

//        database.getReference().child("tvSerial")
//                .child("saiBaba")
//                .child("image")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            Picasso.with(getContext())
//                                    .load("https://firebasestorage.googleapis.com/v0/b/playvideota.appspot.com/o/tvSerial%2Ftasaibaba.png?alt=media&token=a68d56e2-f9c2-4e5c-9f12-f7c3b74c99cc")
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
//                                    .into(videoImage6);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

//        database.getReference().child("tvSerial")
//                .child("saiBaba")
//                .child("title")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            videoDescription6.setText("साईं बाबा");
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

//        Picasso.with(getContext())
//                .load("https://firebasestorage.googleapis.com/v0/b/playvideota.appspot.com/o/tvSerial%2Ftashiva.png?alt=media&token=ede304b5-12e8-4ace-8c57-bd33e499d065")
//                .placeholder(R.drawable.ic_profile_svgrepo_com)
//                .into(videoImage7);
        videoImage7.setImageResource(R.drawable.tashiva);
        videoDescription7.setText("शिव महापुराण");

//        database.getReference().child("tvSerial")
//                .child("shivPuran")
//                .child("image")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            Picasso.with(getContext())
//                                    .load("https://firebasestorage.googleapis.com/v0/b/playvideota.appspot.com/o/tvSerial%2Ftashiva.png?alt=media&token=ede304b5-12e8-4ace-8c57-bd33e499d065")
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
//                                    .into(videoImage7);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

//        database.getReference().child("tvSerial")
//                .child("shivPuran")
//                .child("title")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            videoDescription7.setText("शिव महापुराण");
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

//        Picasso.with(getContext())
//                .load("https://firebasestorage.googleapis.com/v0/b/playvideota.appspot.com/o/tvSerial%2Ftaganesh.png?alt=media&token=b4c4018f-6502-4c06-8d47-9009b2d90bda")
//                .placeholder(R.drawable.ic_profile_svgrepo_com)
//                .into(videoImage8);
        videoImage8.setImageResource(R.drawable.taganesh);
        videoDescription8.setText("विघ्नहर्ता गणेश");

//        database.getReference().child("tvSerial")
//                .child("vignahartaGanesh")
//                .child("image")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            Picasso.with(getContext())
//                                    .load("https://firebasestorage.googleapis.com/v0/b/playvideota.appspot.com/o/tvSerial%2Ftaganesh.png?alt=media&token=b4c4018f-6502-4c06-8d47-9009b2d90bda")
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
//                                    .into(videoImage8);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

//        database.getReference().child("tvSerial")
//                .child("vignahartaGanesh")
//                .child("title")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            videoDescription8.setText("विघ्नहर्ता गणेश");
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });


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

        adminLiveVideoHorizontalSv = binding.adminLiveVideoHorizontalSv;
        adminLiveVideoHorizontalSvMandir = binding.adminLiveVideoHorizontalSvMandir;

        mandirVideoTv = binding.mandirVideoTv;

//        adminVideoCardView = binding.adminVideoCardView;
//        adminVideo = binding.adminVideo;
//        adminVideoPlayButton = binding.adminVideoPlayButton;


    }
}