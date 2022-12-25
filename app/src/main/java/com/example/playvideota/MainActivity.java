package com.example.playvideota;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.playvideota.adapter.ViewPagerAdapter;
import com.example.playvideota.adapter.YoutuberAdapter;
import com.example.playvideota.api.MySingleton;
import com.example.playvideota.databinding.ActivityMainBinding;
import com.example.playvideota.fragment.GeetaSlokFragment;
import com.example.playvideota.fragment.PanchangFragment;
import com.example.playvideota.fragment.RashiphalFragment;
import com.example.playvideota.fragment.TvFragment;
import com.example.playvideota.model.YoutuberModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.iammert.library.readablebottombar.ReadableBottomBar;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private String api = "AIzaSyBA5stcvWxiMf5PhX6HRQJJMhC2a6ovzxo";


    ActivityMainBinding binding;
    FirebaseDatabase database;
    FirebaseAuth auth;
    ImageView adminButton;


    RecyclerView youtuberRV;
    ArrayList<YoutuberModel> list;
    YoutuberAdapter youtuberAdapter;
    ArrayList<String> youtubeAcountList;
    String personName = "";
    String personPhoto = "";
    private String   adminEmail = "KK5n3nfT3ihnQxg7W4YgKdhJAsg2";

    private final String CHANNEL_ID = "simple_notification";
    private final int NOTIFICATION_ID = 1;

    ViewPager2 viewPager;
    TabLayout tabLayout;
    private String[] titles = {"TV", "PANCHANG","RASHIPHAL","GEETA SLOK"};

    private int[] tabIcons = {
            R.drawable.ic_apple_tv_svgrepo_com,
            R.drawable.ic_calender_day_love_svgrepo_com,
            R.drawable.rashiphal_removebg_preview,
            R.drawable.gita_slok_icon
    };
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        adminButton = binding.adminButton;

//        System.out.println("admin Email " +auth.getCurrentUser().getEmail());




        toolbarButtonFunction();

        viewPager = binding.viewPager;
        tabLayout = binding.tabLayout;
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);





//        new TabLayoutMediator(tabLayout,viewPager,((tab, position) -> tab.setText(titles[position]) )).attach();
//        new TabLayoutMediator(tabLayout,viewPager,((tab, position) -> tab.setIcon(R.drawable.gita_slok_icon) )).attach();
       new TabLayoutMediator(tabLayout,viewPager,((tab, position) -> tab.setIcon(tabIcons[position]) )).attach();


        tabLayout.getTabAt(0).setText("दूरदर्शन").setIcon(R.drawable.ic_apple_tv_svgrepo_com).setTabLabelVisibility(TabLayout.TAB_LABEL_VISIBILITY_LABELED);
        tabLayout.getTabAt(1).setText("पंचांग").setIcon(R.drawable.ic_baseline_calendar_month_24).setTabLabelVisibility(TabLayout.TAB_LABEL_VISIBILITY_LABELED);
        tabLayout.getTabAt(2).setText("राशि").setIcon(R.drawable.rashiphal_removebg_preview);
        tabLayout.getTabAt(3).setText("गीता श्लोक").setIcon(R.drawable.gita_slok_icon);

//        // setting the root fragment for home page
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.fragmentContainer, new TvFragment());
//        transaction.commit();
//
//
//        binding.bottomNavigation.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
//            @Override
//            public void onItemSelected(int i) {
//
//                // this is used to change one fragment to another.
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//                switch (i) {
//                    case 0:
//                        ExecutorService service = Executors.newSingleThreadExecutor();
//                        service.execute(new Runnable() {
//                            @Override
//                            public void run() {
//                                try {
//                                    transaction.replace(R.id.fragmentContainer, new TvFragment());
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        });
////                        transaction.replace(R.id.fragmentContainer, new ContestFragment());
//                        break;
//                    case 1:
//                        ExecutorService service1 = Executors.newSingleThreadExecutor();
//                        service1.execute(new Runnable() {
//                            @Override
//                            public void run() {
//                                try {
//                                    transaction.replace(R.id.fragmentContainer, new PanchangFragment());
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//
//                            }
//                        });
////                        transaction.replace(R.id.fragmentContainer, new ProblemFragment());
//                        break;
//                    case 2:
//                        ExecutorService service2 = Executors.newSingleThreadExecutor();
//                        service2.execute(new Runnable() {
//                            @Override
//                            public void run() {
//                                try {
//                                    transaction.replace(R.id.fragmentContainer, new RashiphalFragment());
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//
//                            }
//                        });
////                        transaction.replace(R.id.fragmentContainer, new ProfileFragment());
//                        break;
//
//
//                    case 3:
////                        ExecutorService service3 = Executors.newSingleThreadExecutor();
////                        service3.execute(new Runnable() {
////                            @Override
////                            public void run() {
////                                try {
////                                    transaction.replace(R.id.fragmentContainer, new GeetaSlokFragment());
////                                } catch (Exception e) {
////                                    e.printStackTrace();
////                                }
////
////                            }
////                        });
//                        transaction.replace(R.id.fragmentContainer, new GeetaSlokFragment());
//                        break;
//                }
//
//                transaction.commit();
//            }
//        });

        ImageView logoImage = binding.logoImage;

        if(auth.getCurrentUser() != null){
            if(adminEmail.equalsIgnoreCase(auth.getCurrentUser().getUid())){
                adminButton.setVisibility(View.VISIBLE);
            }
            System.out.println("admin Email " +auth.getCurrentUser().getEmail());
        }

    }



    private void createNotification() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "Vedic Astrology Dainik Rashifal";
            String desc = "Check out your today Rashiphal ";

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription(desc);

            NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);

        }

    }

    private void addNotification() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
        builder.setSmallIcon(R.drawable.logov2);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.logov2));
        builder.setContentTitle("Vedic Astrology Dainik Rashifal");
        builder.setContentText("Check out your today Rashiphal ");
        builder.setAutoCancel(true);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Add as notification
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());

    }


    private void toolbarButtonFunction() {
        ImageView adminButton = findViewById(R.id.adminButton);
        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdminDashboard.class);
                startActivity(intent);
            }
        });

        ImageView shareButton = (ImageView) findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "this is sharing app");
                intent.putExtra(Intent.EXTRA_TEXT, "your application link here");
                startActivity(Intent.createChooser(intent, "Share Via"));
            }
        });

    }

    @Override
    public void onBackPressed() {
//        moveTaskToBack(true);
        Dialog customDialog = new Dialog(this);
        customDialog.getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        customDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        customDialog.getWindow().getAttributes().windowAnimations
                = androidx.appcompat.R.style.Animation_AppCompat_Dialog;
        customDialog.setContentView(R.layout.exit_dialog_layout);

        ImageButton yesBtn = customDialog.findViewById(R.id.btnYes);
        ImageButton noBtn = customDialog.findViewById(R.id.btnNo);

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "this is sharing app");
                intent.putExtra(Intent.EXTRA_TEXT, "your application link here");
                startActivity(Intent.createChooser(intent, "Share Via"));
//                finishAffinity();
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
//                customDialog.cancel();
            }
        });

        customDialog.show();
    }


}