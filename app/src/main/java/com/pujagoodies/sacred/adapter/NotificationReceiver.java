package com.pujagoodies.sacred.adapter;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.pujagoodies.sacred.MainActivity;
import com.pujagoodies.sacred.R;

public class NotificationReceiver extends BroadcastReceiver {

    Context context;

    String CHANNEL_ID = "Notification";

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


        // get Notification ID and Name
        int id = intent.getIntExtra("ID", 0);
        String title = intent.getStringExtra("Title");
        String text = intent.getStringExtra("Text");

        Intent intent1 = new Intent(context, MainActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, id, intent1, PendingIntent.FLAG_IMMUTABLE);


//        createNotificationChannel();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.logov2)
                .setContentTitle(title)
                .setShowWhen(true)
                .setAutoCancel(true)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_HIGH);


        notificationManager.notify(id, builder.build());

    }

    //create notification channel for android 8.0 or higher to deliver notification
//    private void createNotificationChannel() {
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//
//            CharSequence name = "Notification";
//            String description = "Schedule Notification";
//            int importance = NotificationManager.IMPORTANCE_DEFAULT;
//
//            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);
//            notificationChannel.setDescription(description);
//
//            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
//            notificationManager.createNotificationChannel(notificationChannel);
//
//        }
//    }
}
