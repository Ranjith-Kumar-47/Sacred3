package com.pujagoodies.sacred;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

//import com.example.playvideota.R;
import com.example.mandir.DummyActivity;
import com.example.mandir.MainActivityMandir;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.pujagoodies.sacred.R;
import com.pujagoodies.sacred.databinding.ActivityMainBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.pujagoodies.sacred.adapter.ViewPagerAdapter;
import com.pujagoodies.sacred.adapter.YoutuberAdapter;
import com.pujagoodies.sacred.model.UsersModel;
import com.pujagoodies.sacred.model.YoutuberModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import com.example.mandir.Test;

import java.util.ArrayList;

import model.GodImages;
import model.MainGods;

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
    private String adminEmail = "KK5n3nfT3ihnQxg7W4YgKdhJAsg2";
    private String adminEmail2 = "eW10eBgkhFWsUQtrh9AlUEQRRv33";

    private final String CHANNEL_ID = "simple_notification";
    private final int NOTIFICATION_ID = 1;

    ViewPager2 viewPager;
    TabLayout tabLayout;
    private String[] titles = {"TV", "PANCHANG", "RASHIPHAL", "GEETA SLOK", "SAHITYA"};
//    private String[] titles = {"TV", "PANCHANG", "RASHIPHAL", "GEETA SLOK"};

    private int[] tabIcons = {
            R.drawable.tv_icon_btn,
            R.drawable.ic_calender_day_love_svgrepo_com,
            R.drawable.astrology,
            R.drawable.gita_image,
            R.drawable.gita_slok_icon
    };
    ViewPagerAdapter viewPagerAdapter;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        adminButton = binding.adminButton;

        database.getReference().child("god")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        System.out.println("Key one : " + snapshot.getKey());
                        System.out.println("value one : " + snapshot.getValue());
                        for (DataSnapshot childSnapshot : snapshot.getChildren()
                        ) {
                            System.out.println("Key two : " + childSnapshot.getKey());
                            System.out.println("value two : " + childSnapshot.getValue());
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            String pn = account.getDisplayName();
            String pe = account.getEmail();
            String pi = String.valueOf(account.getPhotoUrl());


            UsersModel usersModel = new UsersModel(pi, pe, pn);

            database.getReference().child("users")
                    .child(account.getId())
                    .setValue(usersModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
//                            Toast.makeText(MainActivity.this, "User Authenticated ", Toast.LENGTH_SHORT).show();
                            System.out.println("user added to database");
                        }
                    });

//            Toast.makeText(this, pn, Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, pe, Toast.LENGTH_SHORT).show();
        }

        ImageView logoImage = binding.logoImage;

//        FirebaseDatabase.getInstance().getReference().child("god").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
////                    for (DataSnapshot data : snapshot.getChildren()) {
////                        String name = data.child("godName").getValue().toString();
////                        String mainName = data.child("godMainName").getValue().toString();
////                        String key = data.getKey();
////                        DataSnapshot dataSnapshot = snapshot.child("/" + key + "/GodImages");
////                        ArrayList<GodImages> godImages = new ArrayList<>();
////                        for (DataSnapshot data2 : dataSnapshot.getChildren()) {
////                            String poster = data2.child("image").getValue().toString();
////                            GodImages godImages1 = new GodImages(poster);
////                            godImages.add(godImages1);
////                        }
////                        MainGods mainGods = new MainGods(name, godImages, mainName);
////                        gods.add(mainGods);
////                    }
//
//
//                System.out.println("Key one : " + snapshot.getKey());
//                for (DataSnapshot childSnapshot : snapshot.getChildren()
//                ) {
//                    System.out.println("Key two : " + childSnapshot.getKey());
//                    String names = childSnapshot.child("" + childSnapshot.getKey()).getKey().toString();
//                    System.out.println("name : " + names);
//                    ArrayList<GodImages> godImages = new ArrayList<>();
//
////
//                    for (DataSnapshot childSnapshot2 : childSnapshot.getChildren()) {
////                                            System.out.println("Key three : " +childSnapshot2.getKey());
////                                            System.out.println("value three : " +childSnapshot2.getValue());
//
//                        String images = String.valueOf(childSnapshot2.getValue());
//                        String name = String.valueOf(childSnapshot2.getKey());
//                        System.out.println("image taamit : " + images);
//                        System.out.println("name taamit : " + name);
////
//                        GodImages godImage = new GodImages(images);
//                        godImages.add(godImage);
//
//                    }
//                    MainGods mainGods = new MainGods(names, godImages, names);
////                    gods.add(mainGods);
//                }
////                myAdapter.notifyDataSetChanged();
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


        logoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Test.class);
                startActivity(intent);

//                final ArrayList<MainGods> gods = new ArrayList<>();
//                database.getReference().child("god")
//                        .addValueEventListener(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                System.out.println("Key one : " + snapshot.getKey());
//                                ArrayList<GodImages> godImages = new ArrayList<>();
//                                for (DataSnapshot childSnapshot : snapshot.getChildren()
//                                ) {
//                                    System.out.println("Key two : " + childSnapshot.getKey());
//                                    System.out.println("value two : " + childSnapshot.getValue());
//
//                                    String images = String.valueOf(childSnapshot.getValue());
//                                    String name = String.valueOf(childSnapshot.getKey());
//                                    System.out.println("image taamit : " + images);
//                                    System.out.println("name taamit : " + name);
////
//                                    GodImages godImage = new GodImages(images);
//                                    godImages.add(godImage);
//                                    MainGods mainGods = new MainGods(name, godImages, name);
//                                    gods.add(mainGods);
//                                }
//
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError error) {
//
//                            }
//                        });

            }
        });


//        logoImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = null;
//                try {
//
//                    Intent launchIntent =
//                            getPackageManager().getLaunchIntentForPackage("com.example.mandir");
//                    if (launchIntent != null) {
//                        startActivity(launchIntent); //null pointer check in case package name was not found ClassNotFoundException
//
////                        Intent intent = new Intent();
////                        intent.setClassName(getApplicationContext().getPackageName(), "com.example.mandir.MainActivity");
////                        startActivity(intent);
//                        intent = new Intent(MainActivity.this,
//                                Class.forName("com.example.mandir.MainActivity"));
//                        startActivity(intent);
//
//                    }
//
////                    intent = new Intent(MainActivity.this,
////                            Class.forName("com.example.mandir.MainActivity"));
////                    startActivity(intent);
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//
////                Intent intent = new Intent();
////                intent.setClassName("com.example.mandir","MainActivity");
////                startActivity(intent);
//
//
////                try {
////                    Intent launchIntent =
////                            getPackageManager().getLaunchIntentForPackage("com.example.mandir");
////                    if (launchIntent != null) {
////                        startActivity(launchIntent); //null pointer check in case package name was not found ClassNotFoundException
////
////                        Intent intent = new Intent();
////                        intent.setClassName(getApplicationContext().getPackageName(), "com.example.mandir.MainActivity");
////                        startActivity(intent);
////
////                    }
////                } catch (Exception e) {
////                    e.printStackTrace();
////                }
//
//            }
//        });

//        logoImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                auth.signOut();
//                gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        Toast.makeText(MainActivity.this, "Log Out", Toast.LENGTH_SHORT).show();
//                        finish();
//                        Intent intent = new Intent(MainActivity.this, AuthActivity.class);
//                        startActivity(intent);
//                    }
//                });
//
//            }
//        });

//        System.out.println("admin Email " +auth.getCurrentUser().getEmail());


        toolbarButtonFunction();

        viewPager = binding.viewPager;
        tabLayout = binding.tabLayout;
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);


//        new TabLayoutMediator(tabLayout,viewPager,((tab, position) -> tab.setText(titles[position]) )).attach();
//        new TabLayoutMediator(tabLayout,viewPager,((tab, position) -> tab.setIcon(R.drawable.gita_slok_icon) )).attach();
        new TabLayoutMediator(tabLayout, viewPager, ((tab, position) -> tab.setIcon(tabIcons[position]))).attach();


        tabLayout.getTabAt(0).setText("टीवी").setIcon(R.drawable.tv_icon_btn).setTabLabelVisibility(TabLayout.TAB_LABEL_VISIBILITY_LABELED);
        tabLayout.getTabAt(1).setText("पंचांग").setIcon(R.drawable.ic_baseline_calendar_month_24).setTabLabelVisibility(TabLayout.TAB_LABEL_VISIBILITY_LABELED);
        tabLayout.getTabAt(2).setText("राशि").setIcon(R.drawable.astrology);
        tabLayout.getTabAt(3).setText("गीता श्लोक").setIcon(R.drawable.gita_image);
        tabLayout.getTabAt(4).setText("साहित्य").setIcon(R.drawable.gita_slok_icon);


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


//        logoImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                auth.signOut();
//                Intent intent = new Intent(MainActivity.this, AuthActivity.class);
//                startActivity(intent);
//            }
//        });

        if (auth.getCurrentUser() != null) {
            if ((adminEmail.equalsIgnoreCase(auth.getCurrentUser().getUid())) || (adminEmail2.equalsIgnoreCase(auth.getCurrentUser().getUid()))) {
                adminButton.setVisibility(View.VISIBLE);
            }
            System.out.println("admin Email " + auth.getCurrentUser().getEmail());
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
                intent.putExtra(Intent.EXTRA_SUBJECT, "अब आपके फोन में आपका मंदिर");
                intent.putExtra(Intent.EXTRA_TEXT, "Sacred App, अब आपके फोन में आपका मंदिर \n https://play.google.com/store/apps/details?id=com.pujagoodies.sacred");
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
                intent.putExtra(Intent.EXTRA_SUBJECT, "अब आपके फोन में आपका मंदिर");
//                intent.putExtra(Intent.EXTRA_TEXT, "Sacred App, अब आपके फोन में आपका मंदिर");
                intent.putExtra(Intent.EXTRA_TEXT, "Sacred App, अब आपके फोन में आपका मंदिर \n https://play.google.com/store/apps/details?id=com.pujagoodies.sacred");
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