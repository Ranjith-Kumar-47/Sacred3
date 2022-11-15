package com.example.playvideota;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class AdminPanchang extends AppCompatActivity {

    ImageView pachangDailyImageView;
    EditText panchangDailyTitleTextView, panchangDailyTitleDescriptionTextView, panchangDailyFestivalTextView;
    FirebaseStorage storage;
    FirebaseDatabase database;
    Button submitPanchangButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panchang);

        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();

        pachangDailyImageView = findViewById(R.id.pachangDailyImageView);
        panchangDailyFestivalTextView = findViewById(R.id.panchangDailyFestivalTextView);
        panchangDailyTitleDescriptionTextView = findViewById(R.id.panchangDailyTitleDescriptionTextView);
        panchangDailyTitleTextView = findViewById(R.id.panchangDailyTitleTextView);
        submitPanchangButton = findViewById(R.id.submitPanchangButton);

        pachangDailyImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 22);
            }
        });

        submitPanchangButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String panchangTitle = panchangDailyTitleTextView.getText().toString();
                String panchangDescription = panchangDailyTitleDescriptionTextView.getText().toString();
                String panchangFestival = panchangDailyFestivalTextView.getText().toString();

                submitPanchangButton.setVisibility(View.GONE);

                if (panchangTitle.equalsIgnoreCase(null) || panchangDescription.equalsIgnoreCase("") || panchangFestival.equalsIgnoreCase("")) {
                    Toast.makeText(AdminPanchang.this, "All Field is Mandatory", Toast.LENGTH_SHORT).show();
                    submitPanchangButton.setVisibility(View.VISIBLE);
                } else {
                    database.getReference().child("Panchang")
                            .child("daily_panchang")
                            .child("panchang_title")
                            .setValue(panchangTitle);

                    database.getReference().child("Panchang")
                            .child("daily_panchang")
                            .child("panchang_description")
                            .setValue(panchangDescription);

                    database.getReference().child("Panchang")
                            .child("daily_panchang")
                            .child("panchang_festival")
                            .setValue(panchangFestival).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(AdminPanchang.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                                    submitPanchangButton.setVisibility(View.VISIBLE);
                                }
                            });

                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data.getData() != null) {
            Uri uri = data.getData();
            pachangDailyImageView.setImageURI(uri);


            final StorageReference reference = storage.getReference()
                    .child("panchang")
                    .child("daily_panchang")
                    .child("daily_panchang_image");

            reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            database.getReference()
                                    .child("Panchang")
                                    .child("daily_panchang")
                                    .child("daily_panchang_image")
                                    .setValue(uri.toString());
                        }
                    });


                    Toast.makeText(AdminPanchang.this, "Daily panchang Image Updated", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}