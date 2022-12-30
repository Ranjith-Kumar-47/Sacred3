package com.pujagoodies.sacred;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.playvideota.R;

public class PanchangAboutGanesh extends AppCompatActivity {

    ImageView jan,feb,mar,april,may,june,july,aug,sep,oct,nov,dec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panchang_about_ganesh);

        jan = findViewById(R.id.janImageView);
        feb = findViewById(R.id.febcalenderImageView);
        mar = findViewById(R.id.marcalenderImageView);
        april = findViewById(R.id.aprilcalenderImageView);
        may = findViewById(R.id.maycalenderImageView);
        june = findViewById(R.id.junecalenderImageView);
        july = findViewById(R.id.julycalenderImageView);
        aug = findViewById(R.id.augcalenderImageView);
        sep = findViewById(R.id.sepcalenderImageView);
        oct = findViewById(R.id.octcalenderImageView);
        nov = findViewById(R.id.novcalenderImageView);
        dec = findViewById(R.id.deccalenderImageView);

        jan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanchangAboutGanesh.this, PanchangImageActivity.class);
                intent.putExtra("month","gjan");
                startActivity(intent);
            }
        });

        feb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanchangAboutGanesh.this, PanchangImageActivity.class);
                intent.putExtra("month","gfeb");
                startActivity(intent);
            }
        });

        mar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanchangAboutGanesh.this, PanchangImageActivity.class);
                intent.putExtra("month","gmar");
                startActivity(intent);
            }
        });

        april.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanchangAboutGanesh.this, PanchangImageActivity.class);
                intent.putExtra("month","gapril");
                startActivity(intent);
            }
        });

        may.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanchangAboutGanesh.this, PanchangImageActivity.class);
                intent.putExtra("month","gmay");
                startActivity(intent);
            }
        });

        june.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanchangAboutGanesh.this, PanchangImageActivity.class);
                intent.putExtra("month","gjune");
                startActivity(intent);
            }
        });

        july.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanchangAboutGanesh.this, PanchangImageActivity.class);
                intent.putExtra("month","gjuly");
                startActivity(intent);
            }
        });

        aug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanchangAboutGanesh.this, PanchangImageActivity.class);
                intent.putExtra("month","gaug");
                startActivity(intent);
            }
        });

        sep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanchangAboutGanesh.this, PanchangImageActivity.class);
                intent.putExtra("month","gsep");
                startActivity(intent);
            }
        });

        oct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanchangAboutGanesh.this, PanchangImageActivity.class);
                intent.putExtra("month","goct");
                startActivity(intent);
            }
        });

        nov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanchangAboutGanesh.this, PanchangImageActivity.class);
                intent.putExtra("month","gnov");
                startActivity(intent);
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PanchangAboutGanesh.this, PanchangImageActivity.class);
                intent.putExtra("month","gdec");
                startActivity(intent);
            }
        });

    }
}