package com.example.playvideota;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}