package com.pujagoodies.sacred;

import static java.lang.Thread.sleep;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.jinatonic.confetti.ConfettiManager;
import com.github.jinatonic.confetti.ConfettiSource;
import com.github.jinatonic.confetti.ConfettoGenerator;
import com.github.jinatonic.confetti.confetto.BitmapConfetto;
import com.github.jinatonic.confetti.confetto.Confetto;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pujagoodies.sacred.adapter.FlowersAdapter;
import com.pujagoodies.sacred.adapter.MyAdapter;
import com.pujagoodies.sacred.adapter.NotificationReceiver;
import com.pujagoodies.sacred.model.GodImages;
import com.pujagoodies.sacred.model.MainGods;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.hdodenhof.circleimageview.CircleImageView;
import pl.droidsonroids.gif.GifImageView;

public class MandirMainActivity extends AppCompatActivity implements ConfettoGenerator {


    //Views and Layouts on screen
    ImageView gImage, centerBell, thali, flowerThali, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11;
    ConstraintLayout constraintLayout, hand, parent, flowerCountLayout;
    SwipeListener swipeListener;
    MotionLayout motionLayout, motionLayoutSide1, motionLayoutSide2;
    ImageButton btnF, btnS, btnP, btnPremium, btn, dhoopBtn;
    TextView testing;

    RecyclerView recyclerView, recyclerViewFlowers;
    GifImageView gifImageView, imageView13;
    protected ViewGroup container;
    TabLayout navigation;
    EditText editText;
    Button confirm;

    ImageView smoke;
    boolean isSmokeOn = true;

    // for counter part
    long flower = 0;
    long shank = 0;
    long aarti = 0;
    long differentflower = 0;
    long dhoop = 0;


    com.google.android.material.bottomappbar.BottomAppBar bottomnav;

    FloatingActionButton bottomNavHome;
    //Other Variables for working
    int i = 0;
    int j = 0;
    int count, maxCount, btnCount = 0, count2 = 0, count3 = 0;
    MyAdapter myAdapter;
    private int size;
    private int velocitySlow, velocityNormal;
    private Bitmap bitmap;
    float xDown, yDown;
    int[] arrImages;
    String[] arrNames;
    FlowersAdapter flowersAdapter;
    BottomSheetBehavior bottomSheetBehavior, flowers;
    ArrayList<String> godNamess;
    ArrayList<Integer> position;

    FirebaseDatabase database;
    private String title = "प्रात:काल पूजा का समय";
    private String description = "अपने देवी - देवताओं के पूजा करे";


    View view;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mandir);


        database = FirebaseDatabase.getInstance();
        gImage = findViewById(R.id.test);
        constraintLayout = findViewById(R.id.viewForSwipe);
        motionLayout = findViewById(R.id.motionLayout);
        centerBell = findViewById(R.id.imageView5);
        btnF = findViewById(R.id.flowerBtn);
        btnS = findViewById(R.id.shankhBtn);
        btnP = findViewById(R.id.poojaBtn);
        btnPremium = findViewById(R.id.premuimBtn);
        container = findViewById(R.id.container);
        thali = findViewById(R.id.thali);
//        recyclerView = findViewById(R.id.navigation);
        gifImageView = findViewById(R.id.thaliFire);
        recyclerViewFlowers = findViewById(R.id.flowersSelection);
        motionLayoutSide2 = findViewById(R.id.motionLayoutSide2);
        motionLayoutSide1 = findViewById(R.id.motionLayoutSide1);
        hand = findViewById(R.id.handAnimation);
        flowerThali = findViewById(R.id.flowerThali);
        f1 = findViewById(R.id.f1);
        f2 = findViewById(R.id.f2);
        f3 = findViewById(R.id.f3);
        f4 = findViewById(R.id.f4);
        f5 = findViewById(R.id.f5);
        f6 = findViewById(R.id.f6);
        f7 = findViewById(R.id.f7);
        f8 = findViewById(R.id.f8);
        f9 = findViewById(R.id.f9);
        f10 = findViewById(R.id.f10);
        f11 = findViewById(R.id.f11);
        parent = findViewById(R.id.constraintLayout7);
        navigation = findViewById(R.id.navigation);
        btn = findViewById(R.id.temp);
        dhoopBtn = findViewById(R.id.dhoopBtn);
//       editText = findViewById(R.id.count);
//       confirm = findViewById(R.id.FlowerCountConfirm);
//       flowerCountLayout = findViewById(R.id.layoutSelection);


//        BottomAppBar bottomAppBar=findViewById(R.id.bottomnav) ;
//

        BottomAppBar bottomnav = findViewById(R.id.bottomnav);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(MandirMainActivity.this, WebViewActivity.class);
                        intent.putExtra("websiteUrl", "https://pujagoodies.com/");
//                        intent.putExtra("websiteUrl","https://www.google.com/");
                        startActivity(intent);
                        break;
                    case R.id.rashiphalmenu:
                        Intent intent1 = new Intent(MandirMainActivity.this, MainActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.buttonShare:
                        Intent intent2 = new Intent(Intent.ACTION_SEND);
                        intent2.setType("text/plain");
                        intent2.putExtra(Intent.EXTRA_SUBJECT, "अब आपके फोन में आपका मंदिर");
                        intent2.putExtra(Intent.EXTRA_TEXT, "Sacred App, अब आपका अपना मंदिर, आपके फोन में \n https://play.google.com/store/apps/details?id=com.pujagoodies.sacred");
                        startActivity(Intent.createChooser(intent2, "Share Via"));
                        break;
                    case R.id.buttonRate:
                        break;

                }
                return true;
            }
        });

//

        SharedPreferences sharedPreferences = getSharedPreferences("NOTIFICATION", MODE_PRIVATE);
        String firstTimeNotificaton = sharedPreferences.getString("NotificationFirstTimeInstall", "");
        if (firstTimeNotificaton.equals("Yes")) {

        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("NotificationFirstTimeInstall", "Yes");
            editor.apply();

            createNotificationChannel();
            setNotification();

        }


        // handling dhuup smoke
        smoke = findViewById(R.id.imageView11);
        imageView13 = findViewById(R.id.imageView13);
        ImageView sweetsThali = findViewById(R.id.sweetsThali);


//        sweetsThali.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ExecutorService service = Executors.newSingleThreadExecutor();
//                service.execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            MandirMainActivity.this.runOnUiThread(new Runnable() {
//                                public void run() {
//                                    Toast toast1 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "अपने प्रमुख देवी देवताओं का चयन करें" + "</b></font>"), Toast.LENGTH_LONG);
//                                    toast1.setGravity(Gravity.TOP | Gravity.RIGHT,100,0);
//                                    toast1.show();
//                                }
//                            });
//                            sleep(2000);
//
//                            MandirMainActivity.this.runOnUiThread(new Runnable() {
//                                public void run() {
//
//                                    Toast toast2 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "भगवान को फूल चढ़ाएं" + "</b></font>"), Toast.LENGTH_LONG);
//                                    toast2.setGravity(Gravity.CENTER | Gravity.LEFT,135,-53);
//                                    toast2.show();
//
//                                }
//                            });
//                            sleep(2000);
//
//                            MandirMainActivity.this.runOnUiThread(new Runnable() {
//                                public void run() {
//                                    Toast toast3 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "शंख बजाएं" + "</b></font>"), Toast.LENGTH_LONG);
//                                    toast3.setGravity(Gravity.CENTER | Gravity.LEFT,135,70);
//                                    toast3.show();
//
//                                }
//                            });
//                            sleep(2000);
//
//                            MandirMainActivity.this.runOnUiThread(new Runnable() {
//                                public void run() {
//                                    Toast toast3 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "धूपबत्ती जलाएं" + "</b></font>"), Toast.LENGTH_LONG);
//                                    toast3.setGravity(Gravity.CENTER | Gravity.LEFT,135,190);
//                                    toast3.show();
//
//                                }
//                            });
//                            sleep(2000);
//
//                            MandirMainActivity.this.runOnUiThread(new Runnable() {
//                                public void run() {
//                                    Toast toast4 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "आरती करें" + "</b></font>"), Toast.LENGTH_LONG);
//                                    toast4.setGravity(Gravity.CENTER | Gravity.RIGHT,135,-50);
//                                    toast4.show();
//                                }
//                            });
//                            sleep(2000);
//
//                            MandirMainActivity.this.runOnUiThread(new Runnable() {
//                                public void run() {
//                                    Toast toast5 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "भगवान के लिए फूल चुनें" + "</b></font>"), Toast.LENGTH_LONG);
//                                    toast5.setGravity(Gravity.CENTER | Gravity.RIGHT,135,70);
//                                    toast5.show();
//
//                                }
//                            });
//                            sleep(3000);
//
//
//                            MandirMainActivity.this.runOnUiThread(new Runnable() {
//                                public void run() {
//                                    LayoutInflater inflater = getLayoutInflater();
//                                    View layout = inflater.inflate(R.layout.caption_toast,findViewById(R.id.caption_toast_container));
//                                    Toast toast6 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "Select God" + "</b></font>"), Toast.LENGTH_LONG);
//                                    toast6.setGravity( Gravity.TOP | Gravity.CENTER,0,0);
//                                    toast6.setView(layout);
//                                    toast6.show();
//
//
//                                }
//                            });
//                            sleep(3000);
//
//                            MandirMainActivity.this.runOnUiThread(new Runnable() {
//                                public void run() {
//                                    LayoutInflater inflater = getLayoutInflater();
//                                    View layout = inflater.inflate(R.layout.caption_toast,findViewById(R.id.caption_toast_container));
//                                    Toast toast7 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "Select God" + "</b></font>"), Toast.LENGTH_LONG);
//                                    toast7.setGravity(Gravity.CENTER ,0,40);
//                                    toast7.setView(layout);
//                                    toast7.show();
//
//
//                                }
//                            });
//                            sleep(3000);
//
//                            MandirMainActivity.this.runOnUiThread(new Runnable() {
//                                public void run() {
//
//                                    LayoutInflater inflater2 = getLayoutInflater();
//                                    View layout2 = inflater2.inflate(R.layout.caption_toast_vertical,findViewById(R.id.caption_toast_container));
//                                    Toast toast8 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "Select God" + "</b></font>"), Toast.LENGTH_LONG);
//                                    toast8.setGravity( Gravity.CENTER,60,40);
//                                    toast8.setView(layout2);
//                                    toast8.show();
//
//                                }
//                            });
//
//                            sleep(2000);
//                            MandirMainActivity.this.runOnUiThread(new Runnable() {
//                                public void run() {
//                                    Toast toast9 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "पंचांग,राशिफल इत्यादि देखें" + "</b></font>"), Toast.LENGTH_LONG);
//                                    toast9.setGravity(Gravity.CENTER | Gravity.BOTTOM,22,130);
//                                    toast9.show();
//
//                                }
//                            });
//
//
//
//                        }catch (Exception e){
//                            e.printStackTrace();
//                        }
//                    }
//                });
//            }
//        });


        dhoopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSmokeOn) {
                    imageView13.setVisibility(View.VISIBLE);
                    dhoopBtn.setImageResource(R.drawable.burn);
                    isSmokeOn = false;

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            imageView13.setVisibility(View.GONE);
                            dhoopBtn.setImageResource(R.drawable.unburn);
                            isSmokeOn = true;
                        }
                    }, 3600000);
                }

                database.getReference().child("counter").child("dhoopBtn").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            dhoop = (long) snapshot.getValue();
                            database.getReference().child("counter").child("dhoopBtn").setValue(dhoop += 1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });


        bottomNavHome = findViewById(R.id.bottomNavHome);
        bottomNavHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MandirMainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MandirMainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("PREFERENCES", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("FirstTimeInstall", "Edit");
                editor.apply();
                startActivity(new Intent(MandirMainActivity.this, MandirDummyActivity.class));
            }
        });
        position = (ArrayList<Integer>) PrefConfig.readListFromPref(getApplicationContext());
        if (position == null) {
            position = getIntent().getIntegerArrayListExtra("pos");
        }

        //MAIN MANDIR FUNCTIONING
        //God Images working
        swipeListener = new SwipeListener(constraintLayout);

        //Adapter initialization

        godNamess = new ArrayList<>();


        //sound Players
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sound);
        final MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.shankh);
        final MediaPlayer mediaPlayer3 = MediaPlayer.create(this, R.raw.temple);

        //Getting Data From Database
        final ArrayList<MainGods> gods = new ArrayList<>();
        FirebaseDatabase.getInstance().getReference().child("/pics").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()) {
                    String name = "";

                    if (data.child("godName").getValue() == null) {
                        name = "";
                    } else {
                        name = data.child("godName").getValue().toString();
                        godNamess.add(name);
                    }

                    String key = data.getKey();
                    DataSnapshot dataSnapshot = snapshot.child("/" + key + "/godImages");
                    ArrayList<GodImages> godImages = new ArrayList<>();
                    for (DataSnapshot data2 : dataSnapshot.getChildren()) {
                        String poster = data2.child("image").getValue().toString();
                        GodImages godImages1 = new GodImages(poster);
                        godImages.add(godImages1);
                    }
                    MainGods mainGods = new MainGods(name, godImages, false);
                    gods.add(mainGods);
                }
                swipeListener.getData(gods);
                mediaPlayer.start();

                // for first time caption
                SharedPreferences sharedPreferences = getSharedPreferences("CAPTIONS", MODE_PRIVATE);
                String firstTime = sharedPreferences.getString("CaptionFirstTimeInstall", "");
                if (firstTime.equals("Yes")) {

                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("CaptionFirstTimeInstall", "Yes");
                    editor.apply();

                    ExecutorService service = Executors.newSingleThreadExecutor();
                    service.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                MandirMainActivity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        Toast toast1 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "अपने प्रमुख देवी देवताओं का चयन करें" + "</b></font>"), Toast.LENGTH_LONG);
                                        toast1.setGravity(Gravity.TOP | Gravity.RIGHT, 100, 0);
                                        toast1.show();
                                    }
                                });
                                sleep(2000);

                                MandirMainActivity.this.runOnUiThread(new Runnable() {
                                    public void run() {

                                        Toast toast2 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "भगवान को फूल चढ़ाएं" + "</b></font>"), Toast.LENGTH_LONG);
                                        toast2.setGravity(Gravity.CENTER | Gravity.LEFT, 135, -53);
                                        toast2.show();

                                    }
                                });
                                sleep(2000);

                                MandirMainActivity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        Toast toast3 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "शंख बजाएं" + "</b></font>"), Toast.LENGTH_LONG);
                                        toast3.setGravity(Gravity.CENTER | Gravity.LEFT, 135, 70);
                                        toast3.show();

                                    }
                                });
                                sleep(2000);

                                MandirMainActivity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        Toast toast3 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "धूपबत्ती जलाएं" + "</b></font>"), Toast.LENGTH_LONG);
                                        toast3.setGravity(Gravity.CENTER | Gravity.LEFT, 135, 190);
                                        toast3.show();

                                    }
                                });
                                sleep(2000);

                                MandirMainActivity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        Toast toast4 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "आरती करें" + "</b></font>"), Toast.LENGTH_LONG);
                                        toast4.setGravity(Gravity.CENTER | Gravity.RIGHT, 135, -50);
                                        toast4.show();
                                    }
                                });
                                sleep(2000);

                                MandirMainActivity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        Toast toast5 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "भगवान के लिए फूल चुनें" + "</b></font>"), Toast.LENGTH_LONG);
                                        toast5.setGravity(Gravity.CENTER | Gravity.RIGHT, 135, 70);
                                        toast5.show();

                                    }
                                });
                                sleep(3000);


                                MandirMainActivity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        LayoutInflater inflater = getLayoutInflater();
                                        View layout = inflater.inflate(R.layout.caption_toast, findViewById(R.id.caption_toast_container));
                                        Toast toast6 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "Select God" + "</b></font>"), Toast.LENGTH_LONG);
                                        toast6.setGravity(Gravity.TOP | Gravity.CENTER, 0, 0);
                                        toast6.setView(layout);
                                        toast6.show();


                                    }
                                });
                                sleep(3000);

                                MandirMainActivity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        LayoutInflater inflater = getLayoutInflater();
                                        View layout = inflater.inflate(R.layout.caption_toast, findViewById(R.id.caption_toast_container));
                                        Toast toast7 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "Select God" + "</b></font>"), Toast.LENGTH_LONG);
                                        toast7.setGravity(Gravity.CENTER, 0, 40);
                                        toast7.setView(layout);
                                        toast7.show();


                                    }
                                });
                                sleep(3000);

                                MandirMainActivity.this.runOnUiThread(new Runnable() {
                                    public void run() {

                                        LayoutInflater inflater2 = getLayoutInflater();
                                        View layout2 = inflater2.inflate(R.layout.caption_toast_vertical, findViewById(R.id.caption_toast_container));
                                        Toast toast8 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "Select God" + "</b></font>"), Toast.LENGTH_LONG);
                                        toast8.setGravity(Gravity.CENTER, 60, 40);
                                        toast8.setView(layout2);
                                        toast8.show();

                                    }
                                });

                                sleep(2000);
                                MandirMainActivity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        Toast toast9 = Toast.makeText(getApplicationContext(), Html.fromHtml("<font color='#E84511' ><b>" + "पंचांग,राशिफल इत्यादि देखें" + "</b></font>"), Toast.LENGTH_LONG);
                                        toast9.setGravity(Gravity.CENTER | Gravity.BOTTOM, 22, 130);
                                        toast9.show();

                                    }
                                });


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Animation for hand
        hand.setY(1000f);
        hand.animate().translationYBy(-1050f).setDuration(2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gifImageView.setVisibility(View.VISIBLE);
                hand.animate().translationYBy(1100f).setDuration(2000);
            }
        }, 2000);


        //bells on click animations
        count = 0;
        centerBell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                maxCount = 3;

            }
        });
        MotionLayout.TransitionListener transitionListener = new MotionLayout.TransitionListener() {

            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {
                mediaPlayer.start();
            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {

            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {
                if (count <= 5) {
                    motionLayout.transitionToStart();
                }
                count += 1;
                if (count == 7) {
                    count = 0;
                }
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {


            }
        };
        MotionLayout.TransitionListener transitionListener2 = new MotionLayout.TransitionListener() {

            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {
                mediaPlayer.start();
            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {

            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {
                if (count2 <= 5) {
                    motionLayout.transitionToStart();
                }
                count2 += 1;
                if (count2 == 7) {
                    count2 = 0;
                }
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {


            }
        };
        MotionLayout.TransitionListener transitionListener3 = new MotionLayout.TransitionListener() {

            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {
                mediaPlayer.start();
            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {

            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {
                if (count3 <= 5) {
                    motionLayout.transitionToStart();
                }
                count3 += 1;
                if (count3 == 7) {
                    count3 = 0;
                }
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {


            }
        };
        motionLayout.setTransitionListener(transitionListener);
        motionLayoutSide2.setTransitionListener(transitionListener2);
        motionLayoutSide1.setTransitionListener(transitionListener3);

        //drag and move Thali
        thali.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        xDown = motionEvent.getX();
                        yDown = motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float movedX, movedY;
                        movedX = motionEvent.getX();
                        movedY = motionEvent.getY();
                        float distanceX = movedX - xDown;
                        float distanceY = movedY - yDown;
                        thali.setX(thali.getX() + distanceX);
                        thali.setY(thali.getY() + distanceY);
                        gifImageView.setX(gifImageView.getX() + distanceX);
                        gifImageView.setY(gifImageView.getY() + distanceY);

                        break;
                }
                return true;
            }
        });

        //ALL BUTTONS WORKING

        //flowers dropping

        //Flower Selection Working
        arrImages = new int[]{R.drawable.f4, R.drawable.rose, R.drawable.f5, R.drawable.f6, R.drawable.f7, R.drawable.f8};
        arrNames = new String[]{"Parijat", "Rose", "neelkamal", "mogra", "lotus", "kovidar"};
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewFlowers.setLayoutManager(layoutManager);
        flowersAdapter = new FlowersAdapter(arrImages, arrNames);
        flowersAdapter.setContext(getApplicationContext());
        flowersAdapter.setContainer(container);
        flowersAdapter.setRes(getResources());
        recyclerViewFlowers.setAdapter(flowersAdapter);
        recyclerViewFlowers.setHasFixedSize(true);

        //flower dropping button
        btnPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.getReference().child("counter").child("differentFlowerBtn").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            differentflower = (long) snapshot.getValue();
                            database.getReference().child("counter").child("differentFlowerBtn").setValue(differentflower += 1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                flowersAdapter.setImageAssets(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, parent);
                bottomSheetBehavior = BottomSheetBehavior.from(recyclerViewFlowers);

                if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

//                    drawable.setTint(getResources().getColor(R.color.gold_med));
                } else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

//                    drawable.setTint(getResources().getColor(R.color.gold_light));
                }


            }
        });

        btnF.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final Resources res = getResources();
                size = 156;
                velocitySlow = 50;
                velocityNormal = 100;

                bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res, R.drawable.p), size, size, false);
                ConfettiManager confettiManager = getConfettiManager().setNumInitialCount(0).setEmissionDuration(3000);

                confettiManager.setEmissionRate(14).animate();
//                alertDialog.dismiss();
                f1.setVisibility(View.INVISIBLE);
                f2.setVisibility(View.INVISIBLE);
                f3.setVisibility(View.INVISIBLE);
                f4.setVisibility(View.INVISIBLE);
                f5.setVisibility(View.INVISIBLE);
                f6.setVisibility(View.INVISIBLE);
                f7.setVisibility(View.INVISIBLE);
                f8.setVisibility(View.INVISIBLE);
                f9.setVisibility(View.INVISIBLE);
                f10.setVisibility(View.INVISIBLE);
                f11.setVisibility(View.INVISIBLE);
                f1.setImageDrawable(getDrawable(R.drawable.p));
                f2.setImageDrawable(getDrawable(R.drawable.p));
                f3.setImageDrawable(getDrawable(R.drawable.p));
                f4.setImageDrawable(getDrawable(R.drawable.p));
                f5.setImageDrawable(getDrawable(R.drawable.p));
                f6.setImageDrawable(getDrawable(R.drawable.p));
                f7.setImageDrawable(getDrawable(R.drawable.p));
                f8.setImageDrawable(getDrawable(R.drawable.p));
                f9.setImageDrawable(getDrawable(R.drawable.p));
                f10.setImageDrawable(getDrawable(R.drawable.p));
                f11.setImageDrawable(getDrawable(R.drawable.p));
                Transition transition = new Fade();
                transition.setDuration(20000);
                transition.addTarget(R.id.f1);
                transition.addTarget(R.id.f2);
                transition.addTarget(R.id.f3);
                transition.addTarget(R.id.f4);
                transition.addTarget(R.id.f5);
                transition.addTarget(R.id.f6);
                transition.addTarget(R.id.f7);
                transition.addTarget(R.id.f8);
                transition.addTarget(R.id.f9);
                transition.addTarget(R.id.f10);
                transition.addTarget(R.id.f11);
                TransitionManager.beginDelayedTransition(parent, transition);
                f1.setVisibility(View.VISIBLE);
                f2.setVisibility(View.VISIBLE);
                f3.setVisibility(View.VISIBLE);
                f4.setVisibility(View.VISIBLE);
                f5.setVisibility(View.VISIBLE);
                f6.setVisibility(View.VISIBLE);
                f7.setVisibility(View.VISIBLE);
                f8.setVisibility(View.VISIBLE);
                f9.setVisibility(View.VISIBLE);
                f10.setVisibility(View.VISIBLE);
                f11.setVisibility(View.VISIBLE);


                database.getReference().child("counter").child("flowerBtn").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            flower = (long) snapshot.getValue();
                            database.getReference().child("counter").child("flowerBtn").setValue(flower += 1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


// code for alert flower count

//                final AlertDialog.Builder alert = new AlertDialog.Builder(MandirMainActivity.this);
//                View view1 = getLayoutInflater().inflate(R.layout.flower_counts, null);
//                EditText editText = view1.findViewById(R.id.count);
//                Button button = view1.findViewById(R.id.confirm);
//                alert.setView(view1);
//                final AlertDialog alertDialog = alert.create();
//                alertDialog.show();
//                button.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        String ct = editText.getText().toString();
//                        int countFlower = Integer.parseInt(ct);
//                        if (countFlower > 100) {
//                            Toast.makeText(MandirMainActivity.this, "Too Many Flowers,pls enter again", Toast.LENGTH_LONG);
//                        } else {
//                            confettiManager.setEmissionRate(countFlower).animate();
//                            alertDialog.dismiss();
//                            f1.setVisibility(View.INVISIBLE);
//                            f2.setVisibility(View.INVISIBLE);
//                            f3.setVisibility(View.INVISIBLE);
//                            f4.setVisibility(View.INVISIBLE);
//                            f5.setVisibility(View.INVISIBLE);
//                            f6.setVisibility(View.INVISIBLE);
//                            f7.setVisibility(View.INVISIBLE);
//                            f8.setVisibility(View.INVISIBLE);
//                            f9.setVisibility(View.INVISIBLE);
//                            f10.setVisibility(View.INVISIBLE);
//                            f11.setVisibility(View.INVISIBLE);
//                            f1.setImageDrawable(getDrawable(R.drawable.p));
//                            f2.setImageDrawable(getDrawable(R.drawable.p));
//                            f3.setImageDrawable(getDrawable(R.drawable.p));
//                            f4.setImageDrawable(getDrawable(R.drawable.p));
//                            f5.setImageDrawable(getDrawable(R.drawable.p));
//                            f6.setImageDrawable(getDrawable(R.drawable.p));
//                            f7.setImageDrawable(getDrawable(R.drawable.p));
//                            f8.setImageDrawable(getDrawable(R.drawable.p));
//                            f9.setImageDrawable(getDrawable(R.drawable.p));
//                            f10.setImageDrawable(getDrawable(R.drawable.p));
//                            f11.setImageDrawable(getDrawable(R.drawable.p));
//                            Transition transition = new Fade();
//                            transition.setDuration(20000);
//                            transition.addTarget(R.id.f1);
//                            transition.addTarget(R.id.f2);
//                            transition.addTarget(R.id.f3);
//                            transition.addTarget(R.id.f4);
//                            transition.addTarget(R.id.f5);
//                            transition.addTarget(R.id.f6);
//                            transition.addTarget(R.id.f7);
//                            transition.addTarget(R.id.f8);
//                            transition.addTarget(R.id.f9);
//                            transition.addTarget(R.id.f10);
//                            transition.addTarget(R.id.f11);
//                            TransitionManager.beginDelayedTransition(parent, transition);
//                            f1.setVisibility(View.VISIBLE);
//                            f2.setVisibility(View.VISIBLE);
//                            f3.setVisibility(View.VISIBLE);
//                            f4.setVisibility(View.VISIBLE);
//                            f5.setVisibility(View.VISIBLE);
//                            f6.setVisibility(View.VISIBLE);
//                            f7.setVisibility(View.VISIBLE);
//                            f8.setVisibility(View.VISIBLE);
//                            f9.setVisibility(View.VISIBLE);
//                            f10.setVisibility(View.VISIBLE);
//                            f11.setVisibility(View.VISIBLE);
//
//                        }
//
//
//                    }
//                });


            }
        });

        //Shankh sound Button
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer2.start();

                database.getReference().child("counter").child("shankBtn").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            shank = (long) snapshot.getValue();
                            database.getReference().child("counter").child("shankBtn").setValue(shank += 1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        //pooja button
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = new MyAnimation(thali, 200);
                anim.setDuration(5000);
                anim.setRepeatCount(3);
                thali.startAnimation(anim);
                gifImageView.startAnimation(anim);
                mediaPlayer2.start();
                final Resources res = getResources();
                size = 156;
                velocitySlow = 50;
                velocityNormal = 100;
                mediaPlayer3.start();
                bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(res, R.drawable.p), size, size, false);
                ConfettiManager confettiManager = getConfettiManager().setNumInitialCount(0).setEmissionDuration(3000).setEmissionRate(20).animate();
                motionLayout.transitionToState(R.id.end);
                motionLayoutSide1.transitionToState(R.id.end);
                motionLayoutSide2.transitionToState(R.id.end);
                f1.setVisibility(View.INVISIBLE);
                f2.setVisibility(View.INVISIBLE);
                f3.setVisibility(View.INVISIBLE);
                f4.setVisibility(View.INVISIBLE);
                f5.setVisibility(View.INVISIBLE);
                f6.setVisibility(View.INVISIBLE);
                f7.setVisibility(View.INVISIBLE);
                f8.setVisibility(View.INVISIBLE);
                f9.setVisibility(View.INVISIBLE);
                f10.setVisibility(View.INVISIBLE);
                f11.setVisibility(View.INVISIBLE);
                f1.setImageDrawable(getDrawable(R.drawable.p));
                f2.setImageDrawable(getDrawable(R.drawable.p));
                f3.setImageDrawable(getDrawable(R.drawable.p));
                f4.setImageDrawable(getDrawable(R.drawable.p));
                f5.setImageDrawable(getDrawable(R.drawable.p));
                f6.setImageDrawable(getDrawable(R.drawable.p));
                f7.setImageDrawable(getDrawable(R.drawable.p));
                f8.setImageDrawable(getDrawable(R.drawable.p));
                f9.setImageDrawable(getDrawable(R.drawable.p));
                f10.setImageDrawable(getDrawable(R.drawable.p));
                f11.setImageDrawable(getDrawable(R.drawable.p));
                Transition transition = new Fade();
                transition.setDuration(30000);
                transition.addTarget(R.id.f1);
                transition.addTarget(R.id.f2);
                transition.addTarget(R.id.f3);
                transition.addTarget(R.id.f4);
                transition.addTarget(R.id.f5);
                transition.addTarget(R.id.f6);
                transition.addTarget(R.id.f7);
                transition.addTarget(R.id.f8);
                transition.addTarget(R.id.f9);
                transition.addTarget(R.id.f10);
                transition.addTarget(R.id.f11);
                TransitionManager.beginDelayedTransition(parent, transition);
                f1.setVisibility(View.VISIBLE);
                f2.setVisibility(View.VISIBLE);
                f3.setVisibility(View.VISIBLE);
                f4.setVisibility(View.VISIBLE);
                f5.setVisibility(View.VISIBLE);
                f6.setVisibility(View.VISIBLE);
                f7.setVisibility(View.VISIBLE);
                f8.setVisibility(View.VISIBLE);
                f9.setVisibility(View.VISIBLE);
                f10.setVisibility(View.VISIBLE);
                f11.setVisibility(View.VISIBLE);


                database.getReference().child("counter").child("aartiBtn").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            aarti = (long) snapshot.getValue();
                            database.getReference().child("counter").child("aartiBtn").setValue(aarti += 1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }

        });


        //Navigation Working
//        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
//        layoutManager2.setOrientation(RecyclerView.HORIZONTAL);
//        recyclerView.setLayoutManager(layoutManager2);
//        FirebaseRecyclerOptions<MainGods> options =
//                new FirebaseRecyclerOptions.Builder<MainGods>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("/pics"), MainGods.class)
//                        .build();
//        myAdapter = new MyAdapter(options);
//        myAdapter.setMainImage(gImage);
//        myAdapter.setContext(getApplicationContext());
//        recyclerView.setAdapter(myAdapter);
//        recyclerView.setHasFixedSize(true);


    }

    private void setNotification() {

        Intent intent = new Intent(MandirMainActivity.this, NotificationReceiver.class);
        intent.putExtra("Title", title);
        intent.putExtra("Text", description);
        PendingIntent pendingIntent = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            pendingIntent = PendingIntent.getBroadcast(MandirMainActivity.this, 0, intent, PendingIntent.FLAG_MUTABLE);
        } else {
            pendingIntent = PendingIntent.getBroadcast(MandirMainActivity.this, 0, intent, 0);
        }
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        long ctime = System.currentTimeMillis();
        System.out.println("amit : " + ctime);
        long atime = 1000 * 10;

//        alarmManager.set(AlarmManager.RTC_WAKEUP,ctime + atime,pendingIntent);
//                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);

//        long notificationTimer = Long.parseLong("1676986200000");
        long notificationTimer = Long.parseLong("1677313697859");
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, notificationTimer, AlarmManager.INTERVAL_HALF_DAY, pendingIntent);


    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "NotificationChannel";
            String description = "Schedule Notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel("Notification", name, importance);
            notificationChannel.setName(name);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    //Extra methods and classes
    @Override
    public Confetto generateConfetto(Random random) {
        return new BitmapConfetto(bitmap);
    }

    private ConfettiManager getConfettiManager() {
        final ConfettiSource source = new ConfettiSource(0, -size, container.getWidth(), -size);
        Rect rect = new Rect(container.getLeft(), container.getTop(), container.getRight(), container.getBottom());
        return new ConfettiManager(getApplicationContext(), this, source, container).setVelocityX(0, velocitySlow).setVelocityY(velocityNormal, velocitySlow).setRotationalVelocity(180, 90).setBound(rect).setTouchEnabled(true);
    }

    public class SwipeListener implements View.OnTouchListener {

        GestureDetector gestureDetector;
        ArrayList<MainGods> mainGods = new ArrayList<>();

        public void getData(ArrayList<MainGods> mg) {

//            mainGods = new ArrayList<>(mg);
//            mainGods = new ArrayList<>();
            int p = 0, m = 0;
            while ((p != position.size()) && (m != mg.size())) {
                if (position.get(p) == m) {
                    mainGods.add(mg.get(m));
                    p += 1;
                    m += 1;
                } else {
                    m += 1;
                }
            }

            for (int i = 0; i < mainGods.size(); i++) {
                CircleImageView imageView = new CircleImageView(MandirMainActivity.this);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(100, 100);

                imageView.setLayoutParams(layoutParams);
                Glide.with(imageView.getContext()).load(mainGods.get(i).getGodName()).into(imageView);
                navigation.addTab(navigation.newTab().setCustomView(imageView));
            }

            navigation.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    int positionNav = navigation.getSelectedTabPosition();
                    System.out.println("navigation : " + positionNav);
                    System.out.println("navigation name : " + mainGods.get(positionNav).getGodMainName());
//                    Glide.with(gImage.getContext()).load(mainGods.get(positionNav).getGodImages().get(j).getImage()).into(gImage);
                    Glide.with(gImage.getContext()).load(mainGods.get(positionNav).getGodImages().get(j).getImage()).into(gImage);
                    i = positionNav;

                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });


            //initial
            if (mainGods.size() == 0) {
                SharedPreferences sharedPreferences = getSharedPreferences("PREFERENCES", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("FirstTimeInstall", "Edit");
                editor.apply();
                startActivity(new Intent(MandirMainActivity.this, MandirDummyActivity.class));
            } else {
                Glide.with(gImage.getContext()).load(mainGods.get(0).getGodImages().get(0).getImage()).into(gImage);
            }

        }


        public SwipeListener(View view) {
            int threshold = 0;
            int velocity_threshold = 0;


            GestureDetector.SimpleOnGestureListener listener = new GestureDetector.SimpleOnGestureListener() {

                @Override
                public boolean onDown(MotionEvent e) {
                    return true;
                }

                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    float xDiff = e2.getX() - e1.getX();
                    float yDiff = e2.getY() - e1.getY();

                    if (Math.abs(xDiff) > Math.abs(yDiff)) {
                        if (Math.abs(xDiff) > threshold && Math.abs(velocityX) > velocity_threshold) {
                            if (xDiff > 0) {
                                //Swipe Right
                                if (i != 0) {
                                    i -= 1;
                                } else {
                                    i = mainGods.size() - 1;
                                }
                                System.out.println("talength : " + i);
                                System.out.println("talength mainGod : " + mainGods.size());
//                                System.out.println("talength godImage : "+mainGods.get(i).getGodImages().size());
                                if (mainGods.size() == 0) {
                                    Toast.makeText(MandirMainActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
                                } else {
                                    Glide.with(gImage.getContext()).load(mainGods.get(i).getGodImages().get(j).getImage()).into(gImage);
                                }

                            } else {
                                //Swipe Left
                                i += 1;
                                if (i >= mainGods.size()) {
                                    i = 0;
                                }
//                                System.out.println("size : " + mainGods.size());
                                if (mainGods.size() == 0) {
                                    Toast.makeText(MandirMainActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
                                } else {
                                    Glide.with(gImage.getContext()).load(mainGods.get(i).getGodImages().get(j).getImage()).into(gImage);
                                }
//                                Glide.with(gImage.getContext()).load(mainGods.get(i).getGodImages().get(j).getImage()).into(gImage);


                            }
                        }
                    } else {
                        if (Math.abs(yDiff) > threshold && Math.abs(velocityY) > velocity_threshold) {
                            if (yDiff > 0) {
                                //Swipe Down
                                if (j != 0) {
                                    j -= 1;
                                } else {
                                    if (!mainGods.isEmpty())
                                        j = mainGods.get(0).getGodImages().size() - 1;
                                    else j = 0;
                                }

//                                Glide.with(gImage.getContext()).load(mainGods.get(i).getGodImages().get(j).getImage()).into(gImage);

                                if (mainGods.size() == 0) {
                                    Toast.makeText(MandirMainActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
                                } else {
                                    if (mainGods.get(i).getGodImages().size() <= j) {
                                        System.out.println("val : " + j);
                                        System.out.println("val size : " + mainGods.get(i).getGodImages().size());
                                        j = 0;
                                        Glide.with(gImage.getContext()).load(mainGods.get(i).getGodImages().get(j).getImage()).into(gImage);
                                        System.out.println("val : " + j);
                                        System.out.println("val size : " + mainGods.get(i).getGodImages().size());
                                    } else {
                                        System.out.println("val : " + j);
                                        System.out.println("val size : " + mainGods.get(i).getGodImages().size());
                                        Glide.with(gImage.getContext()).load(mainGods.get(i).getGodImages().get(j).getImage()).into(gImage);
                                    }
                                }


                            } else {
                                //Swipe Up
                                j += 1;
                                System.out.println("j1 val : " + j);
                                System.out.println("i1 val : " + i);

                                if (mainGods.size() == 0) {
                                    Toast.makeText(MandirMainActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
                                } else {
                                    if (j >= mainGods.get(0).getGodImages().size()) {
                                        j = 0;
                                    }
                                    System.out.println("j2 val : " + j);
                                    System.out.println("i2 val : " + i);
//                                Glide.with(gImage.getContext()).load(mainGods.get(i).getGodImages().get(j).getImage()).into(gImage);

                                    if (mainGods.get(i).getGodImages().size() <= j) {
                                        j = 0;
                                        Glide.with(gImage.getContext()).load(mainGods.get(i).getGodImages().get(j).getImage()).into(gImage);
                                    } else {
                                        Glide.with(gImage.getContext()).load(mainGods.get(i).getGodImages().get(j).getImage()).into(gImage);
                                    }

                                    System.out.println("j3 val : " + j);
                                }

                            }
                        }
                    }

                    return false;
                }
            };
            gestureDetector = new GestureDetector(listener);
            view.setOnTouchListener(this);
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
    }


}