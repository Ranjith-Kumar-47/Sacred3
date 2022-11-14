package com.example.playvideota;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

public class AdminRashiphalAddData extends AppCompatActivity {
    FirebaseFirestore db;
    FirebaseDatabase database;
    Button submitRashipal;
    TextView rashiTextView;
    EditText rashiphalDataTextview;
    String rashiData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_rashiphal_add_data);

        db = FirebaseFirestore.getInstance();
        database = FirebaseDatabase.getInstance();
        rashiData = getIntent().getStringExtra("Rashipal");

        submitRashipal = findViewById(R.id.submitRashiphalButton);
        rashiphalDataTextview = findViewById(R.id.rashiphalDataTextview);

        submitRashipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Data : "+rashiphalDataTextview.getText().toString());
                if(rashiphalDataTextview.getText().toString() != null){
                    database.getReference().child("Rashipal")
                            .child(rashiData)
                            .setValue(rashiphalDataTextview.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(AdminRashiphalAddData.this, "Added to database", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });



        String RashipalImage = getIntent().getStringExtra("RashipalImage");

        rashiTextView = findViewById(R.id.rashiTextView);
        rashiTextView.setText(rashiData);




        if(rashiData.toLowerCase().equalsIgnoreCase("Aquarius"))
        {
            rashiphalDataTextview.setBackgroundResource(R.drawable.aquarius);
        }else if(rashiData == "Aries")
        {
            rashiphalDataTextview.setBackgroundResource(R.drawable.aries);
        }else if(rashiData.toLowerCase().equalsIgnoreCase("Cancer"))
        {
            rashiphalDataTextview.setBackgroundResource(R.drawable.cancer);
        }else if(rashiData.toLowerCase().equalsIgnoreCase("Capricon"))
        {
            rashiphalDataTextview.setBackgroundResource(R.drawable.capriconorg);
        }else if(rashiData.toLowerCase().equalsIgnoreCase("Gemini"))
        {
            rashiphalDataTextview.setBackgroundResource(R.drawable.gemini);
        }else if(rashiData.toLowerCase().equalsIgnoreCase("Libra"))
        {
            rashiphalDataTextview.setBackgroundResource(R.drawable.libra);
        }else if(rashiData.toLowerCase().equalsIgnoreCase("Leo"))
        {
            rashiphalDataTextview.setBackgroundResource(R.drawable.lio);
        }else if(rashiData.toLowerCase().equalsIgnoreCase("Pisces"))
        {
            rashiphalDataTextview.setBackgroundResource(R.drawable.pisces);
        }else if(rashiData.toLowerCase().equalsIgnoreCase("Taurus"))
        {
            rashiphalDataTextview.setBackgroundResource(R.drawable.taurus);
        }else if(rashiData.toLowerCase().equalsIgnoreCase("Virgo"))
        {
            rashiphalDataTextview.setBackgroundResource(R.drawable.virgo);
        }else if(rashiData.toLowerCase().equalsIgnoreCase("Sagittarius"))
        {
            rashiphalDataTextview.setBackgroundResource(R.drawable.zodiac_sagarithus);
        }










    }
}