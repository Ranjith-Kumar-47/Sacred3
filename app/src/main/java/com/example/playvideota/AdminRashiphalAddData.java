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

        submitRashipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rashiphalDataTextview.getText() != null){
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







    }
}