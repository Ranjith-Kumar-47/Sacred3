package com.pujagoodies.sacred;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

//import com.example.playvideota.R;
import com.pujagoodies.sacred.R;

public class AdminDashboard extends AppCompatActivity {

    ImageView rashiphalAdminImageView, pachangAdminImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        rashiphalAdminImageView = findViewById(R.id.rashiphalAdminImageView);
        pachangAdminImageView = findViewById(R.id.pachangAdminImageView);

        rashiphalAdminImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this, AdminRashiphal.class );
                startActivity(intent);
            }
        });

        pachangAdminImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this, AdminPanchang.class );
                startActivity(intent);
            }
        });
    }
}