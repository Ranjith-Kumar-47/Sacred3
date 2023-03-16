package com.pujagoodies.sacred;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ViewData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        ImageView imageViewDisplay = findViewById(R.id.imageViewDisplay);
        TextView titleDisplay = findViewById(R.id.displayTitle);
        TextView descriptionDisplay = findViewById(R.id.displayLongDescription);


        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String longDescription = intent.getStringExtra("longDescription");
        String imageUrl = intent.getStringExtra("imageUrl");

        titleDisplay.setText(title);
        descriptionDisplay.setText(longDescription);
        Glide.with(this).load(imageUrl).into(imageViewDisplay);

    }
}