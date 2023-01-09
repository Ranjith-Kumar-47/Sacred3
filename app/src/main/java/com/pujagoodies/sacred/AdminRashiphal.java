package com.pujagoodies.sacred;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//import com.example.playvideota.R;
import com.pujagoodies.sacred.R;

public class AdminRashiphal extends AppCompatActivity {

    CardView Aquarius,Aries,Cancer,Capricon,Gemini,Libra,Leo,Pisces,Taurus,Virgo,Sagittarius, Scorpio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_rashiphal);


        initialiseData();
        clickHalderOnRashi();




    }

    private void clickHalderOnRashi() {
        Aquarius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminRashiphal.this, AdminRashiphalAddData.class);
                intent.putExtra("Rashipal","Aquarius");
                intent.putExtra("RashipalImage","R.drawable.aquarius");
                startActivity(intent);
            }
        });

        Aries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminRashiphal.this, AdminRashiphalAddData.class);
                intent.putExtra("Rashipal","Aries");
                intent.putExtra("RashipalImage","virgo");
                startActivity(intent);
            }
        });

        Cancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminRashiphal.this, AdminRashiphalAddData.class);
                intent.putExtra("Rashipal","Cancer");
                intent.putExtra("RashipalImage","virgo");
                startActivity(intent);
            }
        });

        Capricon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminRashiphal.this, AdminRashiphalAddData.class);
                intent.putExtra("Rashipal","Capricon");
                intent.putExtra("RashipalImage","virgo");
                startActivity(intent);
            }
        });

        Gemini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminRashiphal.this, AdminRashiphalAddData.class);
                intent.putExtra("Rashipal","Gemini");
                intent.putExtra("RashipalImage","virgo");
                startActivity(intent);
            }
        });

        Libra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminRashiphal.this, AdminRashiphalAddData.class);
                intent.putExtra("Rashipal","Libra");
                intent.putExtra("RashipalImage","virgo");
                startActivity(intent);
            }
        });

        Leo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminRashiphal.this, AdminRashiphalAddData.class);
                intent.putExtra("Rashipal","Leo");
                intent.putExtra("RashipalImage","virgo");
                startActivity(intent);
            }
        });

        Pisces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminRashiphal.this, AdminRashiphalAddData.class);
                intent.putExtra("Rashipal","Pisces");
                intent.putExtra("RashipalImage","virgo");
                startActivity(intent);
            }
        });

        Taurus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminRashiphal.this, AdminRashiphalAddData.class);
                intent.putExtra("Rashipal","Taurus");
                intent.putExtra("RashipalImage","virgo");
                startActivity(intent);
            }
        });

        Virgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminRashiphal.this, AdminRashiphalAddData.class);
                intent.putExtra("Rashipal","Virgo");
                intent.putExtra("RashipalImage","virgo");
                startActivity(intent);
            }
        });

        Sagittarius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminRashiphal.this, AdminRashiphalAddData.class);
                intent.putExtra("Rashipal","Sagittarius");
                intent.putExtra("RashipalImage","zodiac_sagarithus");
                startActivity(intent);
            }
        });

        Scorpio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminRashiphal.this, AdminRashiphalAddData.class);
                intent.putExtra("Rashipal","Scorpio");
                intent.putExtra("RashipalImage","scorpio");
                startActivity(intent);
            }
        });


    }

    private void initialiseData() {
        Aquarius = findViewById(R.id.Aquarius);
        Aries = findViewById(R.id.Aries);
        Cancer = findViewById(R.id.Cancer);
        Capricon = findViewById(R.id.Capricon);
        Gemini = findViewById(R.id.Gemini);
        Libra = findViewById(R.id.Libra);
        Leo = findViewById(R.id.Leo);
        Pisces = findViewById(R.id.Pisces);
        Taurus = findViewById(R.id.Taurus);
        Virgo = findViewById(R.id.Virgo);
        Sagittarius = findViewById(R.id.Sagittarius);
        Scorpio = findViewById(R.id.Scorpio);
    }
}