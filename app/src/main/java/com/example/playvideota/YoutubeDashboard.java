package com.example.playvideota;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.playvideota.adapter.YoutubeDashBoardAdapterInterface;
import com.example.playvideota.adapter.YoutubeDashboardAdapter;
import com.example.playvideota.adapter.YoutuberAdapter;
import com.example.playvideota.api.MySingleton;
import com.example.playvideota.model.YoutubeDashboradModel;
import com.example.playvideota.model.YoutuberModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class YoutubeDashboard extends AppCompatActivity implements YoutubeDashBoardAdapterInterface {

    ArrayList<YoutubeDashboradModel> list = new ArrayList<>();
    ArrayList<YoutubeDashboradModel> filteredList = new ArrayList<>();
    ArrayList<YoutubeDashboradModel> normalList = new ArrayList<>();
    ArrayList<YoutubeDashboradModel> selectedList = new ArrayList<>();
    RecyclerView youtubeVideoRV;
    String youtubeAccountUrl;
    String youtuberId = "";
    String youtuberImage = "";
    String youtuberName = "";
    String youtuberBannerImage = "";
    TextView youtuberNameTV;

    ImageView videoImage1, videoImage2, videoImage3, profileUserImage1, profileUserImage2, profileUserImage3;
    TextView videoDescription1, videoDescription2, videoDescription3;

    GoogleSignInClient mGoogleSignInClient;

    FirebaseDatabase database;
    String id = "";
    String serialName = "";

    private String apiKey = "AIzaSyBnT_DTpgZKYoT6IYH5fNni7O9DUTN98dE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_dashboard);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        database = FirebaseDatabase.getInstance();

        serialName = getIntent().getStringExtra("serialName");

        videoImage1 = findViewById(R.id.videoImage1);
        videoImage2 = findViewById(R.id.videoImage2);
        videoImage3 = findViewById(R.id.videoImage3);
        profileUserImage1 = findViewById(R.id.profileUserImage1);
        profileUserImage2 = findViewById(R.id.profileUserImage2);
        profileUserImage3 = findViewById(R.id.profileUserImage3);

        videoDescription1 = findViewById(R.id.videoDescription1);
        videoDescription2 = findViewById(R.id.videoDescription2);
        videoDescription3 = findViewById(R.id.videoDescription3);


        gettingItem();
        loadProfileIamage();
        loadbannerImage();

        settingAdapter();
        loadYoutubeVideo();
        loadYoutuberName();
        clickHandler();
        logOutGoogleAccount();

//        BFVtoK_B07I
//        नानी बाई रो मायरो । नरसी का भात । गाड़ी में बिठाले रे बाबा जानो है नगर अंजार ।श्री अनिरुद्धाचार्य जी

//        sgltU2n6YTU
//        पति पत्नी का धर्म | जानिये कैसे रहना चाहिए पति पत्नी को | 90% नही जानते लोग | श्री अनिरुद्धाचार्य जी

//        G9bMQn7WIf0
//        Shri aniruddhacharya Ji maharaj | SHRIMAD BHAGWAT KATHA BUTIBORI(NAGPUR) -DAY- 7 DATE 5-11-2019"


//        EskWox5H9tY
//        इस धनतेरस पर पति पत्नी अपनाएं ये नियम । गृहस्थ जीवन हो जाएगा मालामाल । श्री अनिरुद्धाचार्य जी महाराज

//        sXVqnxBBJ8w
//        सबके दिल पर छा जाने वाला ये भजन | नीले घोड़े वाले कि गोदी में सो जाऊं | श्री अनिरुद्धाचार्य जी महाराज

//        aOVUzHB7U_k
//        पूजा के नियम । घर में पूजा कैसे करें । जानिए संपूर्ण पूजा विधि। श्री अनिरुद्धाचार्य जी महाराज

//        6Z8rKK0E7bA
//        गर्भवती स्त्री के पेट में पल रहा बच्चा लड़का है या लड़की । यह कितने महीने में और कब पता करना चाहिए

//        UtCyyr5naEE
//        आइये जानते हैं | मृत्यु के बाद क्या होता है | हमारे साथ | बता रहे है | श्री अनिरुद्धाचार्य जी महाराज

//        k7qX2_5RbJI
//        पराई स्त्री से सम्बंध बनाने पर क्या दंड मिलता है | स्त्री और पुरुष दोनों समझिये ये बात

//      UAeujvJqzgg
//      कलियुग | राजा परीक्षित ने कलियुग को कहाँ कहाँ स्थान दिया | कलियुग के विभाजन की कथा


        // sstj

//        imrHBZZWa-Q
//        ऐसी कौन सी तीन जगह है जहाँ स्त्री को कभी भी अकेले नहीं छोड़ना चाहिए || SHRI DEVKINANDAN THAKUR JI

//        CyI48iTONLE
//        नहीं रुकेगी लक्ष्मी जब तक घर में नहीं होंगे ये 4 काम | लक्ष्मी प्राप्ति के अचूक उपाय || धन लाभ

//        fUbs4P029OQ
//        Swapn Mein Saanp Ko Dekhane Ka Kya Arth Hai ? || SHRI DEVKINANDAN THAKUR JI MAHARAJ

//        U-b_UV3Ypjw
//        सुबह उठते ही, ये काम ज़रूर करो || Bengaluru Katha

//        ltU64YUflYY
//        Pati Patni Ke Beech Bar Bar Jhagda Ho To Avashya Karen Yha Upay || THAKUR JI MAHARAJ

//        p6jRAAmi6XA
//        अगर आप भी रख रहे हैं सोमवार का व्रत तो इन बातों का रखें ध्यान || SHRI DEVKINANDAN THAKUR JI MAHARAJ

//        P6zpDkhAXUo
//        नींबू मिर्च कैसे फैलाता है घर में कलेश एवं दरिद्रता भूलकर भी ना करें यह कार्य || THAKUR JI MAHARAJ

//        fxonsDCm_AI
//        महाराज जी ने दिखाई ओवैसी को उसकी औकात क्यों मोदी योगी से डर गए? || SHRI DEVKINNDAN THAKUR JI MAHARAJ

//        PxzJyX3maes
//        सपने में आने वाले मृत व्यक्ति कौन है पितृ या प्रेत ? || Pitrpaksh Bhagwat Katha

//        PgRV1GIy39c
//        Karj Mukti Ke Liye Ye Achook Upay Dega Adbhut Parinam || SHRI DEVKINANDAN THAKUR JI MAHARAJ
    }

    private void clickHandler() {
        videoImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(YoutubeDashboard.this, WebViewActivity.class);
                intent.putExtra("id","HnXkv_ozPQw");
                startActivity(intent);
            }
        });

        videoImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(YoutubeDashboard.this, WebViewActivity.class);
                intent.putExtra("id","jTwDqpQ-yQw");
                startActivity(intent);
            }
        });



        videoImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(YoutubeDashboard.this, WebViewActivity.class);
                intent.putExtra("id","dnloFi1GT9Q");
                startActivity(intent);
            }
        });

    }

    private void loadYoutuberName() {
        youtuberNameTV = findViewById(R.id.youtuberName);
//        id = getIntent().getStringExtra("id");
//        database.getReference().child("channels")
//                .child(id)
//                .child("channelName")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            youtuberNameTV.setText(snapshot.getValue().toString());
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

        database.getReference().child("tvSerial")
                .child(serialName)
                .child("title")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            youtuberNameTV.setText(snapshot.getValue().toString());
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }

    private void loadbannerImage() {
        ImageView youtuberImageView = findViewById(R.id.youtuberImageView);


//        id = getIntent().getStringExtra("id");
//
//
//        database.getReference().child("channels")
//                .child(id)
//                .child("channelBanner")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            Picasso.with(getApplicationContext())
//                                    .load(snapshot.getValue().toString())
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
//                                    .into(youtuberImageView);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

        database.getReference().child("tvSerial")
                .child(serialName)
                .child("image")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            Picasso.with(getApplicationContext())
                                    .load(snapshot.getValue().toString())
                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
                                    .into(youtuberImageView);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }

    private void logOutGoogleAccount() {
        ImageView logOutBtn = findViewById(R.id.logoutBtn);
        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mGoogleSignInClient.signOut();
                Toast.makeText(YoutubeDashboard.this, "LOG OUT", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(YoutubeDashboard.this, AuthActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadProfileIamage() {
        ImageView profileUserImage = findViewById(R.id.profileUserImage);
//        id = getIntent().getStringExtra("id");


//        database.getReference().child("channels")
//                .child(id)
//                .child("channelProfile")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            Picasso.with(getApplicationContext())
//                                    .load(snapshot.getValue().toString())
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
//                                    .into(profileUserImage);
//
//                            Picasso.with(getApplicationContext())
//                                    .load(snapshot.getValue().toString())
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
//                                    .into(profileUserImage1);
//
//                            Picasso.with(getApplicationContext())
//                                    .load(snapshot.getValue().toString())
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
//                                    .into(profileUserImage2);
//
//                            Picasso.with(getApplicationContext())
//                                    .load(snapshot.getValue().toString())
//                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
//                                    .into(profileUserImage3);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

        database.getReference().child("tvSerial")
                .child(serialName)
                .child("image")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            Picasso.with(getApplicationContext())
                                    .load(snapshot.getValue().toString())
                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
                                    .into(profileUserImage);

                            Picasso.with(getApplicationContext())
                                    .load(snapshot.getValue().toString())
                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
                                    .into(profileUserImage1);
                            Picasso.with(getApplicationContext())
                                    .load(snapshot.getValue().toString())
                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
                                    .into(profileUserImage2);
                            Picasso.with(getApplicationContext())
                                    .load(snapshot.getValue().toString())
                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
                                    .into(profileUserImage3);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


        database.getReference().child("tvSerial")
                .child(serialName)
                .child("image")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            Picasso.with(getApplicationContext())
                                    .load(snapshot.getValue().toString())
                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
                                    .into(videoImage1);

                            Picasso.with(getApplicationContext())
                                    .load(snapshot.getValue().toString())
                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
                                    .into(videoImage2);

                            Picasso.with(getApplicationContext())
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
                .child(serialName)
                .child("title")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            videoDescription1.setText(snapshot.getValue().toString()+" Episode 1");
                            videoDescription2.setText(snapshot.getValue().toString()+" Episode 2");
                            videoDescription3.setText(snapshot.getValue().toString()+" Episode 3");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




//        database.getReference().child("channels")
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("6Z8rKK0E7bA")
//                .child("image")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            Picasso.with(getApplicationContext())
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
//
//        database.getReference().child("channels")
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("6Z8rKK0E7bA")
//                .child("title")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            videoDescription1.setText(snapshot.getValue().toString());
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
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("BFVtoK_B07I")
//                .child("image")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            Picasso.with(getApplicationContext())
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
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("BFVtoK_B07I")
//                .child("title")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            videoDescription2.setText(snapshot.getValue().toString());
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
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("EskWox5H9tY")
//                .child("image")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            Picasso.with(getApplicationContext())
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
//                .child("UCDe0DwkMVFfSIoiYdQUPQmQ")
//                .child("videos")
//                .child("EskWox5H9tY")
//                .child("title")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if (snapshot.exists()) {
//                            videoDescription3.setText(snapshot.getValue().toString());
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
    }


    private void loadYoutubeVideo() {

        database.getReference().child("tvSerial")
                .child(serialName)
                .child("videos")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            System.out.println("snap k : "+snapshot.getKey());
                            System.out.println("snap v : "+snapshot.getValue());

                            for (DataSnapshot ds:snapshot.getChildren()) {
                                System.out.println("snap v : "+ds.getValue());
                                System.out.println("snap k : "+ds.getKey());
                                YoutubeDashboradModel youtubeDashboradModel = new YoutubeDashboradModel(
                                        ds.getValue().toString(),
                                        "Episode " +ds.getKey()
                                );

                                list.add(youtubeDashboradModel);
                            }

                            YoutubeDashboardAdapter adapter = new YoutubeDashboardAdapter(getApplicationContext(),list,serialName);
                            youtubeVideoRV.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
//
//        database.getReference().child("tvSerial")
//                .child("ShreeMahalaxmi")
//                .child("videos")
//                .addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()){
//                            System.out.println("snap k : "+snapshot.getKey());
//                            System.out.println("snap v : "+snapshot.getValue());
//
//                            for (DataSnapshot ds:snapshot.getChildren()) {
//                                System.out.println("snap v : "+ds.getValue());
//                                System.out.println("snap k : "+ds.getKey());
//                                YoutubeDashboradModel youtubeDashboradModel = new YoutubeDashboradModel(
//                                        ds.getValue().toString(),
//                                        "Episode " +ds.getKey()
//                                );
//
//                                list.add(youtubeDashboradModel);
//                            }
//
//                            YoutubeDashboardAdapter adapter = new YoutubeDashboardAdapter(getApplicationContext(),list);
//                            youtubeVideoRV.setAdapter(adapter);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//        database.getReference().child("tvSerial")
//                .child("UttarRamayana")
//                .child("videos")
//                .addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()){
//                            System.out.println("snap k : "+snapshot.getKey());
//                            System.out.println("snap v : "+snapshot.getValue());
//
//                            for (DataSnapshot ds:snapshot.getChildren()) {
//                                System.out.println("snap v : "+ds.getValue());
//                                System.out.println("snap k : "+ds.getKey());
//                                YoutubeDashboradModel youtubeDashboradModel = new YoutubeDashboradModel(
//                                        ds.getValue().toString(),
//                                        "Episode " +ds.getKey()
//                                );
//
//                                list.add(youtubeDashboradModel);
//                            }
//
//                            YoutubeDashboardAdapter adapter = new YoutubeDashboardAdapter(getApplicationContext(),list);
//                            youtubeVideoRV.setAdapter(adapter);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//        database.getReference().child("tvSerial")
//                .child("ramayanImage")
//                .child("videos")
//                .addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()){
//                            System.out.println("snap k : "+snapshot.getKey());
//                            System.out.println("snap v : "+snapshot.getValue());
//
//                            for (DataSnapshot ds:snapshot.getChildren()) {
//                                System.out.println("snap v : "+ds.getValue());
//                                System.out.println("snap k : "+ds.getKey());
//                                YoutubeDashboradModel youtubeDashboradModel = new YoutubeDashboradModel(
//                                        ds.getValue().toString(),
//                                        "Episode " +ds.getKey()
//                                );
//
//                                list.add(youtubeDashboradModel);
//                            }
//
//                            YoutubeDashboardAdapter adapter = new YoutubeDashboardAdapter(getApplicationContext(),list);
//                            youtubeVideoRV.setAdapter(adapter);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });


//        youtuberId = getIntent().getStringExtra("youtuberId");
//        youtubeAccountUrl = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=" + youtuberId + "&eventType=live&eventType=none&maxResults=250&chart=mostPopular&q=news&order=viewCount&type=video&videoDefinition=any&key=" + apiKey;
//
//        String liveYoutubeVideoUrl = "https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=" + youtuberId + "&eventType=live&maxResults=250&type=video&key=" + apiKey;
//
//        System.out.println("LOADING VIDEO");
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, youtubeAccountUrl, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONArray jsonArray = response.getJSONArray("items");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//                        JSONObject idJsonObject = jsonObject.getJSONObject("id");
//                        idJsonObject.getString("videoId");
//                        System.out.println("VIDEO ID : " + idJsonObject.getString("videoId"));
//
//                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
//                        snippetJsonObject.getString("title");
//                        snippetJsonObject.getString("channelId");
//                        snippetJsonObject.getString("description");
//                        snippetJsonObject.getString("liveBroadcastContent");
//
//                        System.out.println("VIDEO TITLE : " + snippetJsonObject.getString("title"));
//                        System.out.println("VIDEO DESCRIPTION : " + snippetJsonObject.getString("description"));
//
//                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
//                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");
//
//                        mediumJsonObject.getString("url");
//                        System.out.println("URL : " + mediumJsonObject.getString("url"));
//
//                        YoutubeDashboradModel youtubeDashboradModel = new YoutubeDashboradModel(
//                                mediumJsonObject.getString("url"),
//                                snippetJsonObject.getString("description"),
//                                snippetJsonObject.getString("title"),
//                                idJsonObject.getString("videoId"),
//                                snippetJsonObject.getString("liveBroadcastContent"),
//                                snippetJsonObject.getString("channelId"),
//                                youtuberImage,
//                                youtuberName
//                        );
//
//                        list.add(youtubeDashboradModel);
//
//                        System.out.println("live video : " + youtubeDashboradModel.getVideoLiveBroadcastContent());
//                    }
//
////                    // filter list contain only live videos
////                    for(int i=0 ;i<list.size(); i++){
////                        if(!list.get(i).getVideoLiveBroadcastContent().toLowerCase().equalsIgnoreCase("none")){
////                            filteredList.add(list.get(i));
////                        }
////                    }
//
//                    // normalList contain video other than live
//                    for (int i = 0; i < list.size(); i++) {
//                        if (list.get(i).getVideoLiveBroadcastContent().toLowerCase().equalsIgnoreCase("none")) {
//                            normalList.add(list.get(i));
//                        }
//                    }
//
////
////                    // firstly adding live video to the selected list
////                    for(int i=0 ;i<filteredList.size(); i++){
////                        selectedList.add(filteredList.get(i));
////                    }
//
//                    // secondly adding video other than live video
//                    for (int i = 0; i < normalList.size(); i++) {
//                        selectedList.add(normalList.get(i));
//                    }
//
//
////
//                    YoutubeDashboardAdapter youtubeDashboardAdapter1 = new YoutubeDashboardAdapter(getApplicationContext(), selectedList, YoutubeDashboard.this::itemClicked);
//                    youtubeVideoRV.setAdapter(youtubeDashboardAdapter1);
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
//        JsonObjectRequest jsonObjectRequestLive = new JsonObjectRequest(Request.Method.GET, liveYoutubeVideoUrl, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONArray jsonArray = response.getJSONArray("items");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//                        JSONObject idJsonObject = jsonObject.getJSONObject("id");
//                        idJsonObject.getString("videoId");
//                        System.out.println("VIDEO ID : " + idJsonObject.getString("videoId"));
//
//                        JSONObject snippetJsonObject = jsonObject.getJSONObject("snippet");
//                        snippetJsonObject.getString("title");
//                        snippetJsonObject.getString("channelId");
//                        snippetJsonObject.getString("description");
//                        snippetJsonObject.getString("liveBroadcastContent");
//
//                        System.out.println("VIDEO TITLE : " + snippetJsonObject.getString("title"));
//                        System.out.println("VIDEO DESCRIPTION : " + snippetJsonObject.getString("description"));
//
//                        JSONObject thumbnailJsonObject = snippetJsonObject.getJSONObject("thumbnails");
//                        JSONObject mediumJsonObject = thumbnailJsonObject.getJSONObject("high");
//
//                        mediumJsonObject.getString("url");
//                        System.out.println("URL : " + mediumJsonObject.getString("url"));
//
//                        YoutubeDashboradModel youtubeDashboradModel = new YoutubeDashboradModel(
//                                mediumJsonObject.getString("url"),
//                                snippetJsonObject.getString("description"),
//                                snippetJsonObject.getString("title"),
//                                idJsonObject.getString("videoId"),
//                                snippetJsonObject.getString("liveBroadcastContent"),
//                                snippetJsonObject.getString("channelId"),
//                                youtuberImage,
//                                youtuberName
//                        );
//
//                        list.add(youtubeDashboradModel);
//
//                        System.out.println("live video : " + youtubeDashboradModel.getVideoLiveBroadcastContent());
//                    }
//
//                    // filter list contain only live videos
//                    for (int i = 0; i < list.size(); i++) {
//                        if (list.get(i).getVideoLiveBroadcastContent().toLowerCase().equalsIgnoreCase("live")) {
//                            filteredList.add(list.get(i));
//                        }
//                    }
//
//                    // firstly adding live video to the selected list
//                    for (int i = 0; i < filteredList.size(); i++) {
//                        selectedList.add(filteredList.get(i));
//                    }
//
////
////                    // normalList contain video other than live
////                    for(int i=0 ;i<list.size(); i++){
////                        if(list.get(i).getVideoLiveBroadcastContent().toLowerCase().equalsIgnoreCase("none")){
////                            normalList.add(list.get(i));
////                        }
////                    }
//
//                    YoutubeDashboardAdapter youtubeDashboardAdapter20 = new YoutubeDashboardAdapter(getApplicationContext(), selectedList, YoutubeDashboard.this::itemClicked);
//                    youtubeVideoRV.setAdapter(youtubeDashboardAdapter20);
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
//        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequestLive);
//        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
//
//
//        YoutubeDashboardAdapter youtubeDashboardAdapter30 = new YoutubeDashboardAdapter(getApplicationContext(), selectedList, YoutubeDashboard.this::itemClicked);
//        youtubeVideoRV.setAdapter(youtubeDashboardAdapter30);
//
//        System.out.println("LOADED VIDEO");
    }

    private void settingAdapter() {
        youtubeVideoRV = findViewById(R.id.youtubeVideoRV);
        youtubeVideoRV.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(youtubeVideoRV.VERTICAL);
        youtubeVideoRV.setLayoutManager(gridLayoutManager);

        YoutubeDashboardAdapter youtubeDashboardAdapter3 = new YoutubeDashboardAdapter(getApplicationContext(), list, this);
        youtubeVideoRV.setAdapter(youtubeDashboardAdapter3);

    }

    private void gettingItem() {

//        list.add(new YoutubeDashboradModel(R.drawable.ic_profile_svgrepo_com,"this is my video"));
//        list.add(new YoutubeDashboradModel(R.drawable.ic_profile_svgrepo_com,"this is my video"));
//        list.add(new YoutubeDashboradModel(R.drawable.ic_profile_svgrepo_com,"this is my video"));
//        list.add(new YoutubeDashboradModel(R.drawable.ic_profile_svgrepo_com,"this is my video"));
//        list.add(new YoutubeDashboradModel(R.drawable.ic_profile_svgrepo_com,"this is my video"));
//        list.add(new YoutubeDashboradModel(R.drawable.ic_profile_svgrepo_com,"this is my video"));
//        list.add(new YoutubeDashboradModel(R.drawable.ic_profile_svgrepo_com,"this is my video"));
//       list.add(new YoutubeDashboradModel(R.drawable.ic_profile_svgrepo_com,"this is my video"));
    }


    @Override
    public void itemClicked(String userId, String videoID) {
        System.out.println("ITEM CLICKED");
        System.out.println("Video ID : " + videoID);
        System.out.println("LOADING VIDEO...");
        Intent intent = new Intent(YoutubeDashboard.this, VideoPlayer.class);
        intent.putExtra("userId", userId);
        intent.putExtra("videoId", videoID);
        startActivity(intent);


        Toast.makeText(this, "succcess", Toast.LENGTH_SHORT).show();
    }
}