package com.pujagoodies.sacred;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

//import com.example.playvideota.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pujagoodies.sacred.R;
import com.pujagoodies.sacred.adapter.NotificationReceiver;

import java.util.Calendar;

public class AdminDashboard extends AppCompatActivity {

    ImageView rashiphalAdminImageView, pachangAdminImageView, notificationAdminImageView;

    TextView selectedTimeTextView;
    FirebaseDatabase database;
    Calendar calendar;
    int hour = 0;
    int minute  = 0;
    EditText notificationTitle,notificationDescription;
    private String title = "प्रात:काल पूजा का समय";
    private String description = "अपने देवी - देवताओं के पूजा करे";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

//        database  = FirebaseDatabase.getInstance();
//
//        database.getReference().child("notification")
//                .child("notificationTitle")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()){
//                            title =  snapshot.getValue().toString();
//                            System.out.println("database notification title : "+title);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

//        database.getReference().child("notification")
//                .child("notificationDescription")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        if(snapshot.exists()){
//                            description =  snapshot.getValue().toString();
//                            System.out.println("database notification description : "+description);
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

        createNotificationChannel();

        rashiphalAdminImageView = findViewById(R.id.rashiphalAdminImageView);
        pachangAdminImageView = findViewById(R.id.pachangAdminImageView);
        notificationAdminImageView = findViewById(R.id.notificationAdminImageView);
        selectedTimeTextView = findViewById(R.id.selectedTimeTextView);
        notificationTitle = findViewById(R.id.notificationTitle);
        notificationDescription = findViewById(R.id.notificationDescription);



        rashiphalAdminImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this, AdminRashiphal.class);
                startActivity(intent);
            }
        });

        pachangAdminImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this, AdminPanchang.class);
                startActivity(intent);
            }
        });

// to show time picker
//        selectedTimeTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Calendar c = Calendar.getInstance();
//
//                calendar = Calendar.getInstance();
//
//                // on below line we are getting our hour, minute.
//                hour = calendar.get(Calendar.HOUR_OF_DAY);
//                minute = calendar.get(Calendar.MINUTE);
//
//                // on below line we are initializing our Time Picker Dialog
//                TimePickerDialog timePickerDialog = new TimePickerDialog(AdminDashboard.this,
//                        new TimePickerDialog.OnTimeSetListener() {
//                            @Override
//                            public void onTimeSet(TimePicker view, int hourOfDay,
//                                                  int minute) {
//                                // on below line we are setting selected time
//                                // in our text view.
//                                selectedTimeTextView.setText(hourOfDay + ":" + minute);
//
//
//                                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
//                                calendar.set(Calendar.MINUTE,minute);
//                                calendar.set(Calendar.SECOND,0);
//                                calendar.set(Calendar.MILLISECOND,0);
//
//                                database.getReference().child("notification")
//                                        .child("notificationTime")
//                                        .setValue(calendar.getTimeInMillis()).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                            @Override
//                                            public void onSuccess(Void unused) {
//                                                Toast.makeText(AdminDashboard.this, "Now Click Notification Bell ", Toast.LENGTH_SHORT).show();
//                                            }
//                                        });
//                            }
//                        }, hour, minute, false);
//
//                System.out.println("amit time : "+calendar.getTimeInMillis());
//
//                // at last we are calling show to
//                // display our time picker dialog.
//                timePickerDialog.show();
//            }
//        });


//        notificationAdminImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Processing...", Toast.LENGTH_SHORT).show();
//                setNotification();
//            }
//        });


        setNotification();
    }

    private void setNotification() {

//        if(notificationTitle.getText().toString() != null){
//            database.getReference().child("notification")
//                    .child("notificationTitle")
//                    .setValue(notificationTitle.getText().toString());
//        }
//
//        if(notificationDescription.getText().toString() != null){
//            database.getReference().child("notification")
//                    .child("notificationDescription")
//                    .setValue(notificationDescription.getText().toString());
//        }





        Intent intent = new Intent(AdminDashboard.this, NotificationReceiver.class);
        intent.putExtra("Title",title);
        intent.putExtra("Text",description);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(AdminDashboard.this,0,intent,0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        long ctime = System.currentTimeMillis();
        System.out.println("amit : "+ctime);
        long atime = 1000 * 10;
//        interval += calendar.getTimeInMillis();
//                alarmManager.set(AlarmManager.RTC_WAKEUP,ctime + atime,pendingIntent);
//                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
        long notificationTimer = Long.parseLong("1676986200000");

//        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,notificationTimer,AlarmManager.INTERVAL_HALF_DAY,pendingIntent);

//        database.getReference().child("notification")
//                .child("notificationTime")
//                        .addListenerForSingleValueEvent(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                if(snapshot.exists()){
////                                    long notificationTimer = (long) snapshot.getValue();
//                                    long notificationTimer = Long.parseLong("1676986200000");
//                                    System.out.println("database time : "+notificationTimer);
//
////                                    alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,notificationTimer,AlarmManager.INTERVAL_HALF_DAY,pendingIntent);
//                                    alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,notificationTimer,AlarmManager.INTERVAL_HALF_DAY,pendingIntent);
//                                    Toast.makeText(getApplicationContext(), "Notification Added", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError error) {
//
//                            }
//                        });

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
}