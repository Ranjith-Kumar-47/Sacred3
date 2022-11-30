package com.example.playvideota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.style.IconMarginSpan;
import android.view.View;
import android.widget.ImageView;

public class PanchangImageActivity extends AppCompatActivity {

    ImageView panchangImageView, panchangCancleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panchang_image);

        panchangImageView = findViewById(R.id.panchangImageView);
        panchangCancleImageView = findViewById(R.id.panchangCancleImgeView);

        panchangCancleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String imageId = getIntent().getStringExtra("month");

        if(imageId.equalsIgnoreCase("jan")){
            panchangImageView.setImageResource(R.drawable.ta_jan);
        }else if(imageId.equalsIgnoreCase("feb")){
            panchangImageView.setImageResource(R.drawable.ta_feb);
        }else if(imageId.equalsIgnoreCase("mar")){
            panchangImageView.setImageResource(R.drawable.ta_march);
        }else if(imageId.equalsIgnoreCase("april")){
            panchangImageView.setImageResource(R.drawable.ta_april);
        }else if(imageId.equalsIgnoreCase("may")){
            panchangImageView.setImageResource(R.drawable.ta_may);
        }else if(imageId.equalsIgnoreCase("june")){
            panchangImageView.setImageResource(R.drawable.ta_june);
        }else if(imageId.equalsIgnoreCase("july")){
            panchangImageView.setImageResource(R.drawable.ta_july);
        }else if(imageId.equalsIgnoreCase("aug")){
            panchangImageView.setImageResource(R.drawable.ta_aug);
        }else if(imageId.equalsIgnoreCase("sep")){
            panchangImageView.setImageResource(R.drawable.ta_sep);
        }else if(imageId.equalsIgnoreCase("oct")){
            panchangImageView.setImageResource(R.drawable.ta_oct);
        }else if(imageId.equalsIgnoreCase("nov")){
            panchangImageView.setImageResource(R.drawable.ta_nov);
        }else if(imageId.equalsIgnoreCase("dec")){
            panchangImageView.setImageResource(R.drawable.ta_dec);
        }else if(imageId.equalsIgnoreCase("gjan")){
            panchangImageView.setImageResource(R.drawable.gc0001);
        }else if(imageId.equalsIgnoreCase("gfeb")){
            panchangImageView.setImageResource(R.drawable.gc0002);
        }else if(imageId.equalsIgnoreCase("gmar")){
            panchangImageView.setImageResource(R.drawable.gc0003);
        }else if(imageId.equalsIgnoreCase("gapril")){
            panchangImageView.setImageResource(R.drawable.gc0004);
        }else if(imageId.equalsIgnoreCase("gmay")){
            panchangImageView.setImageResource(R.drawable.gc0005);
        }else if(imageId.equalsIgnoreCase("gjune")){
            panchangImageView.setImageResource(R.drawable.gc0006);
        }else if(imageId.equalsIgnoreCase("gjuly")){
            panchangImageView.setImageResource(R.drawable.gc0007);
        }else if(imageId.equalsIgnoreCase("gaug")){
            panchangImageView.setImageResource(R.drawable.gc0008);
        }else if(imageId.equalsIgnoreCase("gsep")){
            panchangImageView.setImageResource(R.drawable.gc0010);
        }else if(imageId.equalsIgnoreCase("goct")){
            panchangImageView.setImageResource(R.drawable.gc0011);
        }else if(imageId.equalsIgnoreCase("gnov")){
            panchangImageView.setImageResource(R.drawable.gc0012);
        }else if(imageId.equalsIgnoreCase("gdec")){
            panchangImageView.setImageResource(R.drawable.gc0002);
        }


    }
}